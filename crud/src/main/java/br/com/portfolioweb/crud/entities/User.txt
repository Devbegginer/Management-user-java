package br.com.portfolioweb.crud.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//implementar o metodo Serializable

// vamos colocar uma anottation indicando que e a Entidade do banco de dados
// biblioteca jakarta
@Entity
//transformar entidade em tabela
@Table(name = "tb_users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	// Atributos do usuario	
	// colocar uma chave primaria
	@Id
	//colocar autoincremento
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String password;
	//aviso: variaveis nao usadas

	//construtor vazio
	public User() {
		super();
	}
	//construtor cheio

	public User(Long id, String nome, String email, String telefone, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
	}
	//criar getters e setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//gerar a implementacao para o metodo HashCode() e equals() -> Faz a comparacao
	// entre dois campos

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
   