package model;
import service.*;
public class ProdutoFisico extends Produto implements Entregavel {
     private double pesoKg;
    private String cep;
     public ProdutoFisico (String codigo, String nome, double precoBase, int estoque, double pesoKg, String cep) {
         super(codigo, nome, precoBase, estoque);
         this.pesoKg = pesoKg;
         this.cep = cep;
    }
    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase() * 1.10;
    }
    @Override
    public double calcularFrete(String cep) {
        return 15 + (2 * pesoKg);
    }
    @Override
    //Usa o starswith() para calcular o frete baseado no início do número do cep
    public int prazoEntregaDias () {
        if(cep != null && cep.startsWith("6")) {
             return 7;
        } else {
             return 12;
        }
    }
}
