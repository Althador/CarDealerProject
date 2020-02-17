package yasin.utils;

import yasin.models.CarModels;

public class MyUtil {

	
	public static CarModels loginedUser ;
	
	public static String getValue(Object value) {
		if(value==null) 
			return "";
		else 
			return value.toString();
	}
}
