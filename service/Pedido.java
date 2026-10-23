package service;
import model.*;
import exceptions.*;
public class Pedido {
     // criei um cliente novo e um array list do carrinho
     private Cliente cliente;
     private CarrinhoDeCompras carrinho;
     public Pedido (Cliente cliente, CarrinhoDeCompras carrinho) {
            this.cliente = cliente;
            this.carrinho = carrinho;
     }
      // Calcula o pagamento percorrendo todo o carrinho calculando o valor total e calculando o frete
      public void finalizar ( Pagamento pagamento) {
            try {
                  double subtotal = carrinho.calcularTotal() + carrinho.calcularFreteTotal(cliente.getEndereco());
                  // O instanceof verifica se ele é cliente vip, se for, ele recebe desconto
                  if( cliente instanceof ClienteVip) {
                        double desconto = subtotal * ((ClienteVip) cliente).getPercentualDesconto();
                        subtotal = subtotal - desconto;
                        subtotal = pagamento.calcularValorFinal(subtotal);
                        System.out.println(pagamento.exibirComprovante(subtotal));
                  } else {
                        // calcula o valor final baseado na forma de pagamento
                        subtotal = pagamento.calcularValorFinal(subtotal);
                         System.out.println(pagamento.exibirComprovante(subtotal));
                         // Adiciona os pontos fidelidades
                  }
                  int pontos = (int) (subtotal / 10);
                  // Adiciona os pontos fidelidades
                  cliente.adicionarPontos(pontos);
                   // Testa as exceptions
            } catch (PagamentoRecusadoException e) {
                 System.out.println(e.getMessage());
           
            } finally {
               System.out.println("Pedido encerrado");
            }
      }
}
                   