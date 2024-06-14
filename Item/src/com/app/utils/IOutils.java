package com.app.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import com.app.item.Item;

public interface IOutils {
	static void writeDetails(List<Item>list,String filename) throws IOException {
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(list);
			
		}
	}
}
