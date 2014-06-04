using System;

public class ProjectEuler4
{
    //This method returns true if the number is divisible by all numbers from
    //1-20 and returns false otherwise
    public static bool IsDivisible(int num)
    {        
        for(int i = 2; i <= 20; i++)
        {
            if(num % i != 0)
            {
                return false;
            }
        }
        return true;
    }
    
    public static void Main()
    {
        int counter = 1;
        
        //counter is increased until method is evaluated to true
        while(!IsDivisible(counter))
        {
            counter++;
        }
        
        //number is displayed
        Console.WriteLine("The smallest multiple is {0}", counter);
        
    }
}
//answer is 232792560
