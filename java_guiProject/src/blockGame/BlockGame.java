package blockGame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class BlockGame {

	static class MyFrame extends JFrame { // static 통일

		//// constant (상수)
		// ball info
		static int BALL_WIDTH = 20;
		static int BALL_HEIGHT = 20;
		// block info
		static int BLOCK_ROWS = 5;
		static int BLOCK_COLUMNS = 10;
		static int BLOCK_WIDTH = 40;
		static int BLOCK_HEIGHT = 20;
		static int BLOCK_GAP = 3;
		// bar info
		static int BAR_WIDTH = 80;
		static int BAR_HEIGHT = 20;
		// canvas info
		static int CANVAS_WIDTH = 400 + (BLOCK_GAP * BLOCK_COLUMNS) - BLOCK_GAP + 17; // 오른쪽 끝 갭 제거 --> 427
		static int CANVAS_HEIGHT = 600;

		//// variable (변수)
		static MyPanel myPanel = null;
		static int score = 0;
		static Timer timer = null;
		static Block[][] blocks = new Block[BLOCK_ROWS][BLOCK_COLUMNS];
		static Bar bar = new Bar();
		static Ball ball = new Ball();
		static int barXTarget = bar.x; // Target Value - interpolation
		static int dir = 0; // 0 : up-right, 1 : down-right, 2 : up-left, 3 : down-left --> 공이 움직일 4가지 방향 (대각선 방향으로 움직임)
		static int ballSpeed = 5;
		static boolean isGameCompleted = false;
		static boolean isGameOver = false;

		//// class
		// ball class info
		static class Ball {
			// ball position
			int x = (CANVAS_WIDTH / 2) - (BALL_WIDTH / 2);
			int y = (CANVAS_HEIGHT / 2) - (BALL_HEIGHT / 2);
			int width = BALL_WIDTH;
			int height = BALL_HEIGHT;

			Point getCenter() {
				return new Point(x + (BALL_WIDTH / 2), y + (BALL_HEIGHT / 2));
			}

			Point getBottomCenter() {
				return new Point(x + (BALL_WIDTH / 2), y + BALL_HEIGHT);
			}

			Point getTopCenter() {
				return new Point(x + (BALL_WIDTH / 2), y);
			}

			Point getLeftCenter() {
				return new Point(x, y + (BALL_HEIGHT / 2));
			}

			Point getRightCenter() {
				return new Point(x + BALL_WIDTH, y + (BALL_HEIGHT / 2));
			}
		}

		// bar class info
		static class Bar {
			int x = (CANVAS_WIDTH / 2) - (BAR_WIDTH / 2);
			int y = CANVAS_HEIGHT - 100;
			int width = BAR_WIDTH;
			int height = BAR_HEIGHT;
		}

		// block class info
		static class Block {
			int x = 0;
			int y = 0;
			int width = BLOCK_WIDTH;
			int height = BLOCK_HEIGHT;
			int color = 0; // 0 : white, 1 : yellow, 2 : blue, 3 : mazanta, 4 : red --> block color --> score 0 << 4
			boolean isHidden = false; // 충돌 후 블록이 사라짐
		}

		// panel class info (UI)
		static class MyPanel extends JPanel { // canvas for draw
			public MyPanel() {
				this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
				this.setBackground(Color.BLACK);
			}

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				// 그래픽 지원
				Graphics2D g2d = (Graphics2D) g;

				drawUI(g2d);
			}

			// UI 그리기
			private void drawUI(Graphics2D g2d) {
				// draw blocks
				for (int i = 0; i < BLOCK_ROWS; i++) {
					for (int j = 0; j < BLOCK_COLUMNS; j++) {
						if (blocks[i][j].isHidden) {
							continue;
						}
						if (blocks[i][j].color == 0) {
							g2d.setColor(Color.WHITE);
						} else if (blocks[i][j].color == 1) {
							g2d.setColor(Color.YELLOW);
						} else if (blocks[i][j].color == 2) {
							g2d.setColor(Color.BLUE);
						} else if (blocks[i][j].color == 3) {
							g2d.setColor(Color.MAGENTA);
						} else if (blocks[i][j].color == 4) {
							g2d.setColor(Color.RED);
						}

						// fillRect : 사각형 그리기
						g2d.fillRect(blocks[i][j].x, blocks[i][j].y, blocks[i][j].width, blocks[i][j].height);
					}
				}

				// draw score
				g2d.setColor(Color.WHITE);
				g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
				if (isGameCompleted) {
					g2d.drawString("score : " + score, CANVAS_WIDTH / 2 - 60, 20);
					g2d.drawString("Game Complete !", CANVAS_WIDTH / 2 - 85, 50);
				}
				else {
					g2d.drawString("score : " + score, CANVAS_WIDTH / 2 - 55, 20);
				}
				
				// game over
				if (isGameOver) {
					g2d.drawString("고작 이정도냐? ㅋ", CANVAS_WIDTH / 2 - 85, CANVAS_HEIGHT / 2);
				}

				// draw ball
				g2d.setColor(Color.WHITE);
				g2d.fillOval(ball.x, ball.y, BALL_WIDTH, BALL_HEIGHT); // fillOval : 타원 그리는 함수 - width 와 height 같으면 원
																		// 그려짐

				// draw bar
				g2d.setColor(Color.WHITE);
				g2d.fillRect(bar.x, bar.y, BAR_WIDTH, BAR_HEIGHT);

			}
		}

		public MyFrame(String title) {
			super(title);
			this.setVisible(true); // this -> JFrame 를 상속받는 MyFrame
			this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT); // 창 크기 결정
//			this.setLocation(1600, 300); // 창 위치 설정
			this.setLocation(1200, 300); // 창 위치 설정
			this.setLayout(new BorderLayout()); // 전체 레이아웃 설정
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료

			// 데이터 초기화
			initData();

			myPanel = new MyPanel();
			this.add("Center", myPanel);

			// 키보드 입력
			setKeyListner();

			// 타이머
			startTimer();
		}

		// 데이터 초기화
		public void initData() {
			// 블록 설정
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					blocks[i][j] = new Block();
					blocks[i][j].x = BLOCK_WIDTH * j + BLOCK_GAP * j;
					blocks[i][j].y = 100 + BALL_HEIGHT * i + BLOCK_GAP * i;
					blocks[i][j].width = BLOCK_WIDTH;
					blocks[i][j].height = BLOCK_HEIGHT;
					blocks[i][j].color = 4 - i; // 0 : white (제일 아래), ... , 4 : red (제일 위)
					blocks[i][j].isHidden = false;
				}
			}
		}

		// 키보드 입력 -> bar 움직이기
		public void setKeyListner() {
			// 이벤트 추가
			this.addKeyListener(new KeyAdapter() { // 객체 익명 함수
				// 데이터와 UI 는 쪼개서 처리
				@Override
				public void keyPressed(KeyEvent e) { // 키보드 이벤트 입력
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println("Pressed Left Key");
						// 연속으로 키 입력 시 --> 쭉 밀려가는 현상 방지
						barXTarget -= 40; // 보간 -> -40 을 잘개 쪼개서 이동
						if (bar.x < barXTarget) {
							barXTarget = bar.x;
						}
						System.out.println("barXTarget : " + barXTarget);
//						System.out.println("bar.x : " + bar.x);
					}

					else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println("Pressed Right Key");
						barXTarget += 40;
						if (bar.x > barXTarget) {
							barXTarget = bar.x;
						}
						System.out.println("barXTarget : " + barXTarget);
//						System.out.println("bar.x : " + bar.x);
					}
				}
			});
		}

		public void startTimer() {
			timer = new Timer(10, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { // Timer Event
					movement();
					checkCollision(); // wall, bar
					checkCollisionBlock(); // 50개의 block
					myPanel.repaint(); // redraw
					
					// game completed !
					isGameCompleted();
				}
			});
			timer.start(); // start timer
		}
		
		// 50개의 block 을 다 깨면 game completed !
		public void isGameCompleted() {
			int cnt = 0;
			
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					Block block = blocks[i][j];
					if (block.isHidden) {
						cnt++;
					}
				}
			}
			if (cnt == BLOCK_ROWS * BLOCK_COLUMNS) {
				// game completed !
				isGameCompleted = true;
				ballSpeed = 0;
			}
		}

		public void movement() {
			// bar movement
			if (bar.x < barXTarget) {
				bar.x += 10;
//				System.out.println("bar.x2222222222222 : " + bar.x);
			} else if (bar.x > barXTarget) { // barXTarget 을 -40 만큼 줄이고, bar.x 가 -5만큼 줄면서 -40에 도달할때까지 Timer (익명 객체 함수) 안에서 일정시간동안 계속 함수가 진행 --> 이동이 부드럽게 보이게 보간하는 것임.
				bar.x -= 10;
//				System.out.println("bar.x2222222222222 : " + bar.x);
			}

			// ball movement
			if (dir == 0) { // up right
				ball.x += ballSpeed;
				ball.y -= ballSpeed;
			} else if (dir == 1) { // down right
				ball.x += ballSpeed;
				ball.y += ballSpeed;
			} else if (dir == 2) { // up left
				ball.x -= ballSpeed;
				ball.y -= ballSpeed;
			} else if (dir == 3) { // down left
				ball.x -= ballSpeed;
				ball.y += ballSpeed;
			}
		}

		// bar 와 ball 충돌 확인
		public boolean duplRect(Rectangle rect1, Rectangle rect2) {
			return rect1.intersects(rect2);
		}

		// wall, bar 에 부딪혔을 때 처리
		public void checkCollision() {
			if (dir == 0) { // up right
				// wall
				if (ball.y < 0) { // 위쪽 벽에 부딪혔을 때
					dir = 1;
				}
				if (ball.x > CANVAS_WIDTH - BALL_WIDTH) { // 오른쪽 벽에 부딪혔을 때
					dir = 2;
				}

				// bar -- > none
			} else if (dir == 1) { // down right
				// wall
				if (ball.y > CANVAS_HEIGHT - BALL_HEIGHT - BALL_HEIGHT) { // 아래쪽 벽에 부딪혔을 때
					dir = 0;
					
					// ball 이 바닥에 닿으면 game over !
					isGameOver = true;
					ballSpeed = 0;
				}
				if (ball.x > CANVAS_WIDTH - BALL_WIDTH) { // 오른쪽 벽에 부딪혔을 때
					dir = 3;
				}

				// bar
				if (ball.getBottomCenter().y >= bar.y) {
					if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
							new Rectangle(bar.x, bar.y, bar.width, bar.height))) {
						dir = 0;
					}
				}
			} else if (dir == 2) { // up left
				// wall
				if (ball.y < 0) { // 위쪽 벽에 부딪혔을 때
					dir = 3;
				}
				if (ball.x < 0) { // 왼쪽 벽에 부딪혔을 때
					dir = 0;
				}

				// bar --> none
			} else if (dir == 3) { // down left
				// wall
				if (ball.y > CANVAS_HEIGHT - BALL_HEIGHT - BALL_HEIGHT) { // 아래쪽 벽에 부딪혔을 때
					dir = 2;
					
					// ball 이 바닥에 닿으면 game over !
					isGameOver = true;
					ballSpeed = 0;
					
				}
				if (ball.x < 0) { // 왼쪽 벽에 부딪혔을 때
					dir = 1;
				}

				// bar
				if (ball.getBottomCenter().y >= bar.y) {
					if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
							new Rectangle(bar.x, bar.y, bar.width, bar.height))) {
						dir = 2;
					}
				}
			}
		}

		// score 계산
		public int calcScore(int score, Block block) {
			if (block.color == 0) {
				score += 10;
			}
			else if (block.color == 1) {
				score += 20;
			}
			else if (block.color == 2) {
				score += 30;
			}
			else if (block.color == 3) {
				score += 40;
			}
			else if (block.color == 4) {
				score += 50;
			}
			return score;
		}
		
		// block 충돌
		public void checkCollisionBlock() {
			// 0 : up-right, 1 : down-right, 2 : up-left, 3 : down-left
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					Block block = blocks[i][j];
					if (block.isHidden == false) { // 충돌이 안된 경우,
						if (dir == 0) { // 0 : up-right
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) { // block 의 바닥면에 부딪혔을때 (ball 의 x 좌표가 block 의 width 안에 있음.)
									dir = 1;
								}
								else { // block 의 왼쪽면에 부딪혔을 때
									dir = 2;
								}
								block.isHidden = true;
								score = calcScore(score, block);
							}
						}
						else if (dir == 1) { // 1 : down-right
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) { // block 의 윗면에 부딪혔을때
									dir = 0;
								}
								else { // block 의 왼쪽면에 부딪혔을 때
									dir = 3;
								}
								block.isHidden = true;
								score = calcScore(score, block);
							}
						}
						else if (dir == 2) { // 2 : up-left
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) { // block 의 바닥면에 부딪혔을때
									dir = 3;
								}
								else { // block 의 오른쪽면에 부딪혔을 때
									dir = 0;
								}
								block.isHidden = true;
								score = calcScore(score, block);
							}
						}
						else if (dir == 3) { // 3 : down-left
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) { // block 의 윗면에 부딪혔을때
									dir = 2;
								}
								else { // block 의 오른쪽면에 부딪혔을 때
									dir = 1;
								}
								block.isHidden = true;
								score = calcScore(score, block);
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		new MyFrame("Block Game");
	}
}
