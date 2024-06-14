package com.app.store;

public class Order {
	//orderId, petId, quantity, status
	private int orderId;
	private int petId;
	private int quantity;
	private OrderStatus status;
	
	private static int counter=0;

	public Order(int petId, int quantity) {
		super();
		counter++;
		this.orderId=counter;
		this.petId = petId;
		this.quantity = quantity;
		this.status = OrderStatus.PLACED;
	}

	public Order(int orderId) {
		super();
		this.orderId = orderId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Order) {
			Order order=(Order)obj;
			return this.orderId==order.orderId;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.orderId;
	}
	
	
	
}
