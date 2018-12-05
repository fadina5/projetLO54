package fr.utbm.gestion.ecole.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Util {
	
	public static final int COURSE_PER_PAGE =3;
    public static final int COURSESESSION_PER_PAGE =3;
   
   
  
    public static Date convertStringToDate(String stringDate) {
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

    public static Integer convertStringToInteger(String string) {
        return (string != null && !Objects.equals(string, "")) ? Integer.parseInt(string) : null;
    }

    public static Integer getIntegerToPercent(int part, int total) {
        int result = 0;
        if (total != 0) {
            result = Math.round((float)100*part / total);
        }
        return result;
    }

}
