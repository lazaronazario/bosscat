package com.bossket.basica;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class JogadorJogoPK implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_jogo")
	private Jogo jogo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_jogador")
	private Jogador jogador;

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

}
