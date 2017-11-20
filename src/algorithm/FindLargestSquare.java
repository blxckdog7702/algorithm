package algorithm;

public class FindLargestSquare {

	public int findLargestSquare(char [][]board)
    {
		int temp = 0;
		int answer = 0;
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				temp = FindSquare(board, i, j, 1);
				if(answer < temp) {
					answer = temp;
				}
			}
		}

        return answer;
    }
	private int FindSquare(char[][] board, int y, int x, int count) {
		
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < count; j++) {
				if(y + i > board.length - 1 || x + j > board[0].length - 1) {
					return (count - 1) * (count -1);
				}
				
				if(board[y + i][x + j] == 'X') {
					return (count - 1) * (count -1);
				}
			}
		}
		return FindSquare(board, y, x, count + 1);
	}
	
    public static void main(String[] args)
    {
        FindLargestSquare test = new FindLargestSquare();
				char [][]board ={
				{'O','X','X','X','X'},
				{'O','O','O','O','O'},
				{'O','O','O','O','O'},
				{'O','O','O','O','O'},
				{'O','O','O','O','O'},
				{'O','O','O','O','O'}};

        System.out.println(test.findLargestSquare(board));
    }
}
