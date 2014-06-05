//answer is 906609
public class Problem4 {
	/**
	 * method to determine if number is a palindrome
	*/
	private static boolean isPalindrome(int n){
		//store digits of number in array
		int size = (int) Math.floor(Math.log10(n)) + 1;
		int[] array = new int[size];
		int index = 0;
		while(n > 0){
			int digit = n % 10;
			array[index] = digit;
			n = n / 10;
			index++;
		}
		
		//compare first and last element for equality; 
		//increment head and decrement tail if equal, else return false
		int head = 0;
		int tail = size -1;
		while(head < tail){
			if(array[head] != array[tail]) return false;
			
			head++;
			tail--;
		}
		return true;
	}
	
	/**
	 * check products of 999 to 100 for palindromes; return the largest one
	*/
	private static int doproblem(){
		int max = -1;
		for(int i = 999; i > 99; i--){
			for(int j = 999; j > 99; j--){
				int prod = i * j;
				if(isPalindrome(prod)){
					if(prod > max) max = prod;
				}
			}
		}
		return max;
	}
	public static void main(String[] args){
		int ans = doproblem();
		System.out.println(ans);
		
	}
}
