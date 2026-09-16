package br.com.starlog.exception;


public class CapacidadeExcedidaException extends Exception { //criamos a exceção checada herdando de Exception e repassamendo a mensagem
    public CapacidadeExcedidaException (String mensagem){
        super(mensagem);
    }
}
