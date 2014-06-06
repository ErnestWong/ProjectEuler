//answer is 210 
public class Problem40{
    static void doproblem(){
		//stop at d1, d10, d100... d1000000 are multiples of 10 
		int stop = 1;
		
		//keep track of total product
		int prod = 1;
		
		//keep track of the total sum of digits
		int sum = 0;
		
		//increment the counter
		int i = 1;
		
		//every time a multiple of 10 of stop is found, multiply stop by 10
		while(stop <= 1000000){
			int size = (int) Math.floor(Math.log10(i)) + 1;
			sum += size;
			
			//if sum of digits equals stop, then just multiply product by digit
			if(sum == stop){
				prod = prod * stop;
				stop = stop * 10;
			}
			
			//if sum is greater than stop, then backtrack and find the digit
			else if(sum > stop){
				int tmpsum = sum;
				int tmpi = i;
				while(tmpsum != stop){
					tmpi = tmpi / 10;
					tmpsum--;
				}
				prod = prod * (tmpi % 10);
				stop = stop * 10;
			}
            
            i++;
		}
		
		System.out.println(prod);
	}
    
    public static void main(String[] args){
       long startTime = System.nanoTime();
    	doproblem();
		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
    } 
}
