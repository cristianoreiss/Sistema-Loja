package br.com.sistema.loja;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Principal extends JFrame {
    private JTextField txtNome, txtPreco, txtQuantidade;
    private JButton btnCadastrar, btnVender, btnListar;
    private Loja minhaLoja = new Loja("Minha Loja UNIRIO");

    public Principal() {
        setTitle("Sistema da Loja");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10)); // Organiza em grade

        // Inicialização dos Componentes
        add(new JLabel(" Nome do Produto:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel(" Preço:"));
        txtPreco = new JTextField();
        add(txtPreco);

        add(new JLabel(" Quantidade:"));
        txtQuantidade = new JTextField();
        add(txtQuantidade);

        btnCadastrar = new JButton("Cadastrar");
        btnListar = new JButton("Listar Estoque");
        btnVender = new JButton("Vender");

        add(btnCadastrar);
        add(btnListar);
        add(new JLabel(""));
        add(btnVender);

        configurarBotoes();
    }

    private void configurarBotoes() {
        btnCadastrar.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                double preco = Double.parseDouble(txtPreco.getText());
                int qtd = Integer.parseInt(txtQuantidade.getText());
                minhaLoja.cadastrarProduto(new Produto(nome, preco, qtd));
                JOptionPane.showMessageDialog(this, "Produto cadastrado!");
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro nos dados informados.");
            }
        });

        btnListar.addActionListener(e -> {
            ArrayList<Produto> lista = minhaLoja.listarProdutos();
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Estoque vazio.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (Produto p : lista) {
                    sb.append(p.getNome()).append(" - R$ ").append(p.getPreco()).append(" (").append(p.getQuantidade()).append(")\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString());
            }
        });

        btnVender.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                int qtd = Integer.parseInt(txtQuantidade.getText());
                double total = minhaLoja.venderProduto(nome, qtd);
                if (total > 0) {
                    JOptionPane.showMessageDialog(this, "Venda realizada! Total: R$ " + total);
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado ou estoque insuficiente.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Informe o nome e a quantidade.");
            }
        });
    }

    private void limparCampos() {
        txtNome.setText(""); txtPreco.setText(""); txtQuantidade.setText("");
    }

    public static void main(String[] args) {
        new Principal().setVisible(true);
    }
}