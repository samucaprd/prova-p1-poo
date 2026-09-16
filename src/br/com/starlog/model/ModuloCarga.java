package br.com.starlog.model;

import java.util.ArrayList;
import java.util.List;

import br.com.starlog.exception.CapacidadeExcedidaException;

public class ModuloCarga {
    private String codigoModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas = new ArrayList<>();
    
    public ModuloCarga(String codigoModulo, int capacidadeMaxima) {
        this.codigoModulo = codigoModulo;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getCodigoModulo() {
        return codigoModulo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public void carregarCarga(Carga carga) throws CapacidadeExcedidaException { //avisando que o metodo pode lançar uma excecao
        if(this.cargas.size() >= this.capacidadeMaxima){
            throw  new CapacidadeExcedidaException("Modulo '" + codigoModulo + "' atingiu a capacidade maxima de '" 
            + capacidadeMaxima + "' cargas.");
        }
        else{
            this.cargas.add(carga); // se estiver dentro da condicao adiciona a carga
        }
    }

    public double calcularSeguroTotal(){ //stream para calcular o seguro total com mapToDouble e sum
        return this.cargas.stream()
        .mapToDouble(c -> c.getValorSeguro())
        .sum();
    }

    public long contarCargasPorCategoria(String categoria){ //stream para contar cargas por categoria com filter count
        return this.cargas.stream()
        .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
        .count();
    }

    public double calcularSeguroCargasPesadas(String categoria, double pesoMinimo){ //stram para calcular seguro de cargas pesadas com 2 filter, mapToDouble e sum
        return this.cargas.stream()
        .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
        .filter(c -> c.getPesoKg() > pesoMinimo)
        .mapToDouble(c -> c.getValorSeguro())
        .sum();
    }
    
}
