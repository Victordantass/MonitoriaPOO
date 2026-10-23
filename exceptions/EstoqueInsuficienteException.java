package exceptions;
import model.Produto;
public class EstoqueInsuficienteException extends Exception {
       public EstoqueInsuficienteException (Produto produto, int quantidade) {
             super("Estoque insuficiente para: " + produto + ". Disponível: " + quantidade);
       }
}