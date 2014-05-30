#include <stdio.h>
#include <stdbool.h>


//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//a2 + b2 = c2
//For example, 32 + 42 = 9 + 16 = 25 = 52.
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.


bool checkCondition(int a, int b, int c)
{
    if(a + b + c == 1000 && a * a + b * b == c * c) return true;
    else return false;
}

int doProblem()
{
    int a, b, c;

    for(a = 1; a < 1000; a++)
    {
        for(b = 1; b < 1000; b++)
        {
            for(c = 1; c < 1000; c++)
            {
                if(checkCondition(a,b,c)) return a * b * c;
            }
        }
    }
    return -1;
}

int main()
{
    int ans = doProblem();
    printf("Answer is: %d\n", ans);

    return 0;
}
