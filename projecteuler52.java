import java.util.Arrays;


public class Problem52{
	static void doproblem(){
		int lower = 10;
		int upper = 17;
		boolean found = false;
		long ans = 0;

		while(!found){
			for(long i = lower; i < upper; i++){

				if(permutated(i, 2*i)){
					
					if(permutated(i, 3*i)){
						
						if(permutated(i, 4*i)){
							if(permutated(i, 5*i)){
								
								if(permutated(i, 6*i)){
									
									found = true;
									ans = i;
									break;
								}
								else break;
							}
							else break;
						}
						else break;
					}
					else break;
				}
				
				else break;
			}	
			lower = lower * 10;
			upper = upper * 10;
		}

		System.out.println(ans);
	}

	static int[] splitDigs(long i){
		int index = 0;
		int size = (int)Math.floor(Math.log10(i)) + 1;
		int[] digits = new int[size];

		while(i > 0){
			digits[index] = (int) (i % 10);
			i = i / 10;
			index++;
		}
		Arrays.sort(digits);
		return digits;
	}

	static boolean permutated(long a, long b){
		int sizea = (int)Math.floor(Math.log10(a)) + 1;
		int sizeb = (int)Math.floor(Math.log10(b)) + 1;

		if(sizea != sizeb) return false;

		int[] digitsA = splitDigs(a);
		int[] digitsB = splitDigs(b);
		
		if(Arrays.equals(digitsB, digitsA)) return true;
		else return false;
	}
	
	public static void main(String[] args){
		doproblem();
		//System.out.println(permutated(12341234,43211234));
	}
}
