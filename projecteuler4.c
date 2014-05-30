#include <stdio.h>
#include <stdbool.h>

bool isPalindrome(int[] num)
{
    int head = 0;
    int tail = sizeof(num)/sizeof(num[0]) - 1;

    while(head < tail)
    {
	if(num[head] != num[tail])
	{
	    return false;
	}
	head++;
	tail++;
    }
    return true;
}

int * splitNum(int n)
{
    int size = floor(log10(abs(x))) + 1;
    int digits[size];
    int index = 0;
    while(n > 0)
    {
	int digit = n % 10;
	digits[index] = digit;
	index++;
	value /= 10;
    }
    return digits;
}

int doproblem()
{
    int i = 999;
    int j = 999;

    bool foundnum = false;
    while(!foundnum)
    {
	int prod = i * j;
		
    }
}
