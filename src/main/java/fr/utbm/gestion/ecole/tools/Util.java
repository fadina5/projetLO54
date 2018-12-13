package fr.utbm.gestion.ecole.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Util {
   
	public static Date convertStringToDate(String stringDate)throws ParseException {
        try {
        	DateFormat formatter;
            formatter = new SimpleDateFormat("dd/MM/yyyy");
        	Date date = formatter.parse(stringDate);
            return date;
        } catch (ParseException pe) {
        	 pe.printStackTrace();
        }
		return null;
    }

	 public static Integer convertStringToInteger(String str_int) {
	        return (str_int != null && !Objects.equals(str_int, "")) ? Integer.parseInt(str_int) : null;
	    }

  
    public static Integer getIntegerToPercent(int part, int total) {
        int result = 0;
        if (total != 0) {
            result = Math.round((float)100*part / total);
        }
        return result;
    }

}
