#include <iostream>
#include <stdio.h>
#include <stdbool.h>
#include <cmath>
using namespace std;

bool isPalindrome(int* num, int size)
{
    int head = 0;
    int tail = size - 1;

    while(head < tail)
    {
	if(*(num + head) != *(num + tail))
	{
	    return false;
	}
	head++;
	tail--;
    }
    return true;
}

int * splitNum(int n)
{
    int size = floor(log10(n)) + 1;
    int digits[size];
    int index = 0;
    while(n > 0)
    {
	int digit = n % 10;
	digits[index] = digit;
	index++;
	n = n / 10;
    }
    return digits;
}

void doproblem()
{
    int i = 999;
    int j = 999;
    int ans;
    bool foundnum = false;
    while(!foundnum)
    {
	int prod = i * j;
	int size = floor(log10(prod));
	int * ptr = splitNum(prod);
	if(isPalindrome(ptr, size))
	{
	    ans = prod;
	    std::cout<< i << " " << j << "\n";
	    foundnum = true;
	}
	if(i < 100)
	{
	    j--;
	    i = 999;
	}
	else
	{
	    i--;
	}
    } 
    
     std::cout << ans << "\n";   
}

int main()
{
    doproblem();

    return 0;
}
