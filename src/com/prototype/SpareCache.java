package com.prototype;

import java.util.Hashtable;

public class SpareCache {
	
	private static boolean isLoading = false;
	private static Hashtable<String, SparesPrototype> sparesMap = new Hashtable<String, SparesPrototype>();
	
	public static SparesPrototype getSpare(String goodName) {
		
		SparesPrototype cachedSpare = sparesMap.get(goodName);
		
			return (SparesPrototype) cachedSpare.ñlone();

	}
	
	public static void loadCache() {
		
		Oil oil = new Oil();
		oil.serialize();
		sparesMap.put("oil", oil);
		
		Casing casing = new Casing();
		casing.serialize();
		sparesMap.put("casings", casing);
		
		Paint paint = new Paint();
		paint.serialize();
		sparesMap.put("paint", paint);
		
		SparePart spare_part = new SparePart();
		spare_part.serialize();
		sparesMap.put("spare_part", spare_part);
		
		isLoading = true;
		
	}
	
	public static boolean isLoading() {
		return isLoading;
	}
	
}
