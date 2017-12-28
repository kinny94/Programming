import java.util.*;

public class CourseraDiscount{

	public static void findDiscount(int[] arr){

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr.length);
		HashMap<Integer, Integer> noDiscountIndexes = new HashMap<Integer, Integer>();
		int sum = 0;

		for(int i = 0; i < arr.length; i++)
			pq.offer(arr[i]);

		//System.out.println("Queue at start "+ pq.toString());

		for(int i = 0; i < arr.length; i++){
			int min = pq.peek();
			pq.remove(arr[i]);
			if(arr[i] > min)
				arr[i] = arr[i] - min;
			else
				noDiscountIndexes.put(i, arr[i]);
			//System.out.println("Queue after step "+ String.valueOf(i+1) + pq.toString());
		}

		for(Integer i: arr){
			System.out.print(i + " ");
			sum+=i;
		}

		System.out.println("\nSum: " + String.valueOf(sum));

		if(noDiscountIndexes!= null)
			System.out.println(noDiscountIndexes.keySet());
	}

	public static void main(String[] args){

		int[] a = {5,1,3,4,6,2};

		findDiscount(a);

		// PriorityQueue<Integer> p = new PriorityQueue<Integer>();

		// p.add(10);
		// p.add(21);
		// p.add(-5);
		// p.add(a[1]);

		// System.out.println("Queue at start "+ p.toString());

		// p.remove(10);

		// System.out.println("Q 10 removal "+ p.toString());
		// //System.out.println(" peek " + p.peek());
		// //int b2 = 0;
		// p.remove(a[1]);
		// System.out.println("q 1 removal "+ p.toString());
	}
}