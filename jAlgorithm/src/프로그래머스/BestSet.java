package 프로그래머스;

import java.util.Arrays; //�׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.

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
        //�Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
        System.out.println(Arrays.toString(c.bestSet(3,13)));
    }

}