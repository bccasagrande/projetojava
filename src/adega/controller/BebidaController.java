package adega.controller;

import adega.model.Bebida;
import adega.util.Cores;
import java.util.ArrayList;

public class BebidaController {

    private ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();

    public void listarTodas() {
        if (listaBebidas.isEmpty()) {
            throw new RuntimeException("Nenhuma bebida cadastrada!");
        }
        for (Bebida bebida : listaBebidas) {
            bebida.visualizar();
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
            throw new RuntimeException("Bebida com código " + codigo + " não encontrada!");
        }
    }

    public void cadastrar(Bebida bebida) {
        if (bebida.getPreco() < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo!");
        }
        if (bebida.getQuantidade() < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa!");
        }
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
            throw new RuntimeException("Bebida não encontrada!");
        }
    }

    public void deletar(int codigo) {
        Bebida bebidaDeletar = buscarNaCollection(codigo);
        if (bebidaDeletar != null) {
            listaBebidas.remove(bebidaDeletar);
            System.out.println(Cores.VERDE +
                "\nBebida deletada com sucesso!" + Cores.RESET);
        } else {
            throw new RuntimeException("Bebida não encontrada!");
        }
    }

    public void fazerPedido(int codigo, int quantidade) {
        Bebida bebida = buscarNaCollection(codigo);
        if (bebida == null) {
            throw new RuntimeException("Bebida não encontrada!");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero!");
        }
        if (bebida.getQuantidade() < quantidade) {
            throw new RuntimeException("Estoque insuficiente! Disponível: " + bebida.getQuantidade());
        }
        bebida.setQuantidade(bebida.getQuantidade() - quantidade);
        float total = bebida.getPreco() * quantidade;
        System.out.println(Cores.VERDE + "\nPedido realizado com sucesso!" + Cores.RESET);
        System.out.println("Bebida: "     + bebida.getNome());
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Total: R$ %,.2f%n", total);
    }

    public int gerarCodigo() {
        return listaBebidas.size() + 1;
    }
}
