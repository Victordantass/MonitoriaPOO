package model;
public class ProdutoDigital extends Produto {
     private int tamanhoMB;
     public ProdutoDigital (String codigo, String nome, double precoBase, int estoque, int  tamanhoMB) {
         super(codigo, nome, precoBase, estoque);
         this.tamanhoMB = tamanhoMB;
     }
     @Override
     public double calcularPrecoFinal() {
         return getPrecoBase() * 0.95;
    }
     public int getTamanhoMB() {
         return tamanhoMB;
     }
     @Override 
     public String exibirResumo() {
        return getCodigo() + getNome() + " R$:" + calcularPrecoFinal() + " Tamanho: " + getTamanhoMB();
    }
}