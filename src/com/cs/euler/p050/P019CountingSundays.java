package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P019CountingSundays extends EulerBase {

	/*
	 * You are given the following information, but you may prefer to do some
	 * research for yourself.
	 * 
	 * 1 Jan 1900 was a Monday. Thirty days has September,April, June and
	 * November. All the rest have thirty-one, Saving February alone, Which has
	 * twenty-eight, rain or shine. And on leap years, twenty-nine. A leap year
	 * occurs on any year evenly divisible by 4, but not on a century unless it
	 * is divisible by 400. How many Sundays fell on the first of the month
	 * during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
	 */

	@Test
	public void resolve() {
		int days = daysOfYear(1900);
		int count = 0;
		for (int year = 1901; year <= 2000; year++) {
			for (int mon = 1; mon <= 12; mon++) {
				if (days % 7 == 0) {
					count++;
				}
				
				days += getDaysOfMonth(year, mon);
			}
		}
		print(count);
	}

	private int getDaysOfMonth(int year, int mon) {
		switch(mon){
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 2:
			return isLeepYear(year)?29:28;
		}
		return 0;
	}

	boolean isLeepYear(int year) {
		if (year % 400 == 0) {
			return false;
		} else if (year % 100 == 0) {
			return true;
		} else if (year % 4 == 0) {
			return true;
		}
		return false;
	}

	int daysOfYear(int year) {
		if (isLeepYear(year)) {
			return 366;
		}
		return 365;
	}

}
