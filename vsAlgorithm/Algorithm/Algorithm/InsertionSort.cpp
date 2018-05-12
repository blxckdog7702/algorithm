//#include<iostream>
//
//using namespace std;
//
//void InsertionSort(int s[], int n);
//
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
//	InsertionSort(s, n);
//
//	for (i = 0; i < n; i++) {
//		cout << s[i] << " ";
//	}
//
//	return 0;
//}
//
//void InsertionSort(int s[], int n) {
//	int temp;
//	int i,j;
//
//	for (i = 1; i < n; i++) {
//		temp = s[i];
//
//		for (j = i - 1; j >= 0; j--) {
//			if (temp < s[j]) {
//				s[j + 1] = s[j];
//				//s[j] = temp;
//			}
//			else {
//				break;
//			}
//			
//
//			/*if (j == 0 || s[j - 1] < temp) {
//				s[j] = temp;
//				break;
//			}*/
//			
//		}
//		s[j + 1] = temp;
//	}
//
//}