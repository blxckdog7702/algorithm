package 백준.시뮬레이션;

import java.util.Scanner;

//1024번(수열의 합)

public class ProgressionSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int l = sc.nextInt();
		sc.close();
		
		while(true) {
			if(l > 100) {
				System.out.println(-1);
				return;
			}
			
			// 길이 L이 짝수면 x - 1, x, x + 1, x + 2 꼴로 만들어지는지 확인한다.
			if(l % 2 == 0) {
				if(n == (n / l) * l + (l / 2)) {
					break;
				}
			}
			// 길이 L이 홀수면 x - 1, x , x + 1 꼴로 만들어지는지 확인한다.
			else {
				if(n == (n / l) * l) {
					break;
				}
			}
			
			l++;
		}
		
		int middle = (n / l);
		int start;
		int end;
		
		if (l % 2 == 0) {
			start = middle - (l / 2) + 1;
			end = middle + (l / 2);
		} else {
			start = middle - (l / 2);
			end = middle + (l / 2);
		}
		
		if(start < 0) {
			System.out.println(-1);
			return;
		}
		
		for(int i = start; i <= end; i++) {
			System.out.print(i + " ");
		}
	}

}
