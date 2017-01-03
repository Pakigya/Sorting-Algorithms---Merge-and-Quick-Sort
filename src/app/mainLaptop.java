package app;

/**
 * Name: Pakigya Tuladhar
 * Stony Brook ID: 110732983
 * Subject: CSE 214
 * Recitation: 06
 * Assignment Number: 05
 * Date Submitted: December 11, 2016
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SortAlgorithms.MergeSort;
import SortAlgorithms.NaturalOrderSorting;
import SortAlgorithms.QuickSort;
import app.Laptop;


/**
 * Sorts the Laptops from higher to lower price using Natural Order and MergeSort
 * @author PLT
 *
 */
public class mainLaptop {
    public static void main(String... args) {
        System.out.println("Enter product instances (format: <brand>,<processor-speed>,<memory>,<price>,<screen-size>):");
        Scanner      scanner = new Scanner(System.in);
        List<Laptop> laptops = new ArrayList<>();
        
        String[] laptopsList = {"hitachi,2.33,4,499,13",
        		"hp,1.6,2,379,15",
        		"apple,2.66,8,1250,14",
        		"apple,3.33,8,1600,14",
        		"microsoft,2.66,8,999,14",
        		"hitachi,2.33,4,399,13",
        		"hp,1.6,2,100,15",
        		"apple,2.66,8,250,14",
        		"apple,3.33,8,2500,14",
        		"microsoft,2.66,8,1999,14",
        		"hp,1.6,2,50,15",
        		"apple,2.66,8,2250,14",
        		"apple,3.33,8,1240,14",
        		"microsoft,2.66,8,1899,14"};
        
        /**
         * Adding laptops to the list
         */
        for (String line: laptopsList)
        {
        	  Laptop laptop = Laptop.fromString(line.trim());
              if (laptop != null)
                  laptops.add(laptop);
        }

        /**
         * Prints out list before sorting
         */
        System.out.println("Before sorting");
        for (Laptop laptop: laptops)
            System.out.println(laptop);
		NaturalOrderSorting<Laptop> sortingMerge = new MergeSort<>();
		NaturalOrderSorting<Laptop> sortingQuick = new QuickSort<>();

		/**
		 * Prints out after sorting using Merge Sort
		 */
        System.out.println();        System.out.println();        System.out.println();
        System.out.println("After Merge Sort");
		sortingMerge.sort(laptops); 
        for (Laptop laptop: laptops)
            System.out.println(laptop);

		/**
		 * Prints out after sorting using Quick Sort
		 */
        System.out.println();        System.out.println();        System.out.println();
        System.out.println("After Quick Sort:");
		sortingQuick.sort(laptops); 
        for (Laptop laptop: laptops)
            System.out.println(laptop);
        scanner.close();
    }
	

}
