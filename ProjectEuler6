/*
The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)^2 = 55^2 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/
using System;

public class ProjectEuler6
{
    public static void Main()
    {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i<101; i++)
        {
            sum1+=(i*i);
        }
        
        for(int j = 0; j<101; j++)
        {
            sum2 +=j;
        }
        double diff = Math.Pow(sum2, 2) - sum1;
        
        Console.WriteLine("The difference is {0}", diff);
    }
}
