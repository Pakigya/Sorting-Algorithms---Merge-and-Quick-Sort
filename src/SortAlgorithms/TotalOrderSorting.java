package SortAlgorithms;

/**
 * Name: Pakigya Tuladhar
 * Stony Brook ID: 110732983
 * Subject: CSE 214
 * Recitation: 06
 * Assignment Number: 05
 * Date Submitted: December 11, 2016
 **/

import java.util.Comparator;
import java.util.List;


/** The <code>TotalOrderSorting<E></code> interface provides the basic structure for any data type that can 
 * be comparable using a comparator. That is, any 2 instances of the data type should be totally ordered using 
 * the comparator. The <code>sort(List<? extends E> list, Comparator<E> c)</code> method should sort any passed
 * list through the passed comparator regardless of their natural order.
 */
 
public interface TotalOrderSorting<E> {

	/**
	 * A method that sorts the unsorted list that was passed using pass by reference and various algorithms
	 * using Total Order determined by the comparator. 
	 * @param list : passes the list that need to be sorted
	 * @param c : a comparator which determines the natural order of the sorting
	 */
	public void sort(List<? extends E> list, Comparator<E> c);
}
