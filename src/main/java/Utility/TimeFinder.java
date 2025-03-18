/**
 * 
 */
package Utility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

/**
 * @author ajithkumar.pisharadi
 *
 */
public class TimeFinder {

	// To return Time in Time Stamp format
	public static String currentSystemTime()
	{
		Date date=java.util.Calendar.getInstance().getTime();
		String strTime = date.toString();
		
		return strTime;
		
	}
	
	// To return Current Date without System Time
	public static String currentSystemDateWithoutTIme() 
	{
		LocalDate today1 = LocalDate.now( ) ;
		Date date=java.util.Calendar.getInstance().getTime();
		//System.out.println(today1);
		return today1.toString();
		
	}
	
	// to return Current System Time Format in yyyy_MM_dd_HH_mm_ss
		public static String currentSystemTimeWithUnderscore() 
		{
			String formattedDate = "";
			LocalDate today1 = LocalDate.now( ) ;
			//System.out.println(today1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss",Locale.US);
			formattedDate = sdf.format(new Date());
			return formattedDate;
			
		}
}
