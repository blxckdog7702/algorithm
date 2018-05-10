//#include<iostream>
//
//using namespace std;
//
//void swap(int* a, int* b);
//void quicksort(int low, int high, int s[]);
//
//int main() {
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
//	int pivot = low;
//	int j = low;
//	int i = low + 1;
//
//	if (low < high) {
//		for (; i <= high; i++) {
//			if (s[pivot] > s[i]) {
//				j++;
//				swap(&s[j], &s[i]);
//			}
//		}
//
//		swap(&s[low], &s[j]);
//		pivot = j;
//
//		quicksort(low, pivot - 1, s);
//		quicksort(pivot + 1, high, s);
//	}
//}
//
//void swap(int* a, int* b) {
//	int temp;
//	temp = *a;
//	*a = *b;
//	*b = temp;
//}