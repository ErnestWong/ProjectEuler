import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//Answer: 23514624000
public class Problem8 {
	
	//obtain 1000 digit string from textfile
	static int[] readFile() {
		String filename = "pe8num.txt";
		String content = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			while (line != null) {
				content += line;
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[] charnums = content.toCharArray();
		int[] intnums = new int[charnums.length];
		for (int i = 0; i < charnums.length; i++) {
			intnums[i] = (int) charnums[i] - 48;
		}
		return intnums;
	}

	//find largest product of 13 digits
	static void doproblem() {
		int[] nums = readFile();
		long maxprod = 1;
		for (int i = 0; i < nums.length - 13; i++) {
			long prod = 1;
			for (int j = i; j < i + 13; j++) {
				prod = prod * nums[j];
			}

			if (prod > maxprod) {
				maxprod = prod;
				
			}
		}
		System.out.println("The answer is: " + maxprod);
	}

	public static void main(String[] args) {
		doproblem();
	}
}
