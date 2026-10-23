package model;
import exceptions.PagamentoRecusadoException;
import service.*;
public class PagamentoCartao implements Pagamento {
     private int parcelas;
     private double limite;
     public PagamentoCartao(int parcelas, double limite) {
          this.parcelas = parcelas;
          this.limite = limite;
     }
     public int getParcelas() {
          return this.parcelas;
     }
     // Se o pagamento for cartão ele usar o calcular final baseado na quantidade de parcelas
     @Override
     public double calcularValorFinal(double valor) throws PagamentoRecusadoException {
          if (valor > limite) {
               throw new PagamentoRecusadoException("Limite insuficiente");
          }
          if (getParcelas() > 3) {
               return  valor * 1.08;
          } else {
               return valor;
          }
     }
     @Override 
     public String getDescricao() {
          return "Cartão de Crédito";
     }
}

     