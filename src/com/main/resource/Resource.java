package com.main.resource;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;

import javax.swing.ImageIcon;



public class Resource {
	
	private static Hashtable<String, Image> imagesMap = new Hashtable<String, Image>();
	
	public static void loadImages() {
		URL url = Resource.class.getResource("images/menu.png");        
	
		ImageIcon icon = new ImageIcon(url);
		Image image = icon.getImage();
		imagesMap.put("menu", image);
		
		url = Resource.class.getResource("images/cars/small_icon/focus.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("focus", image);
		
		url = Resource.class.getResource("images/cars/small_icon/accord.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("accord", image);
		
		url = Resource.class.getResource("images/cars/small_icon/hrv.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("hrv", image);
		
		url = Resource.class.getResource("images/cars/small_icon/golf.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("golf", image);
		
		url = Resource.class.getResource("images/cars/small_icon/tiguan.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("tiguan", image);
		
		url = Resource.class.getResource("images/cars/small_icon/escape.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("escape", image);
		
		url = Resource.class.getResource("images/seller2.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("seller2", image);
		
		url = Resource.class.getResource("images/seller3.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("seller3", image);
		
		url = Resource.class.getResource("images/seller1.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("seller1", image);
		
		url = Resource.class.getResource("images/gas_station_icon.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("gas_station_icon", image);
		
		
		
		url = Resource.class.getResource("images/cars/accord.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("accord_img", image);
		
		url = Resource.class.getResource("images/cars/hrv.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("hrv_img", image);
		
		url = Resource.class.getResource("images/cars/golf.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("golf_img", image);
		
		url = Resource.class.getResource("images/cars/tiguan.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("tiguan_img", image);
		
		url = Resource.class.getResource("images/cars/focus.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("focus_img", image);
		
		url = Resource.class.getResource("images/cars/escape.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("escape_img", image);
		
		url = Resource.class.getResource("images/cars/used_cars/car_before.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("used_car_img", image);
		
		url = Resource.class.getResource("images/cars/used_cars/bike_before.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("used_bike_img", image);
		
		url = Resource.class.getResource("images/cars/used_cars/truck_before.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("used_truck_img", image);
		
		url = Resource.class.getResource("images/background.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("background", image);
		
		
		url = Resource.class.getResource("images/mechanic.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("mechanic", image);
		
		url = Resource.class.getResource("images/broken_gas.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("broken_gas", image);
		
		url = Resource.class.getResource("images/empty_gas.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("empty_gas", image);

		url = Resource.class.getResource("images/ready_gas.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("ready_gas", image);
		
		url = Resource.class.getResource("images/mechanic_anim/1.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("mechanic1", image);
		
		url = Resource.class.getResource("images/mechanic_anim/2.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("mechanic2", image);
		
		url = Resource.class.getResource("images/mechanic_anim/3.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("mechanic3", image);
		

		url = Resource.class.getResource("images/cars/used_cars/car_before_icon.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("car_before_icon", image);
		
		url = Resource.class.getResource("images/cars/used_cars/car_after_icon.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("car_after_icon", image);
		
		url = Resource.class.getResource("images/cars/used_cars/motorbike_before_icon.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("bike_before_icon", image);
		
		url = Resource.class.getResource("images/cars/used_cars/bike_after_icon.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("bike_after_icon", image);
		
		url = Resource.class.getResource("images/cars/used_cars/truck_before_icon.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("truck_before_icon", image);
		
		url = Resource.class.getResource("images/cars/used_cars/truck_after_icon.png");
		icon = new ImageIcon(url);
		image = icon.getImage();
		imagesMap.put("truck_after_icon", image);
		
	}
	
	public static InputStream getStream(String name) throws IOException {
		
		return Resource.class.getResourceAsStream("serialize/temp" + name + ".out");
		
	}
	
	public static Image getImage(String key) {
		return imagesMap.get(key);
	}
	
}
