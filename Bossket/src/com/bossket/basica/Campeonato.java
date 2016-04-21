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
public class Campeonato {

	@Id
	@Column(name = "id_campeonato")
	@GeneratedValue()
	private int id;

	@Column(length = 45, nullable = false, unique = true)
	private String nome;

	@Column(nullable = true)
	private int qtdTimes;

	@OneToMany(mappedBy="camp", fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Time> listTim;
	@OneToMany(mappedBy="camp", fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Jogo> listJog;

	public List<Time> getlistTim() {
		return listTim;
	}

	public void setlisttim(List<Time> listTim) {
		this.listTim = listTim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdTimes() {
		return qtdTimes;
	}

	public void setQtdTimes(int qtdTimes) {
		this.qtdTimes = qtdTimes;
	}
}
