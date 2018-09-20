package br.com.projuris;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyFindChar implements FindCharachter {

	@Override
	public char findChar(String word) {
		List<Character> collect = Arrays.stream(word.toLowerCase().split(""))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream()
				.filter(a -> a.getValue() == 1).map(a -> a.getKey().charAt(0)).collect(Collectors.toList());

		return (char) word.chars()
				.filter(a -> collect.contains((char) a))
				.findFirst()
				.orElse(Character.MIN_VALUE);
	}

}
