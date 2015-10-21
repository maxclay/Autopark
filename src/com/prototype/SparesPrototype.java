package com.prototype;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.main.resource.Resource;



public abstract class SparesPrototype implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String name;
	protected float cost;
	
	public Object ñlone() {
		
		Object clone = null;
		
		try {
			
			InputStream fis = Resource.getStream(this.name);
			ObjectInputStream oin = new ObjectInputStream(fis);
			
			clone = oin.readObject();
			
			oin.close();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		return clone;
		
	}
	
	protected void serialize() {
		FileOutputStream fos;
		try {
			
			fos = new FileOutputStream("data/serialize/temp" + this.name + ".out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.flush();
			oos.close();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}
	
	public float getCost() {
		return cost;
	}
	
	public String getName() {
		return name;
	}
	
}
