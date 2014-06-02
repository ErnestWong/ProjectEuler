import java.util.*;
public class HelloWorld{

    

public static boolean isAbundant(int n){
    int divisorsum = 0;
	
	for(int i = 1; i <= n/2; i++){
		if(n % i == 0) divisorsum += i;
	}
	
	if(divisorsum > n) return true;
	else return false;
}

public static List<Integer> findAbundants(){
	List<Integer> abundant = new ArrayList<Integer>();
	
	for(int i = 1; i < 28123; i++){
		if(isAbundant(i)) abundant.add(i);
	}
	
	Collections.sort(abundant);
	return abundant;
}

public static void doproblem(){
	List<Integer> sortedAbundant = findAbundants();
	int sum = 0;
	for(int i = 0; i <= 28123; i++){
		boolean noSum = true;
		int head = 0;
		int tail = sortedAbundant.size() - 1;
		
		while(head < tail){
			if((sortedAbundant.get(head) + sortedAbundant.get(tail)) < i) head++; 
			else if((sortedAbundant.get(head) + sortedAbundant.get(tail)) > i) tail--;
			else {
				noSum = false;
				break;
			}
		}
		
		if(noSum) sum += i;  
	}
	
	System.out.println("The answer is: " + sum);
}

public static void main(String[] args) {
	doproblem();
}
}
