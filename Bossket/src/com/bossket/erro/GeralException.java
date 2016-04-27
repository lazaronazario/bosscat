package com.bossket.erro;

public class GeralException extends Exception{
    
	public GeralException(){
        super();
    }
    
    public GeralException(Exception e){
        super(e);
    }
    
    public GeralException(String x){
        super(x);
    }
}