/**
 * this is the main driver for the directory
 * 
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

class ContactsMain{
	/**
	 * main method that moves the text files into contacts
	 * @param args
	 * @throws IOException
	 */
  public static void main(String[] args) throws IOException{
    Contacts phoneDirectory = new Contacts("names.txt");
    Contacts edits = new Contacts("update.txt");
    
    menu(phoneDirectory, edits);
  }
  /**
   * gives the user options to choose from for their contacts
   * @param phoneDirectory
   * @param edits
   * @throws IOException
   */
  public static void menu(Contacts phoneDirectory, Contacts edits) throws IOException {
	  boolean end = true;
	  while(end == true) {
		  System.out.println("MENU");
			System.out.println("a - Add a Friend");
			System.out.println("r - Remove a Friend");
			System.out.println("d - Displays all Friends");
			System.out.println("s - Search for Friend");
			System.out.println("c - Change a Friends info");
			System.out.println("m - Merge Directories");
			System.out.println("q - Quit\nChoose an option");
			
			Scanner joemama = new Scanner(System.in);
			char single = joemama.next().charAt(0);//users input on the character they chose
			joemama.nextLine();
					
			if (single == 'A' || single == 'a') {//only passes through if user entered 

						System.out.println("Please enter your friends first and last name ");
						String product = joemama.nextLine();//user enters the name of the item that they want to add

						System.out.println("please enter your friends phone numbere in xxx-xxx-xxxx format");
						String description = joemama.nextLine();//user enters the description of the item they want to add

						

						phoneDirectory.add(product, description); //add Dwight
						
					}

					
					else if (single == 'R' || single == 'r') {//only passes through if the user enter d
						System.out.println("Enter the first and last name of the friend you want to remove");
						String product = joemama.nextLine();//user enters the product that they want to get rid of
						phoneDirectory.delete(product);// shopping cart removes that item
						
						
					}

					
					else if (single == 'D' || single == 'd') {//only passes through if the user enters c
						phoneDirectory.displayDirectory();
						
					}

					
					else if (single == 'S' || single == 's') {//only passes if the user enters i
						    System.out.println("Enter the Friends first and last name");
						    String title = joemama.nextLine();
							String search = phoneDirectory.search(title);
							System.out.println(title + " : " + search);
						
						
					}

					
					else if (single == 'C' || single == 'c') {//only passes if the user enters o
						System.out.println("Please enter your friends first and last name ");
						String john = joemama.nextLine();//user enters the name of the item that they want to add

						System.out.println("please enter your friends phone numbere in xxx-xxx-xxxx format");
						String brandon = joemama.nextLine();//user enters the description of the item they want to add
						phoneDirectory.change(john, brandon);

						
					}
			   
					else if (single == 'M' || single == 'm') {
						
						edits.merge(phoneDirectory);
						
						
					}

					// if 'q', quit program
					else if (single == 'Q' || single == 'q') {//only passes if the user enters q
						break;//stops the program
					}
				}
  }
}
			
		  
		  
		  
