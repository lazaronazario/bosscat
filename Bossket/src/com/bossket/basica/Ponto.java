package com.bossket.basica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Ponto {

	@Id
	@Column(name = "id_ponto")
	@GeneratedValue()
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_jogador")
	@Fetch(FetchMode.JOIN)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Jogador jogador;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_jogo")
	@Fetch(FetchMode.JOIN)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Jogo jogo;
	@Column(length = 45, nullable = false, unique = false)
	private String descricao;
	@Column(nullable = false, unique = false)
	private int minuto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String tipoCartao) {
		this.descricao = tipoCartao;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
}
