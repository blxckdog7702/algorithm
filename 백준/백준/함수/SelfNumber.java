package 백준.함수;

//4673번(셀프 넘버)

public class SelfNumber {

	public static void main(String[] args) {
		boolean[] arr = new boolean[10000];
		
		int temp = 0;
		
		for(int i = 1; i < 10000; i++) {
			temp = i;
			
			for(int j = 4; j > 0; j--) {
				temp += (i % Math.pow(10, j)) / Math.pow(10, j - 1);
			}
			
			if(temp < 10000) {
				arr[temp] = true;
			}
		}
		
		for(int i = 1; i < 10000; i++) {
			if(arr[i] == false) {
				System.out.println(i);
			}
		}
	}
}
