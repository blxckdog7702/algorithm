package 단계1;

class StringExercise{
    String getMiddle(String word){
    	if(word.length() % 2 == 0) {
    		return word.substring(word.length() / 2 - 1, word.length() / 2 + 1);
    	} else {
    		return word.substring(word.length() / 2, word.length() / 2 + 1);
    	}
    }
    // �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
    public static void  main(String[] args){
        StringExercise se = new StringExercise();
        System.out.println(se.getMiddle("power"));
    }
}