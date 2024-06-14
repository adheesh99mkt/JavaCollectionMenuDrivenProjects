package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.app.pen.Pen;


public class PenUtility {
	public static void addDiscount(List<Pen> penList) {
		for (Pen pen : penList) {
			int year=Period.between(pen.getUpdateDate(),LocalDate.now()).getYears();
			
			if(Period.between(pen.getUpdateDate(),LocalDate.now()).getMonths()+year*12>=3) {
				
				double price= pen.getPrice();
				double disc=price*.20;
				pen.setDiscount(disc);
				
			}
			
		}
		
	}
	public static String updatePenStock(Pen pen,int stock,List<Pen> penList) {
		int index=penList.indexOf(pen);
		Pen pen1=penList.get(index);
		pen1.setStock(stock+pen1.getStock());
		pen1.setUpdateDate(LocalDate.now());
		
		return "Pen stock updated successfully";
	}
	public static void removePen(List<Pen> penList) {
		
		Iterator<Pen> itr=penList.iterator();
		while(itr.hasNext()) {
			LocalDate date=itr.next().getUpdateDate();
			int year=Period.between(date,LocalDate.now()).getYears();
			if(Period.between(date,LocalDate.now()).getMonths()+year*12>=9)
			{
				itr.remove();
			}
		}
	}
}
