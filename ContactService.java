package contactService;

import java.util.HashMap;
import java.util.Map;

import contact.Contact;
import task.Task;

public class ContactService {
	
	private static ContactService reference = new ContactService();		// Creating a reference for future objects
	private final Map<String, Contact> contacts;
	
	 ContactService() {													// Creating a hash map to connect keys to values
		 this.contacts = new HashMap<String, Contact>();
	 }
	 
		//Create a singleton Contact Service
	 public static ContactService getService() {
		 return reference;
	 }
	 
	 public boolean addContact(Contact contact) {						// Method to add contacts and validating
		 boolean isSuccess = false;										// that it does not already exist in memory
		 
		 if(!contacts.containsKey(contact.getContactId())) {
			 contacts.put(contact.getContactId(), contact);
			 isSuccess = true;
		 }
		 return isSuccess;
	 }
	 
	 public boolean deleteContact(String contactId) {					// Delete contact method
		 return contacts.remove(contactId) != null;
	 }
	 
	 public Contact getContact(String contactId) {						// Get contact method
		 return contacts.get(contactId);
	 }
	 
	 public boolean updateContact(String contactId, String firstName, String lastName, String address, String phoneNumber) {
	     boolean isSuccess = false;
	     if (contacts.get(contactId) != null) {
	    	 Contact contact = contacts.get(contactId);						// Method for updating contact
             contact.setContactFirstName(firstName);						// if id exists get contacts reference
             contact.setContactLastName(lastName);							// and set values accordingly
             contact.setAddress(address);
             contact.setPhoneNumber(phoneNumber);
             contacts.put(contactId, contact);
             isSuccess = true;
	     }
         
		 return isSuccess;
	 }

}
