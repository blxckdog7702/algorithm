package algorithm;

import java.util.Arrays;

class ChooseCity
{
    public int chooseCity(int n, int [][]city)
    {
    	int[][] arr = city;
    	
    	Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
    	
    	int answer = arr[n - 1][0];
    	
//    	int sum = 0;
//        int answer = arr[0][0];
//
//    	for(int i = 0; i < n; i++) {
//    		int temp = 0;
//    		
//    		for(int j = 0; j < n; j++) {
//    			if(i == j) continue;
//    			
//    			int distance = Math.abs(arr[i][0] - arr[j][0]);
//    			temp = temp + distance * arr[j][1];
//    		}
//    		
//    		if(sum == 0) {
//    			sum = temp;
//    			continue;
//    		}
//    		
//    		if(sum > temp) {
//    			sum = temp;
//    			answer = arr[i][0];
//    		}
//    	}

        return answer;
    }
    public static void main(String[] args)
    {
        ChooseCity test = new ChooseCity();
        int tn = 3;
        int [][]tcity = {{1,5},{2,2},{3,3}};
        System.out.println(test.chooseCity(tn,tcity));
    }
}