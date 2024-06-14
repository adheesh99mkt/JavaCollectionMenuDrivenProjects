package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.exception.PenCustomeException;
import com.app.pen.Pen;
import com.app.pen.PenBrand;
import com.app.pen.PenColor;
import com.app.pen.PenInkColor;
import com.app.pen.PenMaterial;

public class ValidatePen {
	/*" brand\n"
							+ "	color\n"
							+ "	penColorr\n"
							+ "	material\n"
							+ "	stock\n"
							+ "	updateDate\n"
							+ "	listDate\n"
							+ "	price\n"
							+ "	discount\n"
							+ "");*/
	public static Pen validateInput(String brand,String color,String penColor,String material,int stock,String updateDate,String listDate,double price,double discount) throws PenCustomeException {
		PenBrand br=parsePenBrand(brand);
		PenColor clr=parsePenColor(color);
		PenInkColor InkClr=parsePenColorInk(penColor);
		PenMaterial mat=parsePenMaterial(material);
		return new Pen(br, clr, InkClr, mat, stock, parseDate(updateDate), parseDate(listDate), price, discount);
	}
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	public static PenBrand parsePenBrand(String brand) throws PenCustomeException {
		PenBrand br= PenBrand.valueOf(brand.toUpperCase());
		if(br==null) {
			throw new PenCustomeException("Invalid brand!");
		}
		return br;
	}
	public static PenInkColor parsePenColorInk(String penColor) throws PenCustomeException {
		PenInkColor clr= PenInkColor.valueOf(penColor.toUpperCase());
		if(clr==null) {
			throw new PenCustomeException("Invalid ink color");
		}
		return clr;
	}
	public static PenColor parsePenColor(String penColor) throws PenCustomeException {
		PenColor pclr= PenColor.valueOf(penColor.toUpperCase());
		if(pclr==null) {
			throw new PenCustomeException("Invalid Pen Color");
		}
		return pclr;
	}
	public static PenMaterial parsePenMaterial(String material) throws PenCustomeException {
		PenMaterial pmat= PenMaterial.valueOf(material.toUpperCase());
		if(pmat==null) {
			throw new PenCustomeException("Invalid Pen Material");
		}
		return pmat;
	}
	
	public static Pen validatePenDetails(int id,List<Pen> penList) throws PenCustomeException {
		
		Pen pen=new Pen(id);
		if(penList.contains(pen)) {
			return pen;
			
		}
		
		throw new PenCustomeException("pen not present");
		
	}
	
	
	
}
