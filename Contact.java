package contact;

public class Contact {
	
	private String contactId;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	
	public Contact(String contactId, String firstName, String lastName, String address, String phoneNumber) {	// Constructor 
		
		boolean isValid = validateInput(contactId, 10);		//validate inputs against requirements
			
		if(isValid) {
			this.contactId = contactId;
		}
		
		isValid = isValid && setContactFirstName(firstName);
		isValid = isValid && setContactLastName(lastName);
		isValid = isValid && setAddress(address);
		isValid = isValid && setPhoneNumber(phoneNumber);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
		}
		
	}
	
	public boolean setContactFirstName(String firstName) {	// Method for setting first name
		boolean isValid = validateInput(firstName, 10);
		
		if(isValid) {										// Validates the name using validation statements above
			this.firstName = firstName;
		}
		return isValid;
	}
	
	public boolean setContactLastName(String lastName) {	// Setter and validation
		boolean isValid = validateInput(lastName, 10);
		
		if(isValid) {
			this.lastName = lastName;
		}
		return isValid;
	}
	
	public boolean setAddress(String address) {				// Setter and validation
		boolean isValid = validateInput(address, 20);
		
		if(isValid) {
			this.address = address;
		}

		return isValid;
	}
	
	public boolean setPhoneNumber(String phoneNumber) {		// Setter and validation
		boolean IsValid = phoneNumber.matches("\\d{10}");
		
		if(IsValid) {
			this.phoneNumber = phoneNumber;
		}
		return IsValid;
	}
	
	public String getContactId() {							// Getter and validation
		return contactId;
	}
	
	public String getFirstName() {							// Getter and validation
		return firstName;
	}
	
	public String getLastName() {							// Getter and validation
		return lastName;
	}
	
	public String getAddress() {							// Getter and validation
		return address;
	}
	
	public String getPhoneNumber() {						// Getter and validation
		return phoneNumber;
	}
	
	private boolean validateInput(String item, int length) {	// Method for validating inputs against length requirements
		return (item != null && item.length() <= length);
	}
}
