package Comparators;

import java.util.Comparator;

/**
 * Name: Pakigya Tuladhar
 * Stony Brook ID: 110732983
 * Subject: CSE 214
 * Recitation: 06
 * Assignment Number: 05
 * Date Submitted: December 11, 2016
 **/

/**
 * Comparator which sorts length descendingly
 */
public class ReverseLengthComparator implements Comparator<String> {

	@Override
	public int compare(String obj1, String obj2) {
	    if (obj1.length() == obj2.length()) {
	        return 0;
	    }
	    if (obj1.length()>obj2.length()) {
	        return -1;
	    }
	    else
	    {
	        return 1;
	    }
	  }
}