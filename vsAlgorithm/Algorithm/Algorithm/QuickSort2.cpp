#include<iostream>

using namespace std;

void QuickSort(int low, int high, int s[]);
void Partition(int low, int high, int s[], int& pivot);

//int main() {
//	int i;
//
//	int s[50] = { 0 };
//	int n;
//
//
//	cout << "�Է��� �ڷ��� ����?" << endl;
//
//	cin >> n;
//
//	while (n <= 0 || n > 50) {
//		cout << "�ٽ� �Է��ϼ���." << endl;
//		cin >> n;
//	}
//
//	for (i = 0; i < n; i++) {
//		cin >> s[i];
//	}
//
//	int low = 0;
//	int high = n - 1;
//
//	QuickSort(low, high, s);
//
//	for (i = 0; i < n; i++) {
//		cout << s[i] << " ";
//	}
//
//}

void QuickSort(int low, int high, int s[]) {
	//static int count = 0;
	//count++;
	//cout << "ȣ��Ƚ��" << count << endl;

	int pivot;

	if (low < high) {
		Partition(low, high, s, pivot);
		QuickSort(low, pivot - 1, s);
		QuickSort(pivot + 1, high, s);
	}
}

void Partition(int low, int high, int s[], int& pivot) {
	int i, j;
	int temp;
	int pivotItem;

	j = low;
	pivotItem = s[low];

	for (i = low + 1; i <= high; i++) {
		if (pivotItem > s[i]) {
			j++;
			temp = s[j];
			s[j] = s[i];
			s[i] = temp;
		}
	}

	//���� ������ ���� pivot ����
	pivot = j;
	cout << j << "???" << endl;
	//pivot�� j��ȯ
	temp = s[j];
	s[j] = s[low];
	s[low] = temp;

}