package com.bossket.basica;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "time_jogo")
public class TimeJogo {
	@EmbeddedId
	private TimeJogoPK chaveComposta;
    
    private int pontosFeitos;
    private boolean casa;

    public int getPontosFeitos() {
        return pontosFeitos;
    }

    public void setPontosFeitos(int pontosFeitos) {
        this.pontosFeitos = pontosFeitos;
    }

    public TimeJogoPK getChaveComposta() {
		return chaveComposta;
	}

	public void setChaveComposta(TimeJogoPK chaveComposta) {
		this.chaveComposta = chaveComposta;
	}

	public boolean isCasa() {
        return casa;
    }

    public void setCasa(boolean casa) {
        this.casa = casa;
    }

}

