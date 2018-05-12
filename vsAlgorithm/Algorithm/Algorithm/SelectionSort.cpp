#include<iostream>

using namespace std;

void SelectionSort(int s[], int n);
void Swap(int* a, int* b);

int main() {
	int s[50] = { 0 };
	int i, n;

	cout << "입력할 개수?" << endl;
	cin >> n;

	while (n < 0 || n > 50) {
		cout << "재입력" << endl;
		cin >> n;
	}

	for (i = 0; i < n; i++) {
		cin >> s[i];
	}

	SelectionSort(s, n);
	
	for (i = 0; i < n; i++) {
		cout << s[i] << " ";
	}

	return 0;
}

void SelectionSort(int s[], int n) {
	int i, j;
	int min;
	int minIndex;

	for (i = 0; i < n - 1; i++) {
		min = s[i];
		minIndex = i;

		for (j = i + 1; j < n; j++) {
			if (min > s[j]) {
				min = s[j];
				minIndex = j;
			}
		}

		Swap(&s[i], &s[minIndex]);

	}
}

void Swap(int* a, int* b) {
	int temp;

	temp = *a;
	*a = *b;
	*b = temp;
}