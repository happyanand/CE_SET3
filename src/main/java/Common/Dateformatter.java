package Common;

import java.time.LocalDate;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import com.pages.*;

public class Dateformatter {
	
	
	public static String DateFormat(String date) {
		
		String input = date;
    	DateTimeFormatter f = DateTimeFormatter.ofPattern( "E MMM dd HH:mm:ss z uuuu").withLocale( Locale.US ); 
    	ZonedDateTime zdt = ZonedDateTime.parse( input ,f );
    	LocalDate ld = zdt.toLocalDate(); 
    	DateTimeFormatter fLocalDate =DateTimeFormatter.ofPattern( "MM/dd/uuuu" );
    	String Dobdep1 = ld.format(fLocalDate) ;
    	//System.out.println(Dobdep1);
		return Dobdep1;
	}
	

}
