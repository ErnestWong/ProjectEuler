
public class Problem4 {
	private static boolean isPalindrome(int n){
		int size = (int) Math.ceil(Math.log10(n));
		int[] array = new int[size + 1];
		int index = 0;
		while(n > 0){
			int digit = n % 10;
			array[index] = digit;
			n = n / 10;
			index++;
		}
		
		int head = 0;
		int tail = size -1;
		while(head < tail){
			if(array[head] != array[tail]) return false;
			
			head++;
			tail--;
		}
		return true;
	}
	
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
