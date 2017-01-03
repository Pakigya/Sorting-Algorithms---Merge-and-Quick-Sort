package SortAlgorithms;

/**
 * Name: Pakigya Tuladhar
 * Stony Brook ID: 110732983
 * Subject: CSE 214
 * Recitation: 06
 * Assignment Number: 05
 * Date Submitted: December 11, 2016
 **/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class sorts the passed list through the algorithm of Merge Sorting
 * @author Pakigya Tuladhar
 * @param <T> for the objects that are comparable in Natural Order and need to be sorted
 * 
 * 
 */
public class MergeSort<T extends Comparable<T>> implements NaturalOrderSorting<T> {

	/**
	 * A recursive method that uses merge sort algorithm to sort.
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
		 * <code>wall</code>  is the index before which all the values are less than the pivot
		 * and after which all the values are more than the pivot
		 */
		int wall = 0;
		
		/**
		 * if the list has 1 element or no element, the list is by default sorted 
		 */
		if(size<=1)
		{
			list = temp; // a 1 element array is already sorted
			return;
		}
		else
		{
			wall = size/2; // the midpoint of the list
			// divides the list into sublists to sort
			sort(temp.subList(0, wall)); //0 is inclusive // wall is exclusive
			sort(temp.subList(wall,size)); //wall+1 is inclusive //size is exclusive
			merge(temp); //merges the 2 sorted list into a bigger sorted list
		
		}
		list = temp; // saves the temp as list
	}
	
	
	@SuppressWarnings("unchecked")
	private void merge(List<? extends T> list)
	{
		/**
		 * stored the passed list into a autosave list variable
		 */
		List<T> autosave = (List<T>) list;

		/**
		 * a new temp arraylist
		 */
		ArrayList<T> temp = new ArrayList<T>(list.size());

		/**
		 * saves the size of the passed list
		 */
		int size = list.size();

		/**
		 * <code>wall</code> is just the midpoint here
		 */
		int wall = size/2;

		/**
		 * counter variables
		 * i starts from 0 and j starts from mid-point
		 */
		int i = 0, j = wall;

		/** loops until one of the
		 *  sublists ends iterating
		 */
		while ((i<wall) && (j<size))
		{
			if (list.get(i).compareTo(list.get(j))<0) // compares value using comparator
				//saves the lower value into the temp list
			{
				temp.add(list.get(i));
				i++;
			}
			else
			{
				temp.add(list.get(j));
				j++;
			}
		}

		/** adds the rest of the list if 
		 * one of the the comparison ends of sublists
		 * end
		 */
		for(;i<wall;i++) // adds the 1st sublist if 2nd sublist was ended
		{
			temp.add(list.get(i));
		}
		for(;j<size;j++) // adds the 2nd sublist if 1st sublist was ended
		{
			temp.add(list.get(j));
		}

		/** saves the temp values back to the list
		 * 
		 */
		for (i=0;i<size; i++)
		{
			autosave.set(i, temp.get(i));
		}
		list = autosave;  // saves the autosave as list
	}



	/**
	 * 
	 * @author PLT
	 * A static nested class which helps to implement sorting using the total/unnatural order
	 * @param <E> Data type which is comparable using the comparator
	 */
	public static class Unnatural<E> implements TotalOrderSorting<E>{
		@Override
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
			 * <code>wall</code>  is the index before which all the values are less than the pivot
			 * and after which all the values are more than the pivot
			 */
			int wall = 0;

			/**
			 * if the list has 1 element or no element, the list is by default sorted 
			 */
			if(size<=1)
			{
				list = temp; // a 1 element array is already sorted
				return;
			}
			else
			{
				wall = size/2; // the midpoint of the list
				// divides the list into sublists to sort
				sort(temp.subList(0, wall), c); //0 is inclusive // wall is exclusive
				sort(temp.subList(wall,size), c); //wall+1 is inclusive //size is exclusive
				merge(temp, c); //merges the 2 sorted list into a bigger sorted list
			}
			list = temp; // saves the temp as list
		}
	
	
		@SuppressWarnings("unchecked")
		private void merge(List<? extends E> list, Comparator<E> c)
		{
			/**
			 * stored the passed list into a autosave list variable
			 */
			List<E> autosave = (List<E>) list;
			
			/**
			 * a new temp arraylist
			 */
			ArrayList<E> temp = new ArrayList<E>(list.size());

			/**
			 * saves the size of the passed list
			 */
			int size = list.size();
			/**
			 * <code>wall</code> is just the midpoint here
			 */
			int wall = size/2;

			/**
			 * counter variables
			 * i starts from 0 and j starts from mid-point
			 */
			int i = 0, j = wall;
			
			/** loops until one of the
			 *  sublists ends iterating
			 */
			while ((i<wall) && (j<size))
			{
				if (c.compare(list.get(i),list.get(j))<0) // compares value using comparator
					//saves the lower value into the temp list
				{	
					temp.add(list.get(i));
					i++;
				}
				else
				{
					temp.add(list.get(j));
					j++;
				}
			}
			
			/** adds the rest of the list if 
			 * one of the the comparison ends of sublists
			 * end
			 */
			for(;i<wall;i++) // adds the 1st sublist if 2nd sublist was ended
			{
				temp.add(list.get(i));
			}
			for(;j<size;j++) // adds the 2nd sublist if 1st sublist was ended
			{
				temp.add(list.get(j));
			}
			
			/** saves the temp values back to the list
			 * 
			 */
			for (i=0;i<size; i++)
			{
				autosave.set(i, temp.get(i));
			}
			list = autosave; // saves the temp as list
		}
	}

	
}
