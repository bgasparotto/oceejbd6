package com.bgasparotto.oceejbd6.slsb;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;

/**
 * Bean implementation class of the WorkingDay EJB which exposes one local
 * business view.
 * 
 * @author Bruno Gasparotto
 *
 */
@Stateless
public class SimpleWorkingDayBean implements WorkingDayLocalBusiness {

	@Override
	public boolean isWorkingDay(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Date can't be null");
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return this.isWorkingDay(calendar);
	}

	@Override
	public boolean isWorkingDay(Calendar calendar) {
		if (calendar == null) {
			throw new IllegalArgumentException("Calendar can't be null");
		}

		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return ((dayOfWeek == Calendar.SATURDAY)
				|| dayOfWeek == Calendar.SUNDAY);
	}
}