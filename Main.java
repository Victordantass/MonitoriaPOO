
import service.*;
import exceptions.PagamentoRecusadoException;
import model.*;
public class Main {
    public static void main(String[] args) {
        try {
            // 1. Criando um ClienteVip
            Cliente cliente = new ClienteVip("Carlos Silva", "123.456.789-00", "carlos@mail.com", "Rua Principal, 100", 0.10);
            // 2. Criando um item de cada tipo de produto
            Produto fisico = new ProdutoFisico("F01", "Teclado Mecânico", 100.0, 10, 0.8, "60000-000");
            Produto digital = new ProdutoDigital("D01", "E-book Java Avançado", 50.0, 100, 12);
            Assinatura assinatura = new Assinatura("S01", "Plano Streaming Anual", 20.0, 100, 6);
            // 3. Criando o Carrinho de Compras e adicionando os itens
            CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
            carrinho.adicionar(fisico);
            carrinho.adicionar(digital);
            carrinho.adicionar(assinatura);
            // 4. Criando o Pedido
            Pedido pedido = new Pedido(cliente, carrinho);
            // TENTATIVA 1: Compra com PagamentoPix (Deve dar certo)
            System.out.println(" Tentativa 1: Pagamento via PIX ");
            Pagamento pix = new PagamentoPix();
            pedido.finalizar(pix);

            System.out.println("\n----------------------------------------------------\n");
            // TENTATIVA 2: Compra com PagamentoCartao (Com 6 parcelas e limite baixo para forçar recusa)
            System.out.println("Tentativa 2: Pagamento via Cartão (Limite Baixo)");
            Pagamento cartaoRuim = new PagamentoCartao(6, 10.0);
            pedido.finalizar(cartaoRuim);

        } catch (PagamentoRecusadoException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

}