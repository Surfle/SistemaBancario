package views.menus;

import model.ContaBancaria;
import model.enuns.TipoConta;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuView {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("|========================|");
            System.out.println("||                      ||");
            System.out.println("||      Bem-Vindo!      ||");
            System.out.println("||                      ||");
            System.out.println("|========================|");
            System.out.println("Escolha uma das OPÇÕES:");
            System.out.println("  1 - Cadastro");
            System.out.println("  2 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Cadastro(); break;
                case 2:
                    System.out.println("Saindo... Volte Sempre!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção INVÁLIDA! Tente novamente.");
                    break;
            }

        }
    }
    public void Login(ContaBancaria conta){
        Scanner scanner = new Scanner(System.in);
        System.out.println("|========================|");
        System.out.println("||                      ||");
        System.out.println("||         Login        ||");
        System.out.println("||                      ||");
        System.out.println("|========================|");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.next();
        if(nome.equals(conta.getNome())  && senha.equals(conta.getSenha())){

            System.out.println("Login realizado com sucesso!");
            Conta(conta);
        }
        Cadastro();
    }
    public void Cadastro(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("|========================|");
        System.out.println("||                      ||");
        System.out.println("||   Cadastrar Conta    ||");
        System.out.println("||                      ||");
        System.out.println("|========================|");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.next();

        System.out.print("Tipo da conta (1 para CORRENTE, 2 para POUPANCA): ");
        int tipoContaInt = scanner.nextInt();
        TipoConta tipoConta = TipoConta.CORRENTE;

        if (tipoContaInt == 2) {
            tipoConta = TipoConta.POUPANCA;
        }
        int saldo = 100;

        ContaBancaria conta = new ContaBancaria(nome, saldo, tipoConta, senha);
        System.out.println("Conta cadastrada com sucesso!");
        Login(conta);
    }

    public void Conta(ContaBancaria conta){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("|========================|");
            System.out.println("||                      ||");
            System.out.println("||      Bem-Vindo!      ||");
            System.out.println("||                      ||");
            System.out.println("|========================|");
            System.out.println("Escolha uma das OPÇÕES:");
            System.out.println("  1 - Saldo");
            System.out.println("  2 - Depositar");
            System.out.println("  3 - Investir");
            System.out.println("  4 - Resgatar");
            System.out.println("  5 - Saldo investido");
            System.out.println("  6 - Ciclar");

            System.out.println("  0 - Sair");

            int opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Saldo = "+conta.getSaldo());
                    break;
                case 2:
                    System.out.println("Insira o valor a ser depositado: ");
                    conta.setSaldo(conta.getSaldo()+scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Insira o valor a ser investido: ");
                    int valor = scanner.nextInt();
                    float saldo = conta.getSaldo();
                    float investido = conta.getInvestimento();
                    if(valor >=0  && valor <= saldo){
                        conta.setInvestimento(investido+valor);
                        conta.setSaldo(saldo-valor);
                    }
                    break;
                case 4:
                    System.out.println("Insira o valor a ser resgatado: ");
                    float valorR = scanner.nextFloat();
                    float saldoR = conta.getSaldo();
                    float investidoR = conta.getInvestimento();
                    if(valorR >=0  && valorR <= saldoR){
                        conta.setSaldo(saldoR+valorR);
                        conta.setInvestimento(investidoR-(valorR));
                    }
                    break;
                case 5:
                    System.out.println(conta.getInvestimento());
                    break;
                case 6:
                    float aux = conta.getInvestimento();
                    conta.setInvestimento(aux+aux*(float) 0.05);
                    break;
                case 0:
                    menu();
                    break;


            }
        }
    }
}
//williian.bogler@descomplica.com.br