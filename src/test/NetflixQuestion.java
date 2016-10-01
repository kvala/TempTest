package test;

import java.util.Calendar;

/*
  	Use whatever language you are comfortable with (pseudocode even). Assume datastructures and libraries exist and make up their api as needed: No need to check javadoc/language documentation. 

	Write a business_days_from_now() method, which takes as an input a number of business days, and returns a Date object which is that many business days from now. For this, a business day is only a weekday and not a weekend.
	
	example:
	Today is Monday the 20th.
	b_d_f_n(5)
	 => (Monday the 27th)
	b_d_f_n(6)
	 => (Tuesday the 28th)
	
	Assume friendly helpers (or make up your own) with your languages/libraries as well, for instance:
	
	Calendar.today()
	 => {returns today as an object}
	
	Calendar.today().plusDays(1)
	 => {returns tomorrow as an object}
	
	Calendar.today().isWeekday()
	 => true {I'm at work today, today is a week day}
 */
public class NetflixQuestion {

	public static void main(String[] args) {

	}

	public Calendar business_days_from_now(int day) {

		/*
		if (day <= 0) {
			throw new Exception("Invalid day input");
		}

		Calendar today = Calendar.today();
		int i = 1;
		while (i <= day) {
			today = today.plusDays(1);
			if (today.isWeekday()) {
				i++;
			}
		}
		return today;

		*/
		
		// remove below line which is returing null.
		return null;
	}

}
