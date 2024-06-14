package com.app.validation;

import java.util.Map;

import com.app.custome_exception.CustomeExc;
import com.app.store.Pet;
import com.app.store.PetCategory;

public class validatePet {
	//name, category, unitPrice, stocks
	public static Pet valiadateAllInpPet(String name,String category,double price,int stock) throws CustomeExc {
		return new Pet(name, parsePet(category), price, stock);
	}
	public static PetCategory parsePet(String category) throws CustomeExc {
		PetCategory petcategory=PetCategory.valueOf(category.toUpperCase());
		if(petcategory==null) {
			throw new CustomeExc("Invalid Pet category!");
		}
		return petcategory;
	}
	public static Pet validatePetId(int id,Map<Integer, Pet> petMap) throws CustomeExc {
		Pet pet=petMap.get(id);
		if(pet==null) {
			throw new CustomeExc("Pet is not present in store");
		}
		return pet;
	}
}
