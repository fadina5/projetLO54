package fr.utbm.gestion.ecole.tools;

import java.util.Objects;

public class Util {
	
	public static final int COURSE_PER_PAGE =10;
    public static final int COURSESESSION_PER_PAGE =10;
    
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
