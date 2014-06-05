#include <stdio.h>
#include <stdbool.h>
//Answer: -59231

/**
 * method determines if number is prime
*/
bool isPrime( int n)
{
	int i;
	for(i = 2; i*i <= n; i++)
	{
		if(n % i == 0) return false;
	}
	return true;
}

void doproblem()
{
	int a, b;
	int maxcount = 0;
	int maxA, maxB;
	
	//loop through -999 to 999 for a and b  where n^2 + an + b
	for(a = -999; a < 1000; a++)
	{
		for(b = -999; b < 1000; b++)
		{
			bool primeStreak = true;
			int n = 0;
			int primecount = 0;
			
			//keep counting while there is a streak where n is prime as it increments
			while(primeStreak)
			{
				int p = n * n + a * n + b;
				if(isPrime(p) && p > 0) primecount++;
				else primeStreak = false;
				
				n++;
			}
			
			//record the max a and b value
			if(primecount > maxcount) {
				maxcount = primecount;
				maxA = a;
				maxB = b;
			}
		}
	}
	
	printf("The answer is: max a: %d, max b: %d, a * b: %d\n",maxA, maxB, maxA * maxB);
}

int main()
{
	doproblem();
}
