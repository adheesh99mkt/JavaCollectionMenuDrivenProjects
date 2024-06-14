package com.app.tester;

import java.util.HashMap;
import java.util.Scanner;

import com.app.store.Order;
import com.app.store.Pet;
import com.app.store.User;
import com.app.store.UserType;

import static com.app.validation.ValidateUser.*;
import static com.app.validation.validatePet.*;
import static com.app.validation.PetUtility.*;
import static com.app.validation.ValidateOrder.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, User> userMap=new HashMap<>();
		HashMap<Integer, Pet> petMap=new HashMap<>();
		HashMap<Integer, Order> orderMap=new HashMap<>();
		
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				System.out.println("Enter the choice:\n"
						+ "1.Register User\n"
						+ "2.Go to Services\n"
						+ "3.exit"
						);
				try {
					
				
				switch(sc.nextInt()) {
				
				case 1:
					//register user
					System.out.println("Enter the password and userType");
					User user=validateAllInp(sc.next(), sc.next());
					userMap.put(user.getId(), user);
					System.out.println(user.getType()+" is Added");
					break;
				case 2:
					//go to service
					boolean flag=false;
					while(!flag) {
						System.out.println("Enter the choice:\n"
								+ "1.Login\n"
								+ "2.Add new Pet (Admin only functionality)\n"
								+ "3.Update Pet details (Admin only functionality)\n"
								+ "4.Display all available pets\n"
								+ "5.Order a Pet\n"
								+ "6.Check order status by Order Id\n"
								+ "7.Update order status (Admin only functionality)\n"
								+ "8.Exit\n");
						switch(sc.nextInt()) {
						case 1:
							//login
							System.out.println("Enter the id and password");
							user=login(sc.nextInt(), sc.next(), userMap);
							System.out.println(user.getType()+" successfully logged in..");
							System.out.println(user);
							break;
						case 2:
							//add new pet(only for admin)
							System.out.println("for adding pet..Enter admin id and password");
							user=AdminLogin(sc.nextInt(), sc.next(), userMap);
						
								System.out.println("Enter the details of pet:\n"
										+ "Pet name\n"
										+ "Pet category\n"
										+ "Unit price\n"
										+ "Stock\n");
								Pet pet=valiadateAllInpPet(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
								petMap.put(pet.getPetId(), pet);
								System.out.println(pet.getName()+" added successfully...");
								System.out.println(pet);
								break;
						case 3:
							//update pet(admin only)
							System.out.println("for update pet..Enter admin id and password");
							user=AdminLogin(sc.nextInt(), sc.next(), userMap);
							System.out.println("Enter the pet id to be updated");
							pet=validatePetId(sc.nextInt(), petMap);
							System.out.println("Enter the Updated price and Updated stock");
							pet=updatePet(pet, sc.nextDouble(), sc.nextInt(), petMap);
							System.out.println("Pet details updated.."+pet);
							break;
						case 4:
							System.out.println("All Pets");
							petMap.values().forEach(p->System.out.println(p));
							break;
						case 5:
							//order pet
							System.out.println("Customer login\n"
									+ "enter customer id and password");
							user=CustomerLogin(sc.nextInt(), sc.next(), userMap);
							System.out.println("Enter the pet id and quantity");
							Order order=validateAllInpOrder(sc.nextInt(), sc.nextInt(), petMap);
							orderMap.put(order.getOrderId(), order);
							System.out.println(order.getOrderId()+" Order placed");
							break;
						case 6:
							//check order status
							System.out.println("Customer login\n"
									+ "enter customer id and password");
							user=CustomerLogin(sc.nextInt(), sc.next(), userMap);
							System.out.println("Enter the order id");
							order=validateOrderId(sc.nextInt(), orderMap);
							System.out.println("Order status=>"+order.getStatus());
							break;
						case 7:
							//update order status(for admin)
							System.out.println("for update pet..Enter admin id and password");
							user=AdminLogin(sc.nextInt(), sc.next(), userMap);
							System.out.println("Enter the order id");
							order=validateOrderId(sc.nextInt(), orderMap);
							System.out.println("Enter the updated status");
							order.setStatus(parseOrderStatus(sc.next()));
							System.out.println("Order status updated...");
							System.out.println(order);
							break;
						case 8:
							flag=true;
							System.out.println("Exited from service page");
							break;
	
						}
						
					}
				case 3:
					exit=true;
					System.out.println("exited");
					break;
				}
				}
				catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
			
			
			
		}
		

	}

}
