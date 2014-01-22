/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/
using System;

public class ProjectEuler7
{
    public static void Main()
    {
        int [] prime = new int[10000];
        int i = 3;
        int count = 0;
        bool isPrime = true;
        //loop is iterated until the 10001th prime number is reached
        do
        {
            
            for(int j = 2; j < i; j++)
            {
                if(i % j == 0)
                {
                    isPrime = false;
                }
            }
            //array count is only incremented if number is prime.
           if(isPrime)
           {
                prime[count] = i;
                count++;
           }isPrime = true;
           
        i++;
        
        }while(count <= 9999);
        
        Console.WriteLine("The 10001th prime number is {0}", prime[9999]);
    }
}
//Answer is 104743
