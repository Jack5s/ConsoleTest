package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Sort {
	public static void main(String[] args) {
		Integer[] a = new Integer[] { 1, 5, 3, 2, 9, 6, 4, 10, 8, 7 };

		List<Integer> list = Arrays.asList(a);
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			};
		});
		
		HashMap<Integer, Integer>hash=new HashMap<Integer, Integer>();
//		Collections
//		print(list);
	}

	public static <E> void print(List<E> a) {
		for (E e : a) {
			System.out.println(e + " ");
		}
	}
}
