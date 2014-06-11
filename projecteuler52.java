public class Problem52{
	static void doproblem(){
		int lower = 10;
		int upper = 17;
		boolean found = false;
		int ans = 0;
		
		while(!found){
			for(int i = lower; i < upper; i++){
				
				for(int c = 2; c <= 6; c++){
					if(!permutated(i, c*i)) break;
				}
				found = true;
				ans = i;
			}
			lower = lower * 10;
			upper = upper * 10;
		}
		
		System.out.println(ans);
	}
	
	static int[] splitDigs(int i){
		int index = 0;
		int size = (int)Math.floor(Math.log10(i)) + 1;
		int[] digits = new int[size];
		
		while(i > 0){
			digits[index] = i % 10;
			i = i / 10;
			index++;
		}
		Arrays.sort(digits);
		return digits;
	}
	
	static boolean permutated(int a, int b){
		int sizea = (int)Math.floor(Math.log10(a)) + 1;
		int sizeb = (int)Math.floor(Math.log10(b)) + 1;
		
		if(sizea != sizeb) return false;
		
		int[] digitsA = splitDigs(a);
		int[] digitsB = splitDigs(b);
		
		if(digitsA.equals(digitsB)) return true;
		else return false;
	}
}
