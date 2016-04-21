package com.bossket.basica;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class TimeJogoPK implements Serializable {
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_jogo")
	private Jogo jogo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_time")
	private Time time;

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
