package adega.controller;

import adega.model.Bebida;
import adega.util.Cores;
import java.util.ArrayList;

public class BebidaController {

    private ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();

    public void listarTodas() {
        if (listaBebidas.isEmpty()) {
            System.out.println(Cores.VERMELHO + "\nNenhuma bebida cadastrada!" + Cores.RESET);
        } else {
            for (Bebida bebida : listaBebidas) {
                bebida.visualizar();
            }
        }
    }

    public Bebida buscarNaCollection(int codigo) {
        for (Bebida bebida : listaBebidas) {
            if (bebida.getCodigo() == codigo) {
                return bebida;
            }
        }
        return null;
    }

    public void procurarPorCodigo(int codigo) {
        Bebida bebida = buscarNaCollection(codigo);
        if (bebida != null) {
            bebida.visualizar();
        } else {
            System.out.println(Cores.VERMELHO +
                "\nBebida com código " + codigo + " não encontrada!" + Cores.RESET);
        }
    }

    public void cadastrar(Bebida bebida) {
        listaBebidas.add(bebida);
        System.out.println(Cores.VERDE +
            "\nBebida cadastrada com sucesso!" + Cores.RESET);
    }

    public void atualizar(Bebida bebida) {
        Bebida bebidaAtualizar = buscarNaCollection(bebida.getCodigo());
        if (bebidaAtualizar != null) {
            listaBebidas.set(listaBebidas.indexOf(bebidaAtualizar), bebida);
            System.out.println(Cores.VERDE +
                "\nBebida atualizada com sucesso!" + Cores.RESET);
        } else {
            System.out.println(Cores.VERMELHO + "\nBebida não encontrada!" + Cores.RESET);
        }
    }

    public void deletar(int codigo) {
        Bebida bebidaDeletar = buscarNaCollection(codigo);
        if (bebidaDeletar != null) {
            listaBebidas.remove(bebidaDeletar);
            System.out.println(Cores.VERDE +
                "\nBebida deletada com sucesso!" + Cores.RESET);
        } else {
            System.out.println(Cores.VERMELHO + "\nBebida não encontrada!" + Cores.RESET);
        }
    }

    public void fazerPedido(int codigo, int quantidade) {
        Bebida bebida = buscarNaCollection(codigo);
        if (bebida != null) {
            if (bebida.getQuantidade() < quantidade) {
                System.out.println(Cores.VERMELHO +
                    "\nEstoque insuficiente! Disponível: " + bebida.getQuantidade() + Cores.RESET);
            } else {
                bebida.setQuantidade(bebida.getQuantidade() - quantidade);
                float total = bebida.getPreco() * quantidade;
                System.out.println(Cores.VERDE + "\nPedido realizado com sucesso!" + Cores.RESET);
                System.out.println("Bebida: "    + bebida.getNome());
                System.out.println("Quantidade: " + quantidade);
                System.out.printf("Total: R$ %,.2f%n", total);
            }
        } else {
            System.out.println(Cores.VERMELHO + "\nBebida não encontrada!" + Cores.RESET);
        }
    }

    public int gerarCodigo() {
        return listaBebidas.size() + 1;
    }
}
