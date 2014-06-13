//answer is 669171001

public class Problem28{
    static void doproblem(){
		int sum = 1;
		int spiral = 0;
		int inc = 2;
		int count = 1;
		while(spiral < 500){
			for(int i = 0; i < 4; i++){
				count += inc;
				sum += count;
			}
			spiral++;
			inc += 2;
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args){
		long startTime = System.nanoTime();
        doproblem();
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
	}
}
