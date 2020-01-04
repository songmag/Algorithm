import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader reader = new Reader(2);
		int[] request;
		request = reader.readAll();
		reader = new Reader(request[0]);
		int[] values;
		Calc cal= new Calc(reader.readAll());
		
		reader.closeReader();
	}
}
class Calc{
	int[] object;
	public Calc(int[] cal)
	{
		object = cal;
	}
	public int answer(int[] object){
		
		return 0;		
	}
}
class Reader
{
	int n;
	BufferedReader reader;
	Reader(int n){
		this.n = n;
	}
	public int[] readAll()
	{
		reader = new BufferedReader(new InputStreamReader(System.in));
		int[] rs = new int[n];
		try {
			String values = reader.readLine();
			String[] value = values.split(" ");
			int i = 0;
			for(String val : value )
			{
				rs[i++] = Integer.parseInt(val);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void closeReader()
	{
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}