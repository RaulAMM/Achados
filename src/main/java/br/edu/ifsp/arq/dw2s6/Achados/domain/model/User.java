package br.edu.ifsp.arq.dw2s6.Achados.domain.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int idUsuario;
	
	
	@NotNull
	@Size(min = 3, max = 50)
	private String nome;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String senha;
	
	@NotNull
	private int tipo;
	
	@ManyToMany(fetch = FetchType.EAGER) 
	@JoinTable(name = "Cupom_has_Usuario", joinColumns = @JoinColumn(name = "Usuario_IdUsuario"),
	inverseJoinColumns = @JoinColumn(name = "Cupom_IdCupom"))
	private List<Cupom> cupoms;
	
	
	
	//Getters e Setters
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public List<Cupom> getCupoms() {
		return cupoms;
	}
	public void setCupoms(List<Cupom> cupoms) {
		this.cupoms = cupoms;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
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
		return Objects.equals(idUsuario, other.idUsuario);
	}	
}
