package programmers;

public class Lotto {
	
	public static void main(String[] args) {
		SolutionLotto s = new SolutionLotto();
		s.solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6 ,19});
		s.solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25});
		s.solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35});
	}
}

class SolutionLotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int cntZero = 0;
        
        for (int i : lottos) {
        	for (int j : win_nums) {
        		if (i == j) {
        			cnt++;
        		}
			}
        	if (i == 0) {
        		cntZero++;
        	}
		}
        
        int max = cnt + cntZero;
        int min = cnt;
        int maxRank = 0;
        int minRank = 0;
        
        answer[0] = defineRank(max, maxRank);
        answer[1] = defineRank(min, minRank);
        
        for (int i : answer) {
			System.out.print(i + ", ");
		}
        System.out.println();
        
        return answer;
    }
    
    private int defineRank(int num, int rank) {
    	switch (num) {
		case 6:
			rank = 1;
			break;
		case 5:
			rank = 2;
			break;
		case 4:
			rank = 3;
			break;
		case 3:
			rank = 4;
			break;
		case 2:
			rank = 5;
			break;
		default:
			rank = 6;
		}
    	return rank;
	}
}
