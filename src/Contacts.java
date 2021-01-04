/**
 * class makes changes to the users contacts list
 */
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;



public class Contacts {
    
    HashMap<String, String> changing;//will store the list of contacts that is up for change
    
    HashMap<String, String> keepall;//will store everysingle person who has been ever listed as a contact
  /**
   * creates a contact list with the string names  which are files
   * 
   * @param names
   * @throws IOException
   */
   public Contacts(String names) throws IOException{
       
       keepall = new HashMap<String, String>();
       
       changing = new HashMap<String, String>();
      
       File textnames = new File(names);//identifies the file
       
       Scanner kb = new Scanner(textnames);

       while (kb.hasNextLine()) {
          
           String[] splitter = kb.nextLine().split(":");//splits one line into 2 Strings, 1 representing the number and 1 representing the name
               
           keepall.put(splitter[0].trim(), splitter[1].trim());//stores the name and the number
           
           changing.put(splitter[0].trim(), splitter[1].trim());//stores the name and the number
       }
   }

   /**
    * returns "not found" if changing does not have name
    * returns returns keepall.get(name) if the name is there
    * @param name
    * @return
    */
   public String getPhoneNumber(String name){
       if(!changing.containsKey(name)) {
    	   return "Not Found";//return not found if the name is not there
       }
	   return keepall.get(name);//return keep all if name is there
   }

   /**
    * deletes a contact
    * @param name
    */
   public void delete(String name){
       changing.remove(name);//removes the name from the hashmap
   }

   /**
    * adds a name and number to the contact list
    * @param name
    * @param number
    */
   public void add(String name, String number){
       if(!changing.containsKey(name)){
          
    	   changing.put(name, number);//adds a new number and name to the hashmap
    	   
           System.out.println("Adding " + name + "   " + number);
       }
   }
   /**
    * makes changes to an already existing contact
    * @param name
    * @param number
    */
   public void change(String name, String number){
        if(changing.containsKey(name)){
        	
            keepall.put(name, number);//changes the number thats in the name
            
        	changing.put(name, number);//changes the number thats in the name
          
        	System.out.println("Changing "+ name + " " + number);
       }
   }

   /**
    * prints the whole contact list
    */
   public void displayDirectory(){
      
       ArrayList<String> fulllist = new ArrayList<String>(changing.keySet());//puts the hasmap into an arraylist
       
       Collections.sort(fulllist);//sorts the arraylist
      
       for (String name : fulllist) {
    	   
           System.out.println(name + " : " + changing.get(name));//displays the whole list
       }
   }
   /**
    * merges the 2 files together into 1 contact list
    * @param phoneDirectory
    * @return
    * @throws IOException
    */
   public ArrayList<String> merge(Contacts phoneDirectory) throws IOException {
       ArrayList<String> fulllist = new ArrayList<String>(changing.keySet());//puts the hasmap into an arraylist
       ArrayList<String> formerge = new ArrayList<String>();
       Collections.sort(fulllist);//sorts the arraylist
       
       for (String name : fulllist) {
    	   formerge.add(name + " : " + changing.get(name));
           phoneDirectory.add(name, changing.get(name));
       
   }
       return formerge;

}
   /**
    * searches for a specific name in the contact list
    * @param title
    * @return
    */
   public String search (String title){
	   String found ="";
	   if(changing.containsKey(title)) {
		   found = changing.get(title);
		   
	   }
	   return found;
   }
}

