package com.revature.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.Items;

public class CustomerMenu {
	
	
	public void customerMenu(Scanner sc) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: View avaliable items / Make Offer.");
			System.out.println("2: View items I own.");
			System.out.println("3: View remaining payments.");
			System.out.println("4: Go back");
			
			String input = sc.nextLine();
			
			switch(input) {
			case "1":
				itemsMenu(sc);
				break;
			case "2":
				viewOwnedItems(sc);
				break;
			case "3":
				viewRemainingPayment(sc);
				break;
			case "4":				
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
	
}
	
	private void itemsMenu(Scanner sc) {
		
		Items li = new Items();
		ArrayList<Item> listitems = li.getItems();
		if (listitems != null) {
			for (Item i : listitems) {
				System.out.println(i);
			}
			
			System.out.println("Please select itemID to make offer for:");
			int itemNum = sc.nextInt();
			sc.nextLine();
			System.out.println("Please enter the amount you would like to offer:");
			double itemPrice = sc.nextDouble();
			sc.nextLine();
			
			Items i = new Items();
			i.makeOffer(User.currentUser, itemNum, itemPrice);
			
		}
		else {
			System.out.println("Error retrieving items.");
		}
	
}
	private void viewOwnedItems(Scanner sc) {
		//TODO: Query items and display them
		System.out.println("~ owned item list~");
	}
	private void viewRemainingPayment(Scanner sc) {
		//TODO: Query items and display them
		System.out.println("~ Paymenet Remaining ~");
	}
	
	
}
