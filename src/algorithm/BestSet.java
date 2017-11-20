package algorithm;

import java.util.Arrays; //테스트로 출력해 보기 위한 코드입니다.

public class BestSet {

    public int[] bestSet(int n, int s){
    	if(n > s) {
    		return new int[] {-1};
    	}
    	
        int[] answer = new int[n];
        
        int quotient = s / n;
        int reminder = s % n;
        
        for(int i = 0; i < n; i++) {
        	answer[i] = quotient;
        }
        
        for(int i = n - 1; reminder != 0; i--) {
        	answer[i]++;
        	reminder--;
        }
        
        return answer;
    }
    public static void main(String[] args) {
        BestSet c = new BestSet();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(Arrays.toString(c.bestSet(3,13)));
    }

}