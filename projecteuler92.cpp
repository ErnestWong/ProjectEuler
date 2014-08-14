//answer is 8581146

#include <iostream>
#include <time.h>


using namespace std;

int sum_of_digit_square(int n)
{
    int sum = 0;
    while(n > 0)
    {
	int s = n % 10;
	sum += (s*s);
	n = n / 10;
    }
    return sum;

}


int starting_number(int n)
{
    if(n == 89 || n == 1) return n;
    else return starting_number(sum_of_digit_square(n));
}
int main()
{
    clock_t start, end;
    int ans = 0;

    start = clock();

    for(int i = 2; i < 10000000; i++)
    {
	if(starting_number(i) == 89)
	{
	    ans++;
        }
    }
    
    end = clock();

   std::cout <<"answer is: " <<  ans << "\n";
   std::cout << "time: " << 
   (double)(end-start)/(CLOCKS_PER_SEC/1000) << "ms\n";
}
