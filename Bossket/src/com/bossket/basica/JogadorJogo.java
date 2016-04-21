package com.bossket.basica;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jogador_jogo")
public class JogadorJogo {

	@EmbeddedId
	private JogadorJogoPK chaveComposta;
	@Column(length = 45, nullable = false, unique = false)
	private Double minInicial;
	@Column(length = 45, nullable = false, unique = false)
	private Double minJogados;
	private String cartao;

	public String getCartaoAmarelo() {
		return cartao;
	}

	public void setCartaoAmarelo(String cartaoAmarelo) {
		this.cartao = cartaoAmarelo;
	}

	public JogadorJogoPK getChaveComposta() {
		return chaveComposta;
	}

	public void setChaveComposta(JogadorJogoPK chaveComposta) {
		this.chaveComposta = chaveComposta;
	}

	public Double getMinInicial() {
		return minInicial;
	}

	public void setMinInicial(Double minInicial) {
		this.minInicial = minInicial;
	}

	public Double getMinJogados() {
		return minJogados;
	}

	public void setMinJogados(Double minJogados) {
		this.minJogados = minJogados;
	}
}
