package adega;

import java.util.Scanner;
import adega.controller.BebidaController;
import adega.model.Cerveja;
import adega.model.Destilado;
import adega.util.Cores;

public class Menu {

    public static Scanner leia = new Scanner(System.in);
    static BebidaController bebidaController = new BebidaController();

    public static void main(String[] args) {

        int opcao;

        System.out.println(Cores.AZUL_NEGRITO +
            "*****************************************************" + Cores.RESET);
        System.out.println(Cores.AZUL_NEGRITO +
            "              ADEGA ZE DELIVERY                     " + Cores.RESET);
        System.out.println(Cores.AZUL_NEGRITO +
            "*****************************************************" + Cores.RESET);

        do {
            System.out.println(Cores.VERDE_NEGRITO + "\n\nMenu Principal:" + Cores.RESET);
            System.out.println("1 - Cadastrar Bebida");
            System.out.println("2 - Listar todas as Bebidas");
            System.out.println("3 - Buscar Bebida por Codigo");
            System.out.println("4 - Atualizar Bebida");
            System.out.println("5 - Deletar Bebida");
            System.out.println("6 - Fazer Pedido");
            System.out.println(Cores.VERMELHO + "0 - Sair" + Cores.RESET);
            System.out.println(Cores.AMARELO_NEGRITO +
                "\nEntre com a opcao desejada: " + Cores.RESET);

            opcao = leia.nextInt();

            if (opcao == 0) {
                System.out.println(Cores.VERDE_NEGRITO +
                    "\nAdega Ze Delivery - Ate logo!\n" + Cores.RESET);
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: bebidaController.listarTodas(); break;
                case 3: buscarPorCodigo(); break;
                case 4: atualizar(); break;
                case 5: deletar(); break;
                case 6: fazerPedido(); break;
                default:
                    System.out.println(Cores.VERMELHO + "\nOpcao Invalida!" + Cores.RESET);
                    break;
            }

        } while (opcao != 0);
    }

    public static void cadastrar() {
        System.out.println("\nCategoria (1-Cerveja / 2-Destilado): ");
        int categoria = leia.nextInt();

        System.out.println("Nome: ");
        String nome = leia.next();

        System.out.println("Marca: ");
        String marca = leia.next();

        System.out.println("Preco (R$): ");
        float preco = leia.nextFloat();

        System.out.println("Quantidade em estoque: ");
        int quantidade = leia.nextInt();

        if (categoria == 1) {
            System.out.println("Tipo (Ex: Lager, IPA, Pilsen): ");
            String tipo = leia.next();
            bebidaController.cadastrar(
                new Cerveja(bebidaController.gerarCodigo(), nome, marca, preco, quantidade, tipo)
            );
        } else {
            System.out.println("Teor Alcoolico (%): ");
            float teor = leia.nextFloat();
            bebidaController.cadastrar(
                new Destilado(bebidaController.gerarCodigo(), nome, marca, preco, quantidade, teor)
            );
        }
    }

    public static void buscarPorCodigo() {
        System.out.println("\nCodigo da Bebida: ");
        int codigo = leia.nextInt();
        bebidaController.procurarPorCodigo(codigo);
    }

    public static void atualizar() {
        System.out.println("\nCodigo da Bebida a atualizar: ");
        int codigo = leia.nextInt();

        System.out.println("Categoria (1-Cerveja / 2-Destilado): ");
        int categoria = leia.nextInt();

        System.out.println("Nome: ");
        String nome = leia.next();

        System.out.println("Marca: ");
        String marca = leia.next();

        System.out.println("Preco (R$): ");
        float preco = leia.nextFloat();

        System.out.println("Quantidade em estoque: ");
        int quantidade = leia.nextInt();

        if (categoria == 1) {
            System.out.println("Tipo (Ex: Lager, IPA, Pilsen): ");
            String tipo = leia.next();
            bebidaController.atualizar(
                new Cerveja(codigo, nome, marca, preco, quantidade, tipo)
            );
        } else {
            System.out.println("Teor Alcoolico (%): ");
            float teor = leia.nextFloat();
            bebidaController.atualizar(
                new Destilado(codigo, nome, marca, preco, quantidade, teor)
            );
        }
    }

    public static void deletar() {
        System.out.println("\nCodigo da Bebida a deletar: ");
        int codigo = leia.nextInt();
        bebidaController.deletar(codigo);
    }

    public static void fazerPedido() {
        System.out.println("\nCodigo da Bebida: ");
        int codigo = leia.nextInt();
        System.out.println("Quantidade desejada: ");
        int quantidade = leia.nextInt();
        bebidaController.fazerPedido(codigo, quantidade);
    }
}
