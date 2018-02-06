package 백준.트리;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//11725번(트리의 부모 찾기, 시간초과)

public class FindParents {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		int[] parentArr = new int[tc + 1];
		boolean[] hasParent = new boolean[tc + 1];
		hasParent[1] = true;
		
		List<Pair> list = new LinkedList<>();
		
		for(int i = 1; i < tc; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			if(!hasParent[first] && !hasParent[second]) {
				list.add(new Pair(first, second));
				continue;
			}
			
			if(hasParent[first]) {
				parentArr[second] = first;
				hasParent[second] = true;
			} else {
				parentArr[first] = second;
				hasParent[first] = true;
			}
		}
		
		Iterator<Pair> iter = list.iterator();
		
		while(!list.isEmpty()) {
			while(iter.hasNext()) {
				Pair item = iter.next();
				
				if(!hasParent[item.first] && !hasParent[item.second]) {
					continue;
				}
				
				if(hasParent[item.first]) {
					parentArr[item.second] = item.first;
					hasParent[item.second] = true;
				} else {
					parentArr[item.first] = item.second;
					hasParent[item.first] = true;
				}
				
				iter.remove();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 2; i < parentArr.length; i++) {
			sb.append(parentArr[i]);
			sb.append(System.lineSeparator());
		}
		
		System.out.println(sb);
		sc.close();
	}

}

class Pair {
	int first;
	int second;
	
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
