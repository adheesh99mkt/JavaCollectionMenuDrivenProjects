package com.app.sort;

import java.util.Comparator;

import com.app.item.Item;

public class iItemPriceSort implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if(o1.getPrice()<o2.getPrice()) {
			return -1;
		}
		else if(o1.getPrice()>o2.getPrice()) {
			return 1;
		}
		return 0;
	}

}
