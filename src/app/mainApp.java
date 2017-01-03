package app;

/**
 * Name: Pakigya Tuladhar
 * Stony Brook ID: 110732983
 * Subject: CSE 214
 * Recitation: 06
 * Assignment Number: 05
 * Date Submitted: December 11, 2016
 **/

import java.util.Arrays;
import java.util.List;

import Comparators.ReverseLengthComparator;
import SortAlgorithms.MergeSort;
import SortAlgorithms.NaturalOrderSorting;
import SortAlgorithms.TotalOrderSorting;

public class mainApp {
	public static void main(String... args) 
	{
		NaturalOrderSorting<String> sorting = new MergeSort<>();
		TotalOrderSorting<String> lengthSorting = new MergeSort.Unnatural<>();
		TotalOrderSorting<String> lengthBasedSorting = new MergeSort.Unnatural<>();
		List<String> strings = Arrays.asList("how", "will", "i", "know", "my", "sorting", "algorithm", "is", "correct", "?");
		sorting.sort(strings); System.out.println(strings); // prints out strings in dictionary-order
		
		// if there exists a length-based comparator for Strings by this name ... 
		lengthBasedSorting.sort(strings, new ReverseLengthComparator()); 
		System.out.println(strings); // prints out strings, starting with the 
		// shortest and ending with the longest
	}
}
