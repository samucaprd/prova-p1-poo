package br.com.starlog.main;

import java.util.HashSet;
import java.util.Set;

import br.com.starlog.exception.CapacidadeExcedidaException;
import br.com.starlog.model.BaseLancamento;
import br.com.starlog.model.Carga;
import br.com.starlog.model.ModuloCarga;

public class Main {
    public static void main(String[] args) throws Exception {
        Carga c1 = new Carga("ORB-101-SP", "CRIOGENICA", 2.5, 450.00);
        Carga c2 = new Carga("ORB-102-RJ", "PADRAO", 8.0, 120.00);
        Carga c3 = new Carga("ORB-103-MG", "CRIOGENICA", 12.0, 850.00);
        Carga c4 = new Carga("ORB-104-PR", "BIOLOGICA", 15.0, 300.00);

        System.out.println(c1);
        System.out.println(c4);

        ModuloCarga modulo = new ModuloCarga("MOD-ALFA-01", 3);

        BaseLancamento base = new BaseLancamento();

        base.cadastrarModulo(modulo);
        System.out.println("Modulo '" + modulo.getCodigoModulo() + "' cadastrado na base com capacidade de 3 cargas");

        modulo.carregarCarga(c1);
        System.out.println("Carga " + c1.getCodigoRastreio() + " carregada no modulo com sucesso.");
        modulo.carregarCarga(c2);
        System.out.println("Carga " + c2.getCodigoRastreio() + " carregada no modulo com sucesso.");
        modulo.carregarCarga(c3);
        System.out.println("Carga " + c3.getCodigoRastreio() + " carregada no modulo com sucesso.");
        
        try{
            modulo.carregarCarga(c4);
        } catch(CapacidadeExcedidaException e){
            System.out.println("Excecao capturada: " + e.getMessage());
        }

        ModuloCarga encontrada = base.buscarModulo("MOD-ALFA-01");
        System.out.println("Modulo localizado na base: " + encontrada.getCodigoModulo());

        System.out.println("Seguro total do modulo: R$" + modulo.calcularSeguroTotal());

        System.out.println("Cargas CRIOGENICA: " + modulo.contarCargasPorCategoria("CRIOGENICA"));

        System.out.println("Seguro de cargas criticas (CRIOGENICA > 5kg): R$" + 
        modulo.calcularSeguroCargasPesadas("CRIOGENICA", 5.0));

        HashSet<Carga> manifesto = new HashSet<>();  
        
        manifesto.add(c1);
        manifesto.add(new Carga("ORB-101-SP", "CRIOGENICA", 9.0, 990.00));
        manifesto.add(c2);

        System.out.println("Tamanho do manifesto (HashSet): " + manifesto.size());

        try{
            new Carga("", "PADRAO", 1.0, 50.00);
        } catch(IllegalArgumentException e){
            System.out.println("Construtor validado: " + e.getMessage());
        }
    }
}
