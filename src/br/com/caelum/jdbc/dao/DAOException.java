package br.com.caelum.jdbc.dao;

@SuppressWarnings("serial")
public class DAOException extends RuntimeException {
	
	public DAOException(){
		super("Causa do erro desconhecida");
	}
	
	public DAOException(String message){
		super(message);
	}
	
	public DAOException(Throwable cause){
		super(cause);
	}
	
	public DAOException(String message, Throwable cause){
		super(message, cause);
	}

}
