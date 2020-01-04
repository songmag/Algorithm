import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			printTop(writer, count);
			printBottom(writer,count);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void printTop(BufferedWriter writer,int count) throws IOException
	{
		for(int i = 0 ; i < count; i++)
		{
			for(int j = i ; j < count-1; j++)
			{
				writer.write(" ");
			}
			for(int j = 0; j < i*2+1;j++)
			{
				writer.write("*");
			}
			writer.write("\n");
		}
	}
	public static void printBottom(BufferedWriter writer,int count) throws IOException
	{
		for(int i = count-1 ; i > 0; i--)
		{
			for(int j = i ; j < count; j++)
			{
				writer.write(" ");
			}
			for(int j = i*2-1; j > 0 ; j--)
			{
				writer.write("*");
			}
			writer.write("\n");
		}
	}
}
