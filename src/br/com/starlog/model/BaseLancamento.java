package br.com.starlog.model;

import java.util.Map;
import java.util.HashMap;

public class BaseLancamento {
    private Map<String, ModuloCarga> modulos = new HashMap<>();

    public BaseLancamento(){ // construtor

    }

    public void cadastrarModulo(ModuloCarga modulo){ //metodo cadastrarModulo passando o CodigoModulo como chave e modulo de valor
        this.modulos.put(modulo.getCodigoModulo(), modulo);
    }

    public ModuloCarga buscarModulo(String codigoModulo){ // metodo buscarModulo retornando a instancia correspondente
        return this.modulos.get(codigoModulo);
    }

    public Map<String, ModuloCarga> getModulos() { 
        return modulos;
    }

    
}
