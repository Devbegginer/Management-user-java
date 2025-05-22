package br.com.portfolioweb.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portfolioweb.crud.entities.User;

// a classe pediu um User
// e um Id
public interface UserRepository extends JpaRepository<User, Long> {

}
