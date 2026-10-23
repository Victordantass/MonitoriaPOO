    package model;
    public class Cliente extends Pessoa {		
        private String endereco;
        private int pontosFidelidade = 0;
        public Cliente(String nome, String cpf, String email, String endereco) {
            super(nome, cpf, email);
            this.endereco = endereco;
        }
        public String getEndereco() {
            return this.endereco;
        }
        public int getPontosFidelidades() {
            return this.pontosFidelidade;
        }
        public void adicionarPontos(int pontos) {
            this.pontosFidelidade = this.pontosFidelidade + pontos;
        }
    }
     
              