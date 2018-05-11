//#include<iostream>
//#include<string>
//#include<stdio.h>
//
//using namespace std;
//
//void push(int value);
//void pop();
//void size();
//void empty();
//void front();
//void back();
//
//int arr[100001];
//int frontIdx = 0;
//int backIdx = 0;
//
////10845¹ø(Å¥)
//
//int main() {
//	int n = 0;
//
//	cin >> n;
//
//	string input;
//	
//	char intputt[10];
//
//	for (int i = 0; i < n; i++) {
//		cin >> input;
//
//		if (input == "push") {
//			int value;
//			cin >> value;
//
//			push(value);
//		}
//		else if (input == "pop") {
//			pop();
//		}
//		else if (input == "empty") {
//			empty();
//		}
//		else if (input == "front") {
//			front();
//		}
//		else if (input == "back") {
//			back();
//		}
//		else if (input == "size") {
//			size();
//		}
//	}
//}
//
//void push(int value) {
//	arr[backIdx] = value;
//	backIdx++;
//}
//
//void pop() {
//	if (backIdx - frontIdx == 0) {
//		cout << -1 << endl;
//		return;
//	}
//
//	cout << arr[frontIdx] << endl;
//	arr[frontIdx] = -1;
//	frontIdx++;
//}
//
//void size() {
//	cout << backIdx - frontIdx << endl;
//}
//
//void empty() {
//	if (backIdx - frontIdx == 0) {
//		cout << 1 << endl;
//	}
//	else {
//		cout << 0 << endl;
//	}
//}
//
//void front() {
//	if (arr[frontIdx] < 1) {
//		cout << -1 << endl;
//	}
//	else {
//		cout << arr[frontIdx] << endl;
//	}
//}
//
//void back() {
//	if (arr[backIdx - 1] < 1) {
//		cout << -1 << endl;
//	}
//	else {
//		cout << arr[backIdx - 1] << endl;
//	}
//}