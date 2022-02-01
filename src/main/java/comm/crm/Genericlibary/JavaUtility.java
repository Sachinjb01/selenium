package comm.crm.Genericlibary;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method will be generate number and returns it to the caller
	 * @return
	 */

	public int getRandomNumber()
	{
		
		Random ran=new Random();
		int random=ran.nextInt(1000);
		
		return random ;
		
		
	}
/**
 * this method will return the currentDate to caller
 * @return
 */
	public String getCurrentDate()
	{
		Date date=new Date();
		String currentDate=date.toString();
		return currentDate;
	}
	
	/**
	 * this method will return date in specific format
	 * @return
	 */
	
	
	public String getFinalDateFormat()
	{
		Date date=new Date();
		String d = date.toString();
				String[] dte = d.split("");
		String yyyy=dte[5];
		String dd=dte[2];
		String mm=dte[2];
		String today=yyyy+"-"+mm+"-"+dd;
		return today;
	}
	
}
