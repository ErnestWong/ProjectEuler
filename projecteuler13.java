import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

public class Problem13{
	static void doproblem(){
		String filename = "pe13num.txt";
		BigInteger sum = BigInteger.ZERO;
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			while(line != null){
				BigInteger num = new BigInteger(line);
				sum = sum.add(num);
				line = br.readLine();
			}

			br.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

		String ans = sum.toString();
		System.out.println("answer is: " + ans.substring(0,10));
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		doproblem();
		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
	}
}
