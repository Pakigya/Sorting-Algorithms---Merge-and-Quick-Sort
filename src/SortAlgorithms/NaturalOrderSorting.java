package SortAlgorithms;

import java.util.List;
/**
 * Name: Pakigya Tuladhar
 * Stony Brook ID: 110732983
 * Subject: CSE 214
 * Recitation: 06
 * Assignment Number: 05
 * Date Submitted: December 11, 2016
 **/


/** The <code>NaturalOrderSorting<T extends Comparable<T>></code> interface provides the basic 
 * structure for any data type is comparable. That is, any 2 instances of the data type should 
 * be naturally ordered using Comparable interface. The <code>sort(List<? extends T> list)
 * </code> method should sort any passed list using their natural order.
 */
public interface NaturalOrderSorting<T extends Comparable<T>> {
	

	/**
	 * A method that sorts the unsorted list that was passed using pass by reference and various algorithms
	 * using Natural Order determined by the comparable interface of the list. 
	 * @param list : passes the list that need to be sorted
	 */
	public void sort(List<? extends T> list);
}
