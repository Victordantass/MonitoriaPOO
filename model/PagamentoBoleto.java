package model;
import service.*;
public class PagamentoBoleto implements Pagamento { 
     // Se o pagamento for boleto ele usar o calcular final sem o desconto
     @Override
     public double calcularValorFinal(double valor) {
          return valor;
     }
     @Override
     public String getDescricao() {
          return "Boleto";
     }
}