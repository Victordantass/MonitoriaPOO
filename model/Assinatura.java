package model;
public class Assinatura extends Produto {
     private int meses;
     public Assinatura(String codigo, String nome, double precoBase, int estoque, int meses) {
         super(codigo, nome, precoBase, estoque);
         this.meses = meses;
    }
    @Override
    // calcula o preço final baseado na quantidade de meses
    public double calcularPrecoFinal() {
         if (meses >= 6) {
             return (getPrecoBase() * meses) * 0.90;
         } else {
             return getPrecoBase() * meses;
         }
    }
}
         