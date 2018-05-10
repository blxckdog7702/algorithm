//#include<iostream>
//
//using namespace std;
//
//class Stack {
//private:
//	int top = 5;
//	int s[5] = { 1,2,3,4,5 };
//
//public:
//	Stack();
//	int pop();
//	void push(int input);
//};
//
//Stack::Stack() {
//
//}
//
//int Stack::pop() {
//	if (top == 0) {
//		cout << "underflow" << endl;
//		return -1;
//	}
//
//	int ret = s[top - 1];
//	s[top - 1] = -1;
//	top--;
//	
//	cout << "pop : " << ret << endl;
//
//	return ret;
//}
//
//void Stack::push(int input) {
//	if (top == 5) {
//		cout << "overflow" << endl;
//		return;
//	}
//
//	s[top] = input;
//	top++;
//
//	cout << "push : " << input << endl;
//}
//
//int main() {
//	Stack stack;
//
//	stack.push(1);
//	stack.pop();
//	stack.pop();
//	stack.push(666);
//	stack.pop();
//	stack.pop();
//	stack.pop();
//	stack.pop();
//	stack.pop();
//}
//
