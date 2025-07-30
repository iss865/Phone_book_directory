package phone;

//importing packages
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

//Main class
class Main {
	public static void main(String[] args) {
// Scanner for user input
		Scanner sc = new Scanner(System.in);
// Creating object of Phone class
		Phone phone = new Phone();
// Variables
		int ch = 0, i;
// Main menu loop
		do {
// Displaying menu options
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"Enter:\n1. To add and display previous contacts as it is.\n2. To delete all old contacts from phone and accept new contact details\n3. Todisplay contact details.\n4. To create a new contact.\n5. To delete acontact.\n6. Favourites.\n7. To edit contact.\n8. To search a contact.\n9. Toblock.\n10. Exit ");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			ch = sc.nextInt();
// Switch case based on user input
			switch (ch) {
			case 1:
				phone.dis();
				break;
			case 2:
// Accept contact details
				phone.accept();
				break;
			case 3:
// Display contact details
				phone.display();
				break;
			case 4:
// Add a new contact
				phone.add();
				break;
			case 5:
// Delete a contact
				phone.delete();
				break;
			case 6:
// Submenu for adding to favorites
				int n = 0;
				do {
					System.out.println(
							"------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println(
							"Enter one option:\n1) Add to favourites.\n2) Remove from favourites.\n3) Display favourite contacts.\n4) Exit");
					System.out.println(
							"------------------------------------------------------------------------------------------------------------------------------------------------------------");
					n = sc.nextInt();
					switch (n) {
					case 1:
// Add to favorites
						phone.add_fav();
						break;
					case 2:
// Remove from favorites
						phone.remove();
						break;
					case 3:
// Display favorite contacts
						phone.favourite();
						break;
					}
				} while (n != 4);
				break;
			case 7:
// Editing contact details
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Enter:\n1. If you want to edit name.\n2. If you want to edit phone number.");
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------------------");
				int a = sc.nextInt();
				if (a == 1) {
// Edit name
					System.out.print("Enter old name: ");
					String beditname = sc.next();
					System.out.print("Enter new name: ");
					String aeditname = sc.next();
					phone.edit(beditname, aeditname);
				} else if (a == 2) {
// Edit phone number
					System.out.print("Enter old phone number: ");
					Long beditno = sc.nextLong();
					System.out.print("Enter new phone number: ");
					Long aeditno = sc.nextLong();
					phone.edit(beditno, aeditno);
				} else {
					System.out.println("Invalid option chosen!");
				}
				break;
			case 8:
// Search for a contact
				phone.search();
				break;
			case 9:
				int r = 0;
				do {
					System.out.println(
							"------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println(
							"Enter \n 1)Block contact by contact name \n 2)display blocked contacts \n 3)remove from block \n 4)Exit");
					System.out.println(
							"------------------------------------------------------------------------------------------------------------------------------------------------------------");
					r = sc.nextInt();
					switch (r) {
					case 1:
						phone.coblock();
						break;
					case 2:
						phone.bdisplay();
						break;
					case 3:
						phone.block_remove();
						break;
					case 4:
						break;
					default:
						System.out.println("Exit");
					}
				} while (r != 4);
			case 10:
				System.out.println("EXIT!!");
				break;
// Exit
			default:
				System.out.println("INVALID INPUT");
			}
		} while (ch != 10); // Exit loop if choice is 10
	}
}

//Phone class
class Phone {
	Scanner sc = new Scanner(System.in);
// Member variables
	private Long phone_no;
	private String name, sign_date, type, block_name;
	int i = 0;
	private ArrayList<Long> phoneno = new ArrayList<>();
	private ArrayList<String> namee = new ArrayList<>();
	private ArrayList<String> typee = new ArrayList<>();
	private ArrayList<Long> blockno = new ArrayList<>();
	private ArrayList<String> blockname = new ArrayList<>();
	private ArrayList<String> date = new ArrayList<>();
	private ArrayList<String> favcon = new ArrayList<String>();

// Constructor
	public Phone() {
// Welcome message
		String ANSI_RESET = "\u001B[0m";
		String ANSI_PURPLE = "\u001B[35m";
		System.out.println(
				"************************************************************************************************************************************************************************************************************************************************************************************************************************\n");
		System.out.println(
				ANSI_PURPLE + "\t\t\t\t\t\t WELCOME TO PHONE BOOK MANAGEMENT JAVA MINI PROJECT \n" + ANSI_RESET);
		System.out.println(
				"************************************************************************************************************************************************************************************************************************************************************************************************************************\n");
	}

// Methods
	void contacts() {
// Method to initialize sample contact details
// Adding sample contact details
// Each contact consists of name, phone number, type, and date
// Sample contact 1
		namee.add("Shital");
		phoneno.add(1234567890l);
		typee.add("Informal");
		date.add("12/5/2009");
// Sample contact 2
		namee.add("Maya");
		phoneno.add(5678459876l);
		typee.add("Informal");
		date.add("2/6/2003");
// Sample contact 3
		namee.add("Bestie");
		phoneno.add(9887988776l);
		typee.add("Informal");
		date.add("18/7/2005");
// Sample contact 4
		namee.add("Boss");
		phoneno.add(6979898986l);
		typee.add("Formal ");
		date.add("6/5/2023");
// Sample contact 5
		namee.add("Sir");
		phoneno.add(1234898986l);
		typee.add("Formal ");
		date.add("8/5/2022");
// Sample contact 6
		namee.add("Cousin");
		phoneno.add(6976708861l);
		typee.add("Informal");
		date.add("17/12/2008");
// Sample contact 7
		namee.add("Ramesh");
		phoneno.add(9874343986l);
		typee.add("Formal ");
		date.add("8/12/2023");
// Sample contact 8
		namee.add("Rama");
		phoneno.add(9123455486l);
		typee.add("Formal ");
		date.add("6/4/2017");
// Sample contact 9
		namee.add("Mam");
		phoneno.add(9970898986l);
		typee.add("Formal ");
		date.add("4/5/1997");
// Sample contact 10
		namee.add("Tina");
		phoneno.add(9876434669l);
		typee.add("Informal");
		date.add("12/3/2000");
	}

	void dis() {
// Method to display contact details
// Initialize and load sample contacts
		contacts();
// Printing header for contact details
		System.out.println(
				"---------------------------------------------------------------#-CONTACT DETAILS-#--------------------------------------------------------------------------\n");
		System.out.println("NAME OF CONTACT \t PHONE NUMBER \t TYPE OF CONTACT \t SIGNIFICANT DATE \n");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------");
// Iterating through the list of contacts and printing each contact detail
		for (int i = 0; i < namee.size(); i++) {
			System.out
					.println(namee.get(i) + "\t\t\t" + phoneno.get(i) + "\t\t" + typee.get(i) + "\t\t\t" + date.get(i));
		}
	}

	public void accept() {
// Method to accept contact details
		phoneno.clear();
		namee.clear();
		date.clear();
		typee.clear();
		System.out.print("How many contact details you want to enter?: ");
		int no = sc.nextInt();
		for (int i = 0; i < no; i++) {
			System.out.print("Enter phone number: ");
			long phone_no = sc.nextLong();
// Check if phone number is greater than 10 digits
			if (String.valueOf(phone_no).length() > 10) {
				System.out.println("Phone number cannot be greater than 10 digits. Please enter again.");
				i--; // Decrement i to repeat this iteration
				continue; // Skip the rest of the loop body
			}
			System.out.print("Enter name: ");
			String name = sc.next();
			if (phoneno.contains(phone_no) || namee.contains(name)) {
				System.out.println("This contact is already saved");
			} else {
				phoneno.add(phone_no);
				namee.add(name);
				System.out.print("Enter this contact is formal or informal: ");
				String type = sc.next();
				typee.add(type);
				System.out.print("Enter significant date (in DD/MM/YYYY format): ");
				String sign_date = sc.next();
				date.add(sign_date);
				System.out.println("\n");
			}
		}
		String ANSI_RESET = "\u001B[0m";
		String ANSI_GREEN = "\u001B[32m";
		System.out.println(ANSI_GREEN + "CONTACT DETAILS ACCEPTED AND SAVED SUCCESSFULLY!!" + ANSI_RESET);
	}

	void display() {
// Method to display contact details
		int ch = 0;
		if (namee.size() == 0) {
			System.out.println("CONTACT LIST IS EAMPTY");
		} else if (namee.size() != 0) {
			do {
// printing submenu
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"Choose one option- \n 1)Display all ditails. \n 2)Display contactaphabaticaly. \n 3)Exit.");
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------");
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("CONTACT DETAILS");
					for (i = 0; i < namee.size(); i++) {
						System.out.println("Name : " + namee.get(i));
						System.out.println("Phone no : " + phoneno.get(i));
						System.out.println("Type : " + typee.get(i));
						System.out.println("Significante date : " + date.get(i));
						System.out.println();
					}
					break;
				case 2:
					System.out.println("CONTACT LIST");
					Collections.sort(namee);
					for (i = 0; i < phoneno.size(); i++) {
						System.out.println(namee.get(i));
					}
					break;
				default:
					System.out.println("EXIT!");
				}
			} while (ch != 3);
		}
	}

	void add() {
// Method to add contact details
		System.out.print("How many new contacts do you want to create?: ");
		int addno = sc.nextInt();
		for (int i = 0; i < addno; i++) {
			System.out.print("Enter phone number: ");
			long phone_no = sc.nextLong();
// Check if phone number is greater than 10 digits
			if (String.valueOf(phone_no).length() > 10) {
				System.out.println("Phone number cannot be greater than 10 digits. Please enter again.");
				i--; // Decrement i to repeat this iteration
				continue; // Skip the rest of the loop body
			}
			System.out.print("Enter name: ");
			String name = sc.next();
			if (namee.contains(phone_no) || phoneno.contains(phone_no)) {
				System.out.println("This contact is already saved");
			} else {
				phoneno.add(phone_no);
				namee.add(name);
				System.out.print("Enter email id: ");
				String email = sc.next();
				typee.add(email);
				System.out.print("Enter significant date (in DD/MM/YYYY format): ");
				String sign_date = sc.next();
				date.add(sign_date);
				String ANSI_RESET = "\u001B[0m";
				String ANSI_GREEN = "\u001B[32m";
				System.out.println(ANSI_GREEN + "CONTACT DETAILS ADDED AND SAVED SUCCESSFULLY!!" + ANSI_RESET);
				System.out.println("\n\n");
			}
		}
	}

	void delete() {
// Method to delete contact details
		boolean found = false; // Flag to indicate if the contact to be deleted is found
		System.out.print("How many contacts do you want to delete?: ");
		int delno = sc.nextInt();
		for (i = 0; i < delno; i++) {
			System.out.print("Enter name of contact which you want to delete: ");
			String delname = sc.next();
// Loop through the list of names to find the contact to be deleted
			for (int j = 0; j < namee.size(); j++) {
				if (delname.equalsIgnoreCase(namee.get(j))) {
// Remove the contact details if the name matches
					namee.remove(j);
					phoneno.remove(j);
					date.remove(j);
					typee.remove(j);
// Printing success message
					String ANSI_RESET = "\u001B[0m";
					String ANSI_GREEN = "\u001B[32m";
					System.out.println(ANSI_GREEN + "CONTACT DETAILS DELETED SUCCESSFULLY!!" + ANSI_RESET);
// Exit the loop once the contact is deleted
					break;
				} else if (namee.contains(delname) == false) {
// Set flag to true if the name is not found
					found = true;
				}
			}
			System.out.println("\n\n");
		}
// Print message if the name to be deleted is not found
		if (found) {
			System.out.println("This name doesn't exist in the contacts.");
		}
	}

	void add_fav() {
// Method to add contacts to favorites
		boolean found = false; // Flag to indicate if the contact is found
		System.out.print("How many contacts do you want to add to favorites?: ");
		int add = sc.nextInt();
		for (int i = 0; i < add; i++) {
			System.out.print("Enter name: ");
			String favname = sc.next();
// Check if the entered name exists in the contacts list
			if (namee.contains(favname)) {
// Add the contact to favorites if found
				favcon.add(favname);
// Print success message
				String ANSI_RESET = "\u001B[0m";
				String ANSI_GREEN = "\u001B[32m";
				System.out.println(ANSI_GREEN + "CONTACT DETAILS ADDED TO FAVORITES SUCCESSFULLY!!" + ANSI_RESET);
			} else {
// Set flag to true if the name is not found
				found = true;
				System.out.println("\n");
			}
		}
// Print message if the name to be added to favorites is not found
		if (found) {
			System.out.println("This name doesn't exist.");
		}
	}

	void remove() {
// Method to remove contacts from favorites
		favourite(); // Load favorite contacts
		boolean found = false; // Flag to indicate if the contact to be removed is found
		if (favcon.size() == 0) {
// Check if the favorite contact list is empty
			System.out.println("Favorite contact list is Empty");
		} else {
// If favorite contact list is not empty
			System.out.print("How many contacts do you want to remove: ");
			int remove = sc.nextInt();
			for (int i = 0; i < remove; i++) {
// Iterate through the contacts to be removed
				System.out.print("Enter name: ");
				String favname = sc.next();
				if (favcon.contains(favname)) {
// Remove the contact if found in the favorites list
					favcon.remove(favname);
					System.out.println("This contact is removed from favorites");
				} else {
// Set flag to true if the contact is not found in favorites
					found = true;
				}
			}
			if (found) {
// Print message if the contact to be removed is not found in favorites
				System.out.println("This name does not exist in favorite contacts.");
			}
		}
	}

	void favourite() {
// Method to display favorite contacts
		if (namee.size() == 0) {
// Check if the contact list is empty
			System.out.println("CONTACT LIST EMPTY");
		} else if (favcon.size() != 0) {
// If favorite contacts exist
			System.out.println("Favorite Contacts are as follows:");
// Iterate through the favorite contacts and display them
			for (int i = 0; i < favcon.size(); i++) {
				System.out.println(favcon.get(i));
				System.out.println(phoneno.get(i) + "\n");
			}
		}
	}

	void search() {
// Method to search for contacts by phone number or name
		int ch = 0;
		do {
// Display menu for search options
			System.out.println("Choose one option- \n 1)Search by phone number. \n 2)Search by name. \n 3)Exit.");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
// Searching by phone number
				boolean found = false;
				System.out.print("Enter phone number to search: ");
				long search_no = sc.nextLong();
				for (int i = 0; i < namee.size(); i++) {
					if (search_no == phoneno.get(i)) {
// If phone number is found, display contact details
						System.out.println("Name : " + namee.get(i));
						System.out.println("Email : " + typee.get(i));
						System.out.println("Significant Date : " + date.get(i));
						found = true;
						break;
					}
				}
				if (!found) {
// Print message if phone number is not found
					System.out.println("This phone number does not exist in contacts.");
				}
				break;
			case 2:
// Searching by name
				boolean found2 = false;
				System.out.print("Enter name to search: ");
				String search_name = sc.next();
				for (int i = 0; i < namee.size(); i++) {
					if (search_name.equalsIgnoreCase(namee.get(i))) {
// If name is found, display contact details
						System.out.println("Phone number : " + phoneno.get(i));
						System.out.println("Type : " + typee.get(i));
						System.out.println("Significant Date : " + date.get(i));
						found2 = true;
						break;
					}
				}
				if (!found2) {
// Print message if name is not found
					System.out.println("This name does not exist in contacts.");
				}
				break;
			case 3:
// Exit the search process
				System.out.println("Exit!!");
				break;
			}
		} while (ch != 3); // Repeat the process until the user chooses to exit
	}

	void edit(String beditname, String aeditname) {
// Method to edit contact details
		boolean found = false; // Flag to indicate if the contact to be edited is found
// Iterate through the list of names to find the contact to be edited
		for (int i = 0; i < namee.size(); i++) {
			if (beditname.equalsIgnoreCase(namee.get(i))) {
// If the contact to be edited is found, replace the old name with the new one
				namee.set(i, aeditname);
// Print success message
				String ANSI_RESET = "\u001B[0m";
				String ANSI_GREEN = "\u001B[32m";
				System.out.println(ANSI_GREEN + "CONTACT DETAILS EDITED SUCCESSFULLY!!" + ANSI_RESET);
// Exit the loop
				break;
			} else if (phoneno.contains(beditname) == false) {
// Set flag to true if the name is not found
				found = true;
			}
		}
// Print message if the name to be edited is not found
		if (found) {
			System.out.println("This name does not exist in contacts");
		}
	}

	void edit(long beditno, long aeditno) {
		boolean found = false;
		if (namee.size() == 0) {
			System.out.println("NO CONTACT EXIST");
		} else {
			for (i = 0; i < namee.size(); i++) {
				if (phoneno.get(i) == beditno) {
					phoneno.set(i, aeditno);
					String ANSI_RESET = "\u001B[0m";
// Declaring the color
					String ANSI_GREEN = "\u001B[33m";
					System.out.println(ANSI_GREEN + "CONTACT DETAILS EDITED SUCCESSFULLY!!" + ANSI_RESET);
					break;
				} else if (phoneno.contains(beditno) == false) {
					found = true;
				}
			}
			if (found) {
				System.out.println("This no do not exist in contact");
			}
		}
	}

	void coblock() {
// Method to block a contact
		boolean found = false; // Flag to indicate if the contact to be blocked is found
// Prompt user to enter the name of the contact to block
		System.out.println("Enter contact name to block");
		String block_name = sc.next();
// Iterate through the list of names to find the contact to be blocked
		for (int i = 0; i < namee.size(); i++) {
			if (block_name.equalsIgnoreCase(namee.get(i))) {
// If the contact to be blocked is found, add it to the blocked contacts list
				blockname.add(block_name);
				blockno.add(phoneno.get(i));
				System.out.println("This contact is blocked");
				found = true;
				break;
			} else if (!namee.contains(block_name)) {
// Set flag to true if the contact is not found
				found = true;
			}
		}
// Print message if the contact to be blocked is not found
		if (found) {
			System.out.println("This contact is not present");
		}
	}

	void block_remove() {
// Method to remove a contact from the block list
		boolean found = false; // Flag to indicate if the contact to be removed from block is found
// Prompt user to enter the name of the contact to remove from block
		System.out.println("Enter name of contact to remove from block");
		String reblock = sc.next();
// Iterate through the list of blocked names to find the contact to be removed
		for (int i = 0; i < blockname.size(); i++) {
			if (reblock.equalsIgnoreCase(blockname.get(i))) {
// If the contact to be removed from block is found, remove it from the blocked
// contacts list
				blockno.remove(i);
				blockname.remove(i);
				System.out.println("This contact is removed from block");
				found = true;
				break;
			} else if (!blockname.contains(reblock)) {
// Set flag to true if the contact is not found in the block list
				found = true;
			}
		}
// Print message if the contact to be removed from block is not found
		if (found) {
			System.out.println("This contact is not present in the block list");
		}
	}

	void bdisplay() {
// Method to display blocked contacts
		if (blockname.size() != 0) { // Check if there are any contacts blocked
			System.out.println("BLOCKED CONTACTS");
// Iterate through the list of blocked contacts and display them
			for (int i = 0; i < blockname.size(); i++) {
				System.out.println(blockname.get(i)); // Display blocked contact name
				System.out.println(blockno.get(i) + "\n"); // Display blocked contact phone number
			}
		} else if (blockname.size() == 0) {
// If no contacts are blocked, print appropriate message
			System.out.println("No contact is blocked");
		}
	}
}