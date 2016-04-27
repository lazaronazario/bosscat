package com.bossket.erro;

public class ErroConexaoException extends Exception{
    
	public ErroConexaoException(String x){
        super(x);
    }
    
    public ErroConexaoException(Exception e){
        super(e);
    }
}

