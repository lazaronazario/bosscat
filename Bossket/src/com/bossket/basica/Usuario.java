package com.bossket.basica;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;


@Entity
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue()
	private Integer id;
	@Column(nullable = false, unique = true)
	private String login;
	@Column(nullable = false, unique = false)
	private String senha;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Time> tim;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Time> getTim() {
		return tim;
	}

	public void setTim(List<Time> tim) {
		this.tim = tim;
	}
}

