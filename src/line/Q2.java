package line;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q2 {

	/**
	 * Time complexity: Space complexity:
	 */
	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
			int userX = Integer.parseInt(tokens.nextToken());
			int userY = Integer.parseInt(tokens.nextToken());
			int shopCount = Integer.parseInt(tokens.nextToken());

			List<Shop> list = new ArrayList<>();

			for (int i = 0; i < shopCount; i++) {
				tokens = new StringTokenizer(br.readLine().trim());
				int shopX = Integer.parseInt(tokens.nextToken());
				int shopY = Integer.parseInt(tokens.nextToken());
				String name = tokens.nextToken();
				int coupon = Integer.parseInt(tokens.nextToken());

				Shop shop = new Shop(shopX, shopY, name, coupon);
				shop.calcDist(userX, userY);
				list.add(shop);
			}
			
			Comparator<Shop> com = new Comparator<Shop>() {

				@Override
				public int compare(Shop o1, Shop o2) {
					if (o1.distance == o2.distance) {
						if(o1.coupon == o2.coupon) {
							return o1.id.compareTo(o2.id);
						} else {
							return o2.coupon - o1.coupon;
						}
						
					} else {
						return o1.distance - o2.distance;
					}
				}
			};
			
			list.sort(com);
			list.forEach(n -> System.out.println(n.toString()));
		}
	}
}

class Shop {
	int x;
	int y;
	int distance;
	String id;
	int coupon;

	public Shop(int x, int y, String id, int coupon) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.coupon = coupon;
	}

	public void calcDist(int userX, int userY) {
		int tempX = (userX - x) * (userX - x);
		int tempY = (userY - y) * (userY - y);

		int tempDist = (int) Math.sqrt(tempX + tempY);

		tempDist = tempDist - (tempDist % 100);

		distance = tempDist;
	}
	
	@Override
	public String toString() {
		return x + " " + y + " " + id + " " + coupon;
	}
}
