//answer is 137846528820


public class Problem15{

    //used pascal's triangle; find the 20th index of the 40th row 
    public static void doproblem(){
    
    //initialize triangle array
		long[][] pascal = new long[41][];
		
		//populate first two rows of pascal triangle
		pascal[0] = new long[1];
		pascal[0][0] = 1;
		
		pascal[1] = new long[2];
		pascal[1][0] = 1;
		pascal[1][1] = 1;
		
		//populate the rest of the rows by adding the previous row's two adjacent elements
		for(int i = 2; i < 41; i++){
			pascal[i] = new long[i + 1];
			pascal[i][0] = 1;
			pascal[i][i] = 1;
			
			for(int j = 1; j < i; j++){
				pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
			}
		}
	    long num = pascal[40][pascal[40].length / 2];
        System.out.println("The answer is: " + num);
    }
	
	public static void main(String[] args){
		long startTime = System.nanoTime();
        doproblem();
		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
	}
}
