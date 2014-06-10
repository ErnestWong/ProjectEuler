//Answer: 31626
#include <iostream>

int divisorsum(int n)
{
	int sum = 1;
	for(int i = 2; i * i <= n; i++)
	{
		if(n % i == 0) 
		{
			int quotient = n / i;
			sum += quotient;
			sum += i;
		}
	}
	return sum;
}

void doproblem()
{
	int divsums[10001];
	for(int i = 1; i < 10000; i++)
	{
		divsums[i] = divisorsum(i);
	}
	int sum = 0;
	for(int j = 2; j < 10000; j++)
	{
		if(divsums[j] <= 10000)
			if(divsums[divsums[j]] == j && divsums[j] != j){
				 sum += j;
				std::cout<<divsums[j];
			}
	}
	
	std::cout << "The answer is " << sum << "\n";
}

int main()
{
	doproblem();
	
	return 0;
}
