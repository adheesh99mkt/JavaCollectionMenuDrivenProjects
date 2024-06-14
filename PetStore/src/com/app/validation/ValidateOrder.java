package com.app.validation;

import java.util.Map;

import com.app.custome_exception.CustomeExc;
import com.app.store.Order;
import com.app.store.OrderStatus;
import com.app.store.Pet;
import static com.app.validation.validatePet.*;
public class ValidateOrder {
	//petId, quantity, status)
	public static Order validateAllInpOrder(int petId,int quantity,Map<Integer,Pet>petMap) throws CustomeExc {
		Pet pet=validatePetId(petId, petMap);
		if(pet.getStock()>quantity) {
			pet.setStock(pet.getStock()-quantity);
			return new Order(petId, quantity);
		}
		throw new CustomeExc("No sufficient stock available!");
		
	}
	public static Order validateOrderId(int id,Map<Integer,Order>orderMap) throws CustomeExc {
		Order order=orderMap.get(id);
		if(order==null) {
			throw new CustomeExc("No such order present!");
		}
		return order;
	}
	public static OrderStatus parseOrderStatus(String status) throws CustomeExc {
		OrderStatus orderStatus=OrderStatus.valueOf(status.toUpperCase());
		if(orderStatus==null) {
			throw new CustomeExc("invalid order status");
		}
		return orderStatus;
	}
	
	
	
}
