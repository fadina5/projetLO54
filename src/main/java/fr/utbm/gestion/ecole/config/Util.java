package fr.utbm.gestion.ecole.config;

import java.util.Objects;

public class Util {
	
	//public static final int MAX_COURSE_PER_PAGE =10;
    //public static final int MAX_COURSESESSION_PER_PAGE =10;
    
    public static Integer convertStringToInteger(String str_int) {
        return (str_int != null && !Objects.equals(str_int, "")) ? Integer.parseInt(str_int) : null;
    }

    public static Integer getIntegerPercent(int part, int total) {
        int result = 0;
        if (total != 0) {
            result = Math.round((float)100*part / total);
        }
        return result;
    }

}
