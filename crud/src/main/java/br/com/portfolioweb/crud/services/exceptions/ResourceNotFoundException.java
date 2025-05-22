package br.com.portfolioweb.crud.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	//RuntimeException = lanca excessoes que o compilador nao e obrigado a tratar
	
	// PErsonalized Message
	public ResourceNotFoundException(Object id) {
		// implement the constructor of the class by calling the parent constructor, 
		// passing a custom message.
		super("The user entered is not registered in the system, please check that the user is properly registered.User ID not found: " + id);
		 
	}

}
 