/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

using System;

public class ProjectEuler3
{
    public static int LargestPrimeFactor(long n)
    {
        int largest = 1;
        int count = 0;
        int i = 2;
       do
        {
            if(n % i == 0)
            {
               
                largest = i;
                n = n/i;
                count++;
                
            }
            i++;
        }while(n != 1);
        
       
        return largest;
    }
    
    public static void Main()
    {
        Console.WriteLine(LargestPrimeFactor(600851475143));    
    }
}
//Answer is 6857
