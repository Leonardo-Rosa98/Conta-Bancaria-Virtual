import java.util.Scanner;

public class ContaCorrente {
    private String nomeDoCliente;
    private int numeroDeConta;
    private double saldo;
    private String tipoDeConta;
    
    public ContaCorrente(String nomeDoCliente, int numeroDeConta, double saldo, String tipoDeConta) {
        this.nomeDoCliente = nomeDoCliente;
        this.numeroDeConta = numeroDeConta;
        this.saldo = saldo;
        this.tipoDeConta = tipoDeConta;    
    }

    public void telaInicial() {
        System.out.println("*************************************");
        System.out.println("Dados iniciais do cliente: ");
        System.out.println(" ");
        System.out.println("Nome:              " + nomeDoCliente);
        System.out.println("Tipo de conta:     " + tipoDeConta);
        System.out.println("Saldo inicial:     " + saldo);
        System.out.println("");
        System.out.println("*************************************");  
    }
        
    public void getSaldo() {
        System.out.println("Seu saldo atual: " + saldo);
    }

    public void receberValores() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o valor que deseja receber: ");
        double valor = input.nextDouble();
        saldo = saldo + valor;
        System.out.println("Valor recebido com sucesso!");   
    }

    public void transferirValor() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o valor que deseja transferir: ");
        double valor = input.nextDouble();
        if(valor <= saldo) {
            saldo = saldo -  valor;
            System.out.println("Valor transferido com sucesso!");
        }else {
            System.out.println("Saldo insuficiente!");
        } 
    }

    public void operacoes() {
       String continuar = "s"; 
       
       while (continuar.equals("s") || continuar.equals("S")) {
            Scanner input = new Scanner(System.in);
            System.out.println("");
            System.out.println("Digite o número da operação que deseja realizar: ");
            System.out.println(" ");
            System.out.println("""
                (1) - Consultas Saldos
                (2) - Receber Valores
                (3) - Transferir Valor
                (4) - Sair
                """);
            System.out.println(" ");  
            System.out.print("Sua resposta: "); 
            int resposta = input.nextInt();
            
            switch (resposta) {
                case 1:
                    getSaldo();
                    break;
                case 2:
                    receberValores();
                    break;  
                case 3:
                    transferirValor(); 
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar nossos serviços, volte sempre!");     
                    break; 
                default:
                    System.out.println("Opção inválida!"); 
                    break;
            }

            if (resposta == 4){
                break;
            }else{
                System.out.print("Deseja continuar? s/n:  ");
                input.nextLine();
                continuar = input.nextLine();
                 if(continuar.equals("n") || continuar.equals("N") || resposta == 4) { 
                    System.out.println("Obrigado por utilizar nossos serviços, volte sempre!");     
                }        
            }        
        }
    }

}