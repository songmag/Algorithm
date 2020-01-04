import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Lope lope;
		try {
			int n = Integer.parseInt(reader.readLine());
			lope = new Lope(n);
			for(int i = 0 ; i < n; i++)
			{
				lope.insert(Integer.parseInt(reader.readLine()));
			}
			System.out.println(lope.excuteMax(1,new Integer(0)));
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Lope{
	PriorityQueue<Integer> heap;
	int size;
	public Lope(int n)
	{
		size = n;
		heap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}
	public void insert(int k)
	{
		heap.offer(new Integer(k));
	}
	public Integer excuteMax(int k,Integer max)
	{
		if(k == size+1)
			return max;
		Integer temp = heap.remove();
		if(max < temp*k) max = temp*k;
		return excuteMax(k+1,max);
	}
}
