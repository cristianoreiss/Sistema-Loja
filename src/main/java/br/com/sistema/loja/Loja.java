package br.com.sistema.loja;
import java.util.ArrayList;

public class Loja {
    private String nomeLoja;
    private ArrayList<Produto> listaProdutos;

    public Loja(String nomeLoja){
        setNomeLoja(nomeLoja);
        this.listaProdutos = new ArrayList<>();
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public void cadastrarProduto(Produto produto){
        listaProdutos.add(produto);
    }

    public ArrayList<Produto> listarProdutos() {
        return listaProdutos;
    }

    public Produto buscarProduto(String nome) {
        for (Produto p : listaProdutos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public double venderProduto(String nome, int qtd) {
        Produto p = buscarProduto(nome);
        if (p != null && p.getQuantidade() >= qtd) {
            double total = p.getPreco() * qtd;
            p.diminuirEstoque(qtd);
            return total;
        }
        return 0.0;
    }
}
