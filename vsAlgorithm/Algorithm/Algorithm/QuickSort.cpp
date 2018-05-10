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
//		// ���ĵ��� ���� �迭�� ������ ��ȣ���Ѵ�.
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
//		// pivot���� [i]�� ���Ͽ� [j]���� ���� ��ȯ�Ѵ�.
//		if (s[i] < pivotItem) {
//			j++;
//			temp = s[i];
//			s[i] = s[j];
//			s[j] = temp;
//		}
//				
//	}
//
//	// pivot���� [j]���� �ٲ��� [j]�� �ִ� ���� pivot�� ���� ���� �Ѵ�.
//	pivot = j;
//	temp = s[low];
//	s[low] = s[pivot];
//	s[pivot] = temp;
//
//}