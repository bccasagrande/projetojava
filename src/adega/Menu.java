package adega;

import java.util.Scanner;
import adega.util.Cores;

public class Menu {

    public static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        System.out.println(Cores.AZUL_NEGRITO +
            "*****************************************************" + Cores.RESET);
        System.out.println(Cores.AZUL_NEGRITO +
            "              ADEGA ZÉ DELIVERY 🍺                  " + Cores.RESET);
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
                "\nEntre com a opção desejada: " + Cores.RESET);

            opcao = leia.nextInt();

            if (opcao == 0) {
                System.out.println(Cores.VERDE_NEGRITO +
                    "\nAdega Zé Delivery - Até logo!\n" + Cores.RESET);
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1: System.out.println("Cadastrar Bebida - em breve!"); break;
                case 2: System.out.println("Listar Bebidas - em breve!"); break;
                case 3: System.out.println("Buscar Bebida - em breve!"); break;
                case 4: System.out.println("Atualizar Bebida - em breve!"); break;
                case 5: System.out.println("Deletar Bebida - em breve!"); break;
                case 6: System.out.println("Fazer Pedido - em breve!"); break;
                default:
                    System.out.println(Cores.VERMELHO + "\nOpção Inválida!" + Cores.RESET);
                    break;
            }

        } while (opcao != 0);
    }
}
