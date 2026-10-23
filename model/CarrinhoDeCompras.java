package model;
import java.util.List;
import java.util.ArrayList;
import exceptions.*;
import service.Entregavel;
public class CarrinhoDeCompras {
     private List<Produto> itens = new ArrayList<>();
     public List<Produto> getItens() {
          return itens;
     }
     public void adicionar(Produto p) {
          itens.add(p);
     }
     //sobrecarrega adicionar mas com um parâmetro para saber quantos produto desse devem ser adicionados no estoque
     public void adicionar( Produto p, int quantidade) throws EstoqueInsuficienteException{
          if(quantidade > p.getEstoque()) {
               throw new EstoqueInsuficienteException (p, quantidade);
          } else {
               for (int i = 0; i < quantidade; i++) {
                   this.itens.add(p);
               }
          }
     }
     //Percorre a lista usando o calcular total de todos e armazenando em uma variável para saber o valor total
     public double calcularTotal() {
          double total = 0.0;
          for (Produto p : itens) {
              total += p.calcularPrecoFinal();
          }
          return total;
     }
     // mesma ideia do calculaTotal, porém ele calcula apenas dos que são entregáveis
     public double calcularFreteTotal(String cep) {
          double total = 0.0;
          for( Produto p : itens) {
               if (p instanceof Entregavel e) {
                    total += e.calcularFrete(cep);
               }
          }
          return total;
     }
}
     