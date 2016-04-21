package com.bossket.basica;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Jogador {

	@Id
	@Column(name = "id_jogador")
	@GeneratedValue()
	private int id;
	@Column(length = 45, nullable = false, unique = false)
	private String nome;
	@Column(nullable = false, unique = true)
	private int numero;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_time")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Time time;
	@Column(length = 45, nullable = false)
	private boolean suspenso;

	@OneToMany(mappedBy = "jogador")
	private List<Ponto> listPonto;

	@ManyToMany
	@JoinTable(name = "jogador_jogo",joinColumns = { @JoinColumn(name = "id_jogador") }, inverseJoinColumns = { @JoinColumn(name = "id_jogo") })
	private List<Jogo> listJogo;

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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Time getTim() {
		return time;
	}

	public void setTim(Time tim) {
		this.time = tim;
	}

	public boolean isSuspenso() {
		return suspenso;
	}

	public void setSuspenso(boolean suspenso) {
		this.suspenso = suspenso;
	}

	public List<Ponto> getGol() {
		return listPonto;
	}

	public void setGol(List<Ponto> ponto) {
		this.listPonto = ponto;
	}
}

