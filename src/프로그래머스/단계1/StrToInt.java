package 프로그래머스.단계1;

public class StrToInt {
    public int getStrToInt(String str) {
    	int result = Integer.parseInt(str);
        return result;
    }
    
    //�Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
    public static void main(String args[]) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.getStrToInt("-1234"));
    }
}

