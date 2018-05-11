//#include<iostream>
//#include<cstdio>
//#include<cstring>
//
//using namespace std;
//
////5052번(전화번호목록)
//
//struct Trie {
//	bool finish;
//	Trie* next[10];
//	Trie() : finish(false) {
//		memset(next, 0, sizeof(next));
//	}
//	~Trie() {
//		for (int i = 0; i < 10; i++) {
//			if (next[i]) {
//				delete next[i];
//			}
//		}
//	}
//
//	void insert(const char* key) {
//		if (*key == '\0') {
//			finish = true;
//		}
//		else {
//			int curr = *key - '0';
//			if (next[curr] == NULL) {
//				next[curr] = new Trie();
//			}
//			next[curr]->insert(key + 1);
//		}
//	}
//
//	bool find(const char* key) {
//		if (*key == '\0') {
//			return 0;
//		}
//		
//		if (finish) {
//			return 1;
//		}
//
//		int	curr = *key - '0';
//		return next[curr]->find(key + 1);
//	}
//};
//
//int t, n, r;
//char a[10000][11];
//
//int main() {
//	cin >> t;
//	while (t--) {
//		cin >> n;
//
//		getchar();
//
//		for (int i = 0; i < n; i++) {
//			scanf("%s", &a[i]);
//		}
//
//		Trie* root = new Trie;
//
//		r = 0;
//
//		for (int i = 0; i < n; i++) {
//			root->insert(a[i]);
//		}
//
//		for (int i = 0; i < n; i++) {
//			if (root->find(a[i])) {
//				r = 1;
//			}
//		}
//
//		printf("%s\n", r ? "NO" : "YES");
//	}
//}