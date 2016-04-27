package com.bossket.erro;

public class ErroSqlException extends Exception{
    
	public ErroSqlException(String x){
        super(x);
    }
    
    public ErroSqlException(Exception e){
        super(e);
    }
}
