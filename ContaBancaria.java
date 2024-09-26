// criei a classe para poder dar atributos a ela
public class ContaBancaria {
	// atributos da classe
    private double saldo; 
    private int consulta; // variavel que ve quantas vezes foi checado

    // Construtor
    public ContaBancaria(double primeirosaldo) {
        if (primeirosaldo >= 0) {
            this.saldo = primeirosaldo; // Define o saldo inicial
        } else {
            this.saldo = 0; // Se o saldo inicial for negativo, coloca como 0
            System.out.println("Saldo inicial não pode ser negativo. Saldo reajustado automaticamente para 0");
        }
        this.consulta = 0; // Começa sem consultas
    }

    // Método para fazer um depósito
    public void dep(double quantia) {
        if (quantia > 0) { // Tem que ser um valor positivo, certo?
            double taxa = quantia * 0.01; // Taxa de 1%
            saldo += (quantia - taxa); // Adiciona o valor menos a taxa ao saldo
            System.out.println("Depósito realizado de R$" + quantia + " Taxa cobrada automaticamente de R$" + taxa);
        } else {
            System.out.println("A quantia depositada deve ser positiva."); // Mensagem de erro para valor inválido
        }
    }

    // Método para fazer um saque
    public void saque(double quantia) {
        if (quantia > 0) { // Verifica se o valor do saque é positivo
            double taxa = quantia * 0.005; // Taxa de 0,5%
            if (saldo >= (quantia + taxa)) { // Confere se o saldo é suficiente
                saldo -= (quantia + taxa); // Deduz o valor do saque e a taxa do saldo
                System.out.println("Pedido de saque de R$" + quantia + " aprovada. Taxa cobrada automaticamente de R$" + taxa);
            } else {
                System.out.println("Saldo insuficiente."); // Mensagem de erro se não tiver saldo
            }
        } else {
            System.out.println("A quantia do saque deve ser superior a 0"); // Mensagem de erro para valor inválido
        }
    }

    // Método para consultar o saldo
    public double VerificaSaldo() {
        consulta++; // Aumenta o contador de consultas
        if (consulta % 5 == 0) { // A cada 5 consultas, cobra uma taxa
            saldo -= 0.10; // Deduz 10 centavos do saldo
            System.out.println("Cobrança automatica de R%0,10 pela verificação do saldo.");
        }
        return saldo; // Retorna o saldo atual
    }

    // Método para obter o saldo atual
    public double getSaldo() {
        return saldo; // Retorna o saldo atual
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(5000); // novo objeto para simular uma conta bancaria com o saldo inicial de 5000 reais
        conta.dep(700); // realiza um deposito de 700 reais
        conta.saque(400); // realiza um saque de 400 reais
        System.out.println("Saldo atual da conta: R$" + conta.VerificaSaldo()); // mostra a quantia do saldo
        conta.VerificaSaldo(); // faz a verificação do saldo novamente
        conta.VerificaSaldo(); // novamente
        conta.VerificaSaldo(); //  mais uma vez
        conta.VerificaSaldo(); // depois de 5 consultas faz a cobrança de taxa
        // mostra ao usuario o resultado final
        System.out.println("Saldo final da conta: R$" + conta.getSaldo());
    }
}
