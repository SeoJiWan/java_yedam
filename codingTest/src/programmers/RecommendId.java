package programmers;

import java.util.ArrayList;
import java.util.Iterator;

public class RecommendId {

	public static void main(String[] args) {
		SolutionRecommendId s = new SolutionRecommendId();
		s.solution("...!@BaT#*..y.abcdefghijklm");
//		s.solution("z-+.^.");
//		s.solution("=.=");
//		s.solution("123_.def");
//		s.solution("abcdefghijklmn.p");
	}
	
	
}

class SolutionRecommendId {
    public String solution(String new_id) {
    	ArrayList<String> strArr = new ArrayList<String>();
        String answer = "";
        String specialStr = "~!@#$%^&*()=+[{]}:?,<>/";
        String[] splitSpecialStr = specialStr.split("");
        
        // 1. 소문자로 변경
        new_id = new_id.toLowerCase();
        System.out.println(new_id);
        
        String[] splitId = new_id.split("");
        for (int i = 0; i < splitId.length; i++) {
			strArr.add(splitId[i]);
		}
        
        // 2. 특수문자 제거
        for (int i = 0; i < splitSpecialStr.length; i++) {
			for (int j = 0; j < strArr.size(); j++) {
				if (splitSpecialStr[i].equals(strArr.get(j))) {
					strArr.remove(j);
				}
			}
		}
        
//        for (String str : strArr) {
//			System.out.println(str);
//		}
        
        // 3. 연속된 마침표 제거
        
        return answer;
    }
}
