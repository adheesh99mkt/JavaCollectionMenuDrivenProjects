package com.app.validation;

import java.util.Map;

import com.app.custome_exception.CustomeExc;
import com.app.store.Pet;
import static com.app.validation.validatePet.*;

public class PetUtility {
	public static Pet updatePet(Pet pet,double unitPrice,int stock,Map<Integer, Pet> petMap) throws CustomeExc {
		pet.setUnitPerice(unitPrice);
		pet.setStock(stock);
		return pet;
	}
}
