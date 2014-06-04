#include <stdio.h>
int doproblem()
{
	int count = 0;
	
	//January 1, 1901 is a Tuesday 
	//Mon = 0, Tues = 1, Wed = 2, Thurs = 3, Fri = 4, Sat = 5, Sun = 6
	int dayfirst = 1;

	//initialize variables
	int i, m, feb;
	
	//loop from 1901 to 2000, checking if each year is leap year
	for(i = 1901; i <= 2000; i++)
	{
		if(i % 4 == 0) feb = 29 % 7;
		else feb = 28 % 7;
		
		//stored the mod values of months by 7 (ex. 31 mod 7 = 3)
		int months [12] = {3, feb, 3, 2, 3, 2, 3,3, 2, 3, 2, 3};
		int size = sizeof(months) / sizeof(months[0]);
		for(m = 0; m < size; m++)
		{
			dayfirst += months[m];			
			
			//if first day of month lands on a Sunday (6), increment counter
			if(dayfirst == 6) count++;
			
			//mod the first day of month so it doesnt go past Sunday
			dayfirst = dayfirst % 7;
		}
	}
	
	printf("answer is: %d", count);
}

int main()
{
	doproblem();
}
