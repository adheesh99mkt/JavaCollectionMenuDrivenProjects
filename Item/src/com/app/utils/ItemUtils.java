package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.item.Item;

public class ItemUtils {
	public static List<Item> populateList(){
		List<Item> list=new ArrayList<Item>(
				Arrays.asList(new Item("z123a", "zyxw", 100, LocalDate.parse("2023-01-09")),
						new Item("c987d", "jhdg", 100, LocalDate.parse("2023-01-09")),
						new Item("x456y", "fwyu", 20, LocalDate.parse("2021-09-01")),
						new Item("a356b", "mbcdjh", 10, LocalDate.parse("2022-04-07")),
						new Item("j767m", "iudgi", 200, LocalDate.parse("2020-01-08"))
						)
				);
		return list;
	}
}
