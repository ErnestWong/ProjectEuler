import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem22{
	private static String[] readFile(){
		String filename = "names.txt";
		String content = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			String line;
			do {
				line = br.readLine();
				if(line == null) break;
					content += line;
			}while(line != null);
			
		} catch ( IOException e) {
			e.printStackTrace();
		}
		
		String[] namearray = content.split("[\",,]+");
		Arrays.sort(namearray);
		return namearray;
	}
	
	private static int convertChar(String name){
		int total = 0;
		for(int i = 0; i < name.length(); i++){
			total += (name.charAt(i) - 64);
		}
		return total; 
	}
	public static void main(String[]args){
		String[] names = readFile();
		int sum = 0;
		for(int index = 0; index < names.length; index++){
			sum += convertChar(names[index]) * (index);
		}
		System.out.printf("The answer is %d", sum);
	}
}
