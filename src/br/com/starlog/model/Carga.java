package br.com.starlog.model;

public class Carga {
    private String codigoRastreio; //atributos privados
    private String categoria;
    private double pesoKg;
    private double valorSeguro;
    
    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro) { //construtor
        if(codigoRastreio == null || codigoRastreio.trim().isEmpty()){ // lancando a excecao se for nulo direto no construtor 
            throw new IllegalArgumentException("Codigo de rastreio da carga nao pode ser nulo ou vazio.");
        }
        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;
    }

    public String getCodigoRastreio() { // apenas getCodigoRastreio, sem Setter pois tem imutabilidade
        return codigoRastreio;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    @Override
    public String toString() { //toString para quando imprimir o objeto
        return String.format("Carga[rastreio=%s, categoria=%s, peso=%.2f kg, seguro=R$ %.2f]", 
        codigoRastreio, categoria, pesoKg, valorSeguro);
    }

    @Override //equals + hashCode para tratar dois objetos com mesmo codigoRastreio como semanticamente idênticas
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoRastreio == null) ? 0 : codigoRastreio.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carga other = (Carga) obj;
        if (codigoRastreio == null) {
            if (other.codigoRastreio != null)
                return false;
        } else if (!codigoRastreio.equals(other.codigoRastreio))
            return false;
        return true;
    }

    
    
}
