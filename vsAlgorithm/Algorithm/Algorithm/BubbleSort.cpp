//#include<iostream>
//
//using namespace std;
//
//void BubbleSort(int s[], int n);
//void Swap(int* a, int* b);
//
//int main() {
//	int s[50] = { 0 };
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
//	BubbleSort(s, n);
//
//	for (i = 0; i < n; i++) {
//		cout << s[i] << " ";
//	}
//
//	return 0;
//}
//
//void BubbleSort(int s[], int n) {
//	int i, j;
//
//	for (i = n - 2; i >= 0; i--) {
//		for (j = 0; j <= i; j++) {
//			if (s[j] > s[j + 1]) {
//				Swap(&s[j], &s[j + 1]);
//			}
//		}
//
//		for (int k = 0; k < n; k++) {
//			cout << s[k] << " ";
//		}
//		cout << endl;
//	}
//}
//
//void Swap(int* a, int* b) {
//	int temp;
//	
//	temp = *a;
//	*a = *b;
//	*b = temp;
//}