package com.app.sort;

import java.util.Comparator;

import com.app.cricketer.Cricketer;

public class RatingSort implements Comparator<Cricketer> {

	@Override
	public int compare(Cricketer o1, Cricketer o2) {
		// TODO Auto-generated method stub
		if(o1.getRating()<o2.getRating()) {
			return -1;
		}
		else if(o1.getRating()>o2.getRating()) {
			return 1;
		}
		return 0;
	}

}
