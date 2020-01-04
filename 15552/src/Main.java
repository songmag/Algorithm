import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int size = Integer.parseInt(read.readLine());
			String value;
			String[] numbers;
			for(int i = 0 ; i <size ; i++) {
				value = read.readLine();
				numbers = value.split(" ");
				writer.write((Integer.parseInt(numbers[0])+Integer.parseInt(numbers[1]))+"\n");	
			}
			writer.flush();
			read.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
