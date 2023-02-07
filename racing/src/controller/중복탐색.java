package controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class 중복탐색 {
	
	ArrayList<String> arr = new ArrayList<>(); 
	
	
	
	private void sortedArray() {
		//중복 탐색 메서드
		arr.add("백마");
		arr.add("백마");
		arr.add("흑마");
		arr.add("아마");
		arr.add("아마");
		
		arr = new ArrayList<String>(arr.stream()
				                    .distinct().collect(Collectors.toList()));
		
	}
	
	private void Array() {
		arr.add("백마");
		arr.add("백마");
		arr.add("흑마");
		arr.add("아마");
		arr.add("아마");
		
		LinkedHashSet<String> arr_hs = new LinkedHashSet<>(arr);
		
		arr.clear();
		
		arr.addAll(arr_hs);
		
	}
	
	
	
	

}
