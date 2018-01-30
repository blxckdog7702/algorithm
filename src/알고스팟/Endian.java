package 알고스팟;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

//https://algospot.com/judge/problem/read/ENDIANS

public class Endian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < tc; i++) {
			String input = sc.nextLine();
			// unsignedInt로 형변환
			int vInt = Integer.parseUnsignedInt(input);
			// int형 크기만큼 버퍼 할당 후 입력값 넣음
			ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES).putInt(vInt);
			// ByteOrder 변환
			if (buffer.order() == ByteOrder.BIG_ENDIAN) {
				buffer = buffer.order(ByteOrder.LITTLE_ENDIAN);
			} else {
				buffer = buffer.order(ByteOrder.BIG_ENDIAN);
			}
			// 버퍼에서 출력하기 위해 position 0으로 세팅
			buffer.position(0);
			int result = buffer.getInt();
			// unsignedString으로 출력
			System.out.println(Integer.toUnsignedString(result));
		}

		sc.close();
	}

}
