//#include<iostream>
//#include<stdio.h>
//
//using namespace std;
//
//int main() {
//	int data[10] = { 1, 3, 4, 6, 8, 10, 13, 14, 15, 16 }; //���ĵ� ������.
//	int keyValue; //ã�� ���� ��.
//	
//	int startNum;
//	int endNum;
//	int midNum;
//	
//	while (1) {
//		for (int i = 0; i < 10; i++) {
//			printf("%d ", data[i]);
//		}
//		printf("\n� ���� ã��ͳ���?  : ");
//		scanf_s("%d", &keyValue);
//
//		startNum = 0;
//		endNum = 9;
//		
//		while (1) {
//			midNum = (startNum + endNum) / 2;
//
//			if (startNum < endNum) {
//				if (data[midNum] < keyValue) {
//					startNum = midNum + 1;
//				}
//				else if (data[midNum] > keyValue) {
//					endNum = midNum - 1;
//				}
//				else {
//					printf("Key��(%d)�� data[%d]�� �ֽ��ϴ�.\n\n", keyValue, midNum);
//					break;
//				}
//			}
//			else {
//				if (data[midNum] != keyValue) {
//					//���� �ʴٸ� �������� �ʴ� ������.
//					printf("Key��(%d)�� data �迭�� �������� �ʽ��ϴ�.\n\n", keyValue);
//				}
//				else { //Ű ���� ���ٸ�.
//					printf("Key��(%d)�� data[%d]�� �ֽ��ϴ�.\n\n", keyValue, midNum);
//				}
//				break;
//			}
//		}
//	}
//
//	return 0;
//}