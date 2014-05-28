using System;

public class ProjectEuler2
{
    public static void Main()
    {
        int a = 0;
        int b = 1;
        int c;
        int sum = 0;
        
        do
        {
            c = a + b;
            a = b;
            b = c;
        
            if(c % 2 == 0)
            {
                sum = sum + c;
            }
            
        }while(c <= 4000000);
        
        Console.WriteLine(sum);
    }
}
//answer is 4613732
