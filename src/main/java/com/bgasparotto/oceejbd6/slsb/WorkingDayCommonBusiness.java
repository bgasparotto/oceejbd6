package com.bgasparotto.oceejbd6.slsb;

import java.util.Calendar;
import java.util.Date;

/**
 * Interface containing the contract for operations common to all business
 * interfaces of the WorkingDay EJB.
 * 
 * @author Bruno Gasparotto
 *
 */
public interface WorkingDayCommonBusiness {

	/**
	 * Check whether a date is a working day. This method doesn't consider
	 * holidays for simplicity purposes.
	 * 
	 * @param date
	 *            Date to be checked
	 * @return {@code true} if the {@code date} is a working day, {@code false}
	 *         otherwise
	 * 
	 * @throws IllegalArgumentException
	 *             if {@code date} is {@code null}
	 */
	boolean isWorkingDay(Date date);

	/**
	 * Check whether a date represented by a {@code Calendar}'s object is a
	 * working day. This method doesn't consider holidays for simplicity
	 * purposes.
	 * 
	 * @param calendar
	 *            Calendar to be checked
	 * @return {@code true} if the {@code calendar} is a working day,
	 *         {@code false} otherwise
	 * 
	 * @throws IllegalArgumentException
	 *             if {@code calendar} is {@code null}
	 */
	boolean isWorkingDay(Calendar calendar);
}