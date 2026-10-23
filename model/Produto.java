package model;
public abstract class Produto {
    private String codigo;
    private String nome;
    private double precoBase;
    private int estoque;
    public Produto (String codigo, String nome, double precoBase, int estoque) throws IllegalArgumentException {
        this.codigo = codigo;
        this.nome = nome;
        if (precoBase < 0) {
            throw new IllegalArgumentException("Valor Inválido");
        } else {
            this.precoBase = precoBase;
        }
        this.estoque = estoque;
    }
    public double getPrecoBase() {
        return this.precoBase;
    }
    public int getEstoque() {
        return estoque;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    // Método abstrato que vai calcular o preço final
    public abstract double calcularPrecoFinal();
    public String exibirResumo() {
        return getCodigo() + getNome() + " R$:" + calcularPrecoFinal();
    }
    //Método para baixar o estoque de um produto
    public void baixarEstoque(int quantidade) {
        estoque = estoque - quantidade;
    }
}