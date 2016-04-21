package com.bossket.basica;

import java.util.Date;
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
public class Jogo {

	@Id
	@Column(name = "id_jogo")
	@GeneratedValue()
	private int id;
	private	Date data;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_campeonato")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Campeonato camp;
	public Campeonato getCamp() {
		return camp;
	}

	public void setCamp(Campeonato camp) {
		this.camp = camp;
	}

	@ManyToMany
	@JoinTable(name = "jogador_jogo", joinColumns = { @JoinColumn(name = "id_jogo") }, inverseJoinColumns = { @JoinColumn(name = "id_jogador") })
	private List<Jogador> listJogador;
	@ManyToMany
	@JoinTable(name = "time_jogo",joinColumns = { @JoinColumn(name = "id_jogo") }, inverseJoinColumns = { @JoinColumn(name = "id_time") })
	private List<Time> listTim;

	@OneToMany(mappedBy = "jogador")
	private List<Ponto> listPonto;
	
	public List<Jogador> getListJogador() {
		return listJogador;
	}

	public void setListJogador(List<Jogador> listJogador) {
		this.listJogador = listJogador;
	}

	public List<Time> getListTim() {
		return listTim;
	}

	public void setListTim(List<Time> listTim) {
		this.listTim = listTim;
	}

	public List<Ponto> getListPonto() {
		return listPonto;
	}

	public void setListGol(List<Ponto> listPonto) {
		this.listPonto = listPonto;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Ponto> getPonto() {
		return listPonto;
	}

	public void setGol(List<Ponto> ponto) {
		this.listPonto = ponto;
	}

}
