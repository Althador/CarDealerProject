package Utils;

import Models.CarModels;

public class CarUtils {

	
	public static CarModels loginedUser ;
	
	public static String getValue(Object value) {
		if(value==null) 
			return "";
		else 
			return value.toString();
	}
}
