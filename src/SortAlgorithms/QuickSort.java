package SortAlgorithms;

/**
 * Name: Pakigya Tuladhar
 * Stony Brook ID: 110732983
 * Subject: CSE 214
 * Recitation: 06
 * Assignment Number: 05
 * Date Submitted: December 11, 2016
 **/

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class sorts the passed list through the algorithm of Quick Sorting
 * @author Pakigya Tuladhar
 *
 * @param <T> for the objects that are comparable in Natural Order and need to be sorted
 * 
 */
public class QuickSort<T extends Comparable<T>> implements NaturalOrderSorting<T> {

	
	/**
	 * A recursive method that uses quick sort algorithm to sort using Natural Order.
	 * After the method is finished, the unsorted list that was passed is now sorted and 
	 * saved using pass by reference 
	 * @param list : passes the list that need to be sorted
	 */
	@Override
	public void sort(List<? extends T> list) {
		/**
		 * stored the passed list into a temp list variable
		 */
		List<? extends T> temp = list;
		
		/**
		 * saves the size of the passed list/temp
		 */
		int size = temp.size();
		
		/**
		 * counter variable
		 */
		int i;
		
		/**
		 * <code>wall</code>  is the index before which all the values are less than the pivot
		 * and after which all the values are more than the pivot
		 */
		int wall = 0;
		
		/**
		 * if the list has 1 element or no element, the list is by default sorted 
		 */
		if(size<=1)
		{
			list = temp;
			return;
		}
		else
		{
			T pivot = temp.get(size-1); // sets the last element as pivot
			for(i=0; i<(size-1); i++) // loops through the whole list until the 2nd last element
			{
				int compare=pivot.compareTo(temp.get(i)); // compares value using comparable interface
				if(compare>=0)  // value at i > value at pivot
				{
					Collections.swap(temp,i, wall);// swaps the value at index i with value at index wall 
					wall++; // increases wall
				}
			}
			Collections.swap(temp,(size-1), wall); // swaps the value at index of pivot with the index of wall
			sort(temp.subList(0, wall)); //0 is inclusive // wall is exclusive
			sort(temp.subList(wall+1,size)); //wall+1 is inclusive //size is exclusive
		}
		list = temp; // saves the temp as list
	}

	/**
	 * 
	 * A static nested class which helps to implement sorting using the total/unnatural order
	 * @author PLT
	 * @param <E> Data type which is comparable using the comparator
	 */
	public static class Unnatural<E> implements TotalOrderSorting<E>{
		/**
		 * A recursive method that uses quick sort algorithm to sort using the Total Order
		 * determined by the comparator passed.
		 * After the method is finished, the unsorted list that was passed is now sorted and 
		 * saved using pass by reference.
		 * @param list : passes the list that need to be sorted
		 * @param c : a comparator which determines the natural order of the sorting
		 */
		//@Override
		public void sort(List<? extends E> list, Comparator<E> c)
		{
			/**
			 * stored the passed list into a temp list variable
			 */
			List<? extends E> temp = list;
			
			/**
			 * saves the size of the passed list/temp
			 */
			int size = temp.size();
			
			/**
			 * counter variable
			 */
			int i;
			
			/**
			 * <code>wall</code>  is the index before which all the values are less than the pivot
			 * and after which all the values are more than the pivot
			 */
			int wall = 0;
			
			/**
			 * if the list has 1 element or no element, the list is by default sorted 
			 */
			if (size<=1)
			{
				list = temp;
				return;
			}
			else
			{
				E pivot = temp.get(size-1); // sets the last element as pivot
				for(i=0; i<(size-1); i++) // loops through the whole list until the 2nd last element
				{
					int compare= c.compare(pivot, temp.get(i));
					if(compare>=0) // value at i > value at pivot
					{
						Collections.swap(temp,i, wall);// swaps the value at index i with value at index wall 
						wall++; // increases wall
					}
				}
				Collections.swap(temp,(size-1), wall); // swaps the value at index of pivot with the index of wall
				sort(temp.subList(0, wall), c); //0 is inclusive // wall is exclusive
				sort(temp.subList(wall+1,size), c); //wall+1 is inclusive //size is exclusive
			}
			list = temp; // saves the temp as list
		}		
	}
}
