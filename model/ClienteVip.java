package model;
public class ClienteVip extends Cliente {
     private double percentualDesconto;
     public ClienteVip(String nome, String cpf ,String email, String endereco, double percentualDesconto) {
        super(nome, cpf, email, endereco);
        this.percentualDesconto = percentualDesconto / 100;
     }
     public double getPercentualDesconto() {
          return percentualDesconto;
     }
     @Override
     public String toString() {
        return super.toString() + " | VIP (" + (int)(percentualDesconto * 100) + "%)";
     }
}