package br.com.portfolioweb.crud.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.portfolioweb.crud.entities.User;
import br.com.portfolioweb.crud.repositories.UserRepository;
import br.com.portfolioweb.crud.services.exceptions.ResourceNotFoundException;

//passo 12
//Injete um atributo do tipo UserRepository à esta classe 
//utilizando a annotation @Autowired.
@Service 
public class UserService {
	
	//create atribute UserRepository and instance 
	//with Autowired Annotation
	@Autowired
	private UserRepository repository;
	// auto complete = Ctrl + Shift + o
	//this method bring list of users through 
	//findAll() method
	public List<User> findAll() {
		return repository.findAll();	
	// it`s necessary to deploy this method in 
	// UserResource for bring datas automatically.
	}
	//create the next method 
	public User findById(Long id) {
		 //this method receive id of each user
		//each user have id 
		Optional<User> user = repository.findById(id);
		//implements new functions responsible
		//personalized message
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
		//deploy this method in UserResource
		
	}
	
	//3 method = Insert
	// only
	public User insert(User user) {
		return repository.save(user);
		
	}
	public void delete(Long id) {
		
		 try {
		 repository.deleteById(id);
		 //there is no return anything when using void as a class
	}catch (ResourceNotFoundException e ) {
	}
	 
		 }
		 
		 
	//method update
	// Need two parametrs ID and User
	public User update(Long id, User user) {
		try {
		// Register of user
		User register = repository.getReferenceById(id);
		updateData(register, user);
		//Save this data in the database
		return repository.save(register);
		}
		catch (RuntimeException e) {
			
		}
		throw new ResourceNotFoundException(id);
	}
	private void updateData(User register, User user) {
		//implements logic
		// only can be modified Nome,Email and Telefone, NOT ID.
		// Data to be updated
		register.setNome(user.getNome());
		register.setEmail(user.getEmail());
		register.setTelefone(user.getTelefone());
	}
}
