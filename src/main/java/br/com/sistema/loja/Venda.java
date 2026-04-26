package br.com.sistema.loja;

public class Venda {
    private int quantidadeVendida;
    private double valorTotal;
    private Produto produto;

    public Venda(Produto produto, int quantidadeVendida) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = calcularTotal();
    }

    public double calcularTotal() {
        return this.quantidadeVendida * this.produto.getPreco();
    }

    public void exibirVenda() {
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Quantidade Vendida: " + quantidadeVendida);
        System.out.println("Valor Total: R$ " + valorTotal);
        System.out.println("Estoque Restante: " + produto.getQuantidade());
    }

    public double getValorTotal() {
        return valorTotal;
    }
}