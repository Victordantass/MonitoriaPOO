package model;
import service.*;
public class PagamentoPix implements Pagamento {
     // Se o pagamento for pix ele usar o calcular final para adicionar o desconto
     @Override
     public double calcularValorFinal(double valor) {
          return valor * 0.95;
     }
     @Override
     public String getDescricao() {
          return "Pix";
     }
}