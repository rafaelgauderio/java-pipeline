package application;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 10, 11, 13,15, 17, 19, 40);
		Stream<Integer> stream01 = list.stream().map(x -> x * 15); //map() is intermediary operation
		System.out.println(Arrays.toString(stream01.toArray())); // toArray() is a final operation
		
		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Summation= " + sum);

		int prod = list.parallelStream().reduce(1, (x, y) -> x * y);
		System.out.println("Producer= " + prod);

		System.out.println("Filter by even number and multiply by 5");
		List<Integer> newList = list.stream().
				filter(x -> x % 2 == 0). // filter the stream
				map(x -> x * 5). // apply the map function on the result stream
				collect(Collectors.toList()); // converter stream to List
		System.out.println(Arrays.toString(newList.toArray()));

	}

}
