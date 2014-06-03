#include <iostream>

int sumdivisor(int n)
{
	int sum = 0;
	for(int i = 0; i < n; i++)
	{
		if(n % i == 0) sum += i;
	}
	return sum;
}

bool isamicable(int a, int b)
{
	if(sumdivisor(a) == b && sumdivisor(b) == a) return true;
	else return false;
}

void doproblem()
{
	long amicablesum = 0;
	for(int i = 1; i < 10000; i++)
	{
		for(int j = 1; j < 10000; j++)
		{
			if(i != j)
			{
				if(isamicable(i, j)) amicablesum = amicablesum + i + j;
			}
		}
	}
	
	std::cout << amicablesum << "\n";
}

int main()
{
	doproblem();
}
