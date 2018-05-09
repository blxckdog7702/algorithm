#include<iostream>
#include<string>
#include<vector>
#include<limits>

using namespace std;

//문자열 배열(string array)이 주어지면, 제일 긴 공통된 접두사(prefix)의 길이를 찾으시오.
//예제)
//Input: [“apple”, “apps”, “ape”]
//Output : 2 // “ap”
//
//Input : [“hawaii”, “happy”]
//Output : 2 // “ha”
//
//Input : [“dog”, “dogs”, “doge”]
//Output : 3 // “dog”

int solution(vector<string> input);

int main() 
{
	vector<string> input = { "dog", "dogs" , "doge" };

	cout << solution(input) << endl;
}

int solution(vector<string> input)
{
	int count = 0;

	int min_size = numeric_limits<int>::max();
	int min_size_index = 0;

	// 가장 길이가 짧은 요소 구하기
	for (int i = 0; i < input.size(); i++)
	{
		if (min_size > input[i].size()) 
		{
			min_size = input[i].size();
			min_size_index = i;
		}
	}

	// 탐색하면서 공통 접두사 길이 구하기
	for (int i = 0; i < input[min_size_index].size(); i++)
	{
		char c = input[min_size_index].at(i);

		for (int j = 0; j < input.size(); j++)
		{
			if (c != input[j].at(i)) 
			{
				return i;
			}
		}
	}

	// 여기까지 도달하면 가장 짧은 문자열의 길이가 공통 접두사이다.
	return min_size;
}