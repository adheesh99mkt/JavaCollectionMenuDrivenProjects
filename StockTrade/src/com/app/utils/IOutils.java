package com.app.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.stock.Stock;

public interface IOutils {
	static void writeDetails(Map<String, Stock>mapStock,String filename) throws IOException {
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(mapStock);
		}
	}
}
