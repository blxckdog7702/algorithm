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
//	cout << "�Է��� ����?" << endl;
//	cin >> n;
//
//	while (n < 0 || n > 50) {
//		cout << "���Է�" << endl;
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
//		// �������� ������ ���� �߰� ��ġ ã��
//		mid = (left + right) / 2;
//
//		// ����
//		mergeSort(left, mid, a);
//		mergeSort(mid + 1, right, a);
//
//		// �պ�
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
//	// left ���� mid ������ ��ϰ� mid + 1 ���� right ������ ����� ���� ��
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
//	// left ����� ���� �� ó���Ǿ�����, right ����� index�� ���� �ִ� ���
//	// right ����� ���� �κ��� ���������� tmp_arr�� ����
//	if (i > mid) {
//		for (int m = j; m <= right; m++) {
//			tmp_arr[k] = a[m];
//			k++;
//		}
//	}
//	// left ����� ���� �κ��� ���������� tmp_arr�� ����
//	else {
//		for (int m = i; m <= mid; m++) {
//			tmp_arr[k] = a[m];
//			k++;
//		}
//	}
//
//	// �ӽ� �迭�� tmp_arr�� ���� ���� �迭�� �����Ѵ�.
//	for (int m = left; m <= right; m++) {
//		a[m] = tmp_arr[m];
//	}
//
//	for (int m = 0; m < 5; m++) {
//		cout << a[m] << " ";
//	}
//
//}