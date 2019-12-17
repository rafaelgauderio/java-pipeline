package application;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Integer> list = Arrays.asList(1, 3, 5, 6, 9, 15, 21,26, 32, 36, 40);
		Stream<Integer> stream01 = list.stream().map(x -> x * 15);
		System.out.println(Arrays.toString(stream01.toArray()));

		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Summation= " + sum);

		int prod = list.parallelStream().reduce(0, (x, y) -> x * y);
		System.out.println("Productive= " + prod);

		System.out.println("Filer by even number and multiply by five");
		List<Integer> newList = list.stream().filter(x -> x % 2 == 0).map(x -> x * 5).collect(Collectors.toList());
		System.out.println(Arrays.toString(newList.toArray()));

	}

}
