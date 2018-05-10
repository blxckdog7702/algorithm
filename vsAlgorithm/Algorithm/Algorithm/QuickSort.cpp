//#include<string>
//#include<iostream>
//
//using namespace std;
//
//void quicksort(int low, int high, int s[]);
//void partition(int low, int high, int& pivot, int s[]);
//
//int main()
//{
//	int s[50] = {0};
//	int low, high;
//	int i, n;
//
//	cout << "입력할 개수?" << endl;
//	cin >> n;
//
//	while (n < 0 || n > 50) {
//		cout << "재입력" << endl;
//		cin >> n;
//	}
//
//	for (i = 0; i < n; i++) {
//		cin >> s[i];
//	}
//
//	low = 0;
//	high = n - 1;
//
//	quicksort(low, high, s);
//
//	for (i = 0; i < n; i++) {
//		cout << s[i] << " ";
//	}
//
//	return 0;
//
//}
//
//void quicksort(int low, int high, int s[]) {
//	int pivot;
//
//	if (high > low) {
//		partition(low, high, pivot, s);
//		// 정렬되지 않은 배열을 나눠서 재호출한다.
//		quicksort(low, pivot - 1, s);
//		quicksort(pivot + 1, high, s);
//
//	}
//}
//
//void partition(int low, int high, int& pivot, int s[]) {
//	int i, j;
//	int temp;
//	int pivotItem;
//
//	pivotItem = s[low];
//	j = low;
//	
//	for (i = low + 1; i <= high; i++) {
//		// pivot값과 [i]값 비교하여 [j]값과 서로 교환한다.
//		if (s[i] < pivotItem) {
//			j++;
//			temp = s[i];
//			s[i] = s[j];
//			s[j] = temp;
//		}
//				
//	}
//
//	// pivot값과 [j]값을 바꾼후 [j]에 있는 값을 pivot을 값을 선택 한다.
//	pivot = j;
//	temp = s[low];
//	s[low] = s[pivot];
//	s[pivot] = temp;
//
//}