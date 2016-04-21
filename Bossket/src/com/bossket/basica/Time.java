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
public class Time {

	@Id
	@Column(name = "id_time")
	@GeneratedValue()
	private int id;
	@Column(length = 45, nullable = false, unique = true)
	private String nome;
	@Column(length = 45, nullable = true)
	private int qtdJogos;
	@Column(length = 45, nullable = true)
	private int pontos;
	@Column(length = 45, nullable = true)
	private int vitorias;
	@Column(length = 45, nullable = true)
	private int derrotas;
	@Column(length = 45, nullable = true)
	private int empates;
	public List<Jogo> getListJogo() {
		return listJogo;
	}

	public void setListJogo(List<Jogo> listJogo) {
		this.listJogo = listJogo;
	}

	private int pontosPro;
	private int pontosContra;
	private int saldopontos;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Usuario user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_campeonato")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Campeonato camp;

	@OneToMany(mappedBy="time", fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Jogador> listJogador;
	@ManyToMany
	@JoinTable(name = "time_jogo",joinColumns = { @JoinColumn(name = "id_time") }, inverseJoinColumns = { @JoinColumn(name = "id_jogo") })
	private List<Jogo> listJogo;
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public List<Jogador> getListJogador() {
		return listJogador;
	}

	public void setListJogador(List<Jogador> listJogador) {
		this.listJogador = listJogador;
	}

	public List<Jogador> getJogador() {
		return listJogador;
	}

	public void setJogador(List<Jogador> listJogador) {
		this.listJogador = listJogador;
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

	public int getQtdJogos() {
		return qtdJogos;
	}

	public void setQtdJogos(int qtdJogos) {
		this.qtdJogos = qtdJogos;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}



	public int getPontosPro() {
		return pontosPro;
	}

	public void setPontosPro(int pontosPro) {
		this.pontosPro = pontosPro;
	}

	public int getPontosContra() {
		return pontosContra;
	}

	public void setPontosContra(int pontosContra) {
		this.pontosContra = pontosContra;
	}

	public int getSaldopontos() {
		return saldopontos;
	}

	public void setSaldopontos(int saldopontos) {
		this.saldopontos = saldopontos;
	}

	public Campeonato getCamp() {
		return camp;
	}

	public void setCamp(Campeonato camp) {
		this.camp = camp;
	}
}

