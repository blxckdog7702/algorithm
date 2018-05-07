package 기업대비;

/* package 구문을 넣으면 안됩니다 */
import java.util.*;
import java.io.*;

/* [Notice for Java]
 * - 기본 제공되는 뼈대 코드는 입출력의 이해를 돕기위해 제공되었습니다.
 * - 뼈대코드의 활용은 선택사항이며 코드를 직접 작성하여도 무관합니다.
 * 
 * - 별도의 병렬 처리나 시스템콜, 네트워크/파일접근 등을 하지 마세요 
 * - 입출력의 양이 많은 문제는 BufferedReader와 BufferedWriter를 사용하면 시간을 단축할 수 있습니다.
 * - 클래스 이름은 항상 Main이어야 합니다. 주의하세요.
 * - 모든 입력과 출력은 System.in과 System.out 스트림을 이용해야 합니다.
 */

public class Main {

	// 표준입력을 수행할 Scanner를 선언한다
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] height = new int[10];
		int[] weight = new int[10];
		for (int i = 0; i < 10; i++) {
			height[i] = scanner.nextInt();
			weight[i] = scanner.nextInt();
		}

		int son = 0;
		int mom = 0;

		for (int i = 0; i < 10; i++) {
			if(height[i] >= 180) {
				mom++;
			}
			
			if(height[i] >= 180 && weight[i] >= 75) {
				son++;
			}
		}
		
		if(son == 0) {
			 System.out.printf("%d/%d", 0, 1);
			 return;
		}
		
		int gcd = gcd(son, mom);
		
		if(gcd == 1) {
			 System.out.printf("%d/%d", son, mom);
		} else {
			 System.out.printf("%d/%d", son / gcd, mom / gcd);
		}

	}
	
	public static int gcd(int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);
		
		int mod = big % small;
		
		while(mod > 0) {
			big = small;
			small = mod;
			mod = big % small;
		}
		
		return small;
	}
}
