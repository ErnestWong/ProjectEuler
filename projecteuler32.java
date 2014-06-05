import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//answer is 45228
public class Problem32{

	/**
	* method checks if product and its multiplier/multicand (a, b) are pandigital
	* the numbers combined have to use digits 1 to 9 exactly once
	**/
    public static boolean isPandigital(int a, int b, int prod){
    	List<Integer>digits = new ArrayList<Integer>();
		
		//convert a, b and product to digits and store in list
		while(a > 0){
			digits.add(a % 10);
			a = a / 10;
		}
		
		while(b > 0){
			digits.add(b % 10);
			b = b / 10;
		}
		
		while(prod > 0){
			digits.add(prod % 10);
			prod = prod / 10;
		}

		//convert digit to set to check for duplicates 
		//--if set size is smaller than list, then there must have been duplicates
		//--check that set does not contain a zero (must be 1 to 9 pandigital)
		Set<Integer> digitset = new HashSet<Integer>(digits);
        if(digitset.contains(0) || digitset.size() < digits.size()) 
			return false;
		else 
			return true;
	}
	
	/**
	* only possible multiplier/multicand/product combination that has 9 digit total are:
	* 4, 1, 4 and 3, 2, 4, (multiplier/multicand/product) respectively
	**/
	public static void doproblem(){
		//use set to avoid duplicates
		Set<Integer> pandig = new HashSet<Integer>();
		
		//for loop handling the 4,1,4 possibility
		for(int a = 1000; a < 10000; a++){
			for(int b = 1; b < 10; b++){
				int prod = a * b;
				
				//makes sure product is 4 digits long
				if(prod > 999 && prod < 10000){
					if(isPandigital(a, b, prod)) pandig.add(prod);
				}
			}
		}
		
		//for loop handling the 3,2,4 possibility
		for(int a = 100; a < 1000; a++){
			for(int b = 10; b < 100; b++){
				int prod = a * b;
				if(prod > 999 && prod < 10000){
					if(isPandigital(a, b, prod)) pandig.add(prod);
				}
			}
		}
		
		List<Integer> pandigList = new ArrayList<Integer>(pandig);
		int sum = 0;
		for(int i = 0; i < pandigList.size(); i++){
			sum += pandigList.get(i);
		}
		
		System.out.println("Answer is: " + sum);
	}
	
	public static void main(String[] args){
		doproblem();
	}
}
