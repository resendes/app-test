package br.com.projuris;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyFindArray implements FindArray {

	@Override
	public int findArray(int[] array, int[] subArray) {
		return Collections.lastIndexOfSubList(toList(array), toList(subArray));
	}
	
	private List<Integer> toList(int[] array) {
		return Arrays.stream(array)
				.boxed()
			    .collect(Collectors.toList());
	}

}
