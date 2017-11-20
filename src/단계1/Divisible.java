package 단계1;

import java.util.ArrayList;
import java.util.Arrays;

class Divisible {
	public int[] divisible(int[] array, int divisor) {
		//ret�� array�� ���Ե� ������, divisor�� ������ �������� ���ڸ� ������� ��������.
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] % divisor == 0) {
				list.add(array[i]);
			}
		}
		
		int[] ret = list.stream().mapToInt(i -> i).toArray();
		
		return ret;
	}
	// �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
	public static void main(String[] args) {
		Divisible div = new Divisible();
		int[] array = {5, 9, 7, 10};
		System.out.println( Arrays.toString( div.divisible(array, 5) ));
	}
}
