package service;
public interface Pagamento {
    public double calcularValorFinal(double valor);
    public String getDescricao();
    public default String exibirComprovante( double valor) {
         return "Pago via " + getDescricao() + ": R$" + calcularValorFinal(valor);
    }
}