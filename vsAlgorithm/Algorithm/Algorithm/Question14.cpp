#include<iostream>
#include<string>
#include<vector>
#include<limits>

using namespace std;

//���ڿ� �迭(string array)�� �־�����, ���� �� ����� ���λ�(prefix)�� ���̸� ã���ÿ�.
//����)
//Input: [��apple��, ��apps��, ��ape��]
//Output : 2 // ��ap��
//
//Input : [��hawaii��, ��happy��]
//Output : 2 // ��ha��
//
//Input : [��dog��, ��dogs��, ��doge��]
//Output : 3 // ��dog��

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

	// ���� ���̰� ª�� ��� ���ϱ�
	for (int i = 0; i < input.size(); i++)
	{
		if (min_size > input[i].size()) 
		{
			min_size = input[i].size();
			min_size_index = i;
		}
	}

	// Ž���ϸ鼭 ���� ���λ� ���� ���ϱ�
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

	// ������� �����ϸ� ���� ª�� ���ڿ��� ���̰� ���� ���λ��̴�.
	return min_size;
}