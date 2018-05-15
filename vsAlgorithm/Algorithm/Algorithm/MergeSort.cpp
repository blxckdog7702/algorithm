//#include<iostream>
//#define length 6
//
//using namespace std;
//
//void mergeSort(int left, int right, int a[]);
//void merge(int left, int mid, int right, int a[]);
//
//int main() {
//	int s[50] = { 0 };
//	int start, end;
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
//	start = 0;
//	end = n - 1;
//
//	mergeSort(start, end, s);
//
//	for (i = 0; i < n; i++) {
//		cout << s[i] << " ";
//	}
//
//	return 0;
//}
//
//void mergeSort(int left, int right, int a[]) {
//	int mid;
//
//	if (left < right) {
//		// 절반으로 나누기 위해 중간 위치 찾기
//		mid = (left + right) / 2;
//
//		// 분할
//		mergeSort(left, mid, a);
//		mergeSort(mid + 1, right, a);
//
//		// 합병
//		merge(left, mid, right, a);
//	}
//
//}
//
//void merge(int left, int mid, int right, int a[]) {
//	//cout << left << " " << mid << " " << right << endl;
//	int i, j, k;
//
//	i = left;
//	j = mid + 1;
//	k = left;
//
//	int tmp_arr[length];
//
//	// left 부터 mid 까지의 블록과 mid + 1 부터 right 까지의 블록을 서로 비교
//	while (i <= mid && j <= right) {
//		if (a[i] <= a[j]) {
//			tmp_arr[k] = a[i];
//			i++;
//		}
//		else {
//			tmp_arr[k] = a[j];
//			j++;
//		}
//		k++;
//	}
//
//	// left 블록의 값이 다 처리되었지만, right 블록의 index가 남아 있는 경우
//	// right 블록의 남은 부분을 순차적으로 tmp_arr에 복사
//	if (i > mid) {
//		for (int m = j; m <= right; m++) {
//			tmp_arr[k] = a[m];
//			k++;
//		}
//	}
//	// left 블록의 남은 부분을 순차적으로 tmp_arr에 복사
//	else {
//		for (int m = i; m <= mid; m++) {
//			tmp_arr[k] = a[m];
//			k++;
//		}
//	}
//
//	// 임시 배열인 tmp_arr의 값을 원본 배열에 복사한다.
//	for (int m = left; m <= right; m++) {
//		a[m] = tmp_arr[m];
//	}
//
//	for (int m = 0; m < 5; m++) {
//		cout << a[m] << " ";
//	}
//
//}