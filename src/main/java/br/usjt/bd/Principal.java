package br.usjt.bd;

import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		// 1.1 Exibir os dados de uma pessoa, dado seu código.
		// 1.2 Apagar os dados de uma pessoa, dado seu e-mail.
		String menu = "1 - Cadastrar\n" + "2 - Atualizar\n" + "3 - Apagar\n" + "4 - Listar\n"
				+ "5 - Exibir dados de uma pessoa\n" + "6 - Apagar pessoa por email\n" + "0 - Sair";
		String nome;
		String fone;
		String email;
		int codigo;
		Pessoa p;
		int op;
		PessoaDAO pessoaDao = new PessoaDAO();
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 1:
				nome = JOptionPane.showInputDialog("Nome?");
				fone = JOptionPane.showInputDialog("Fone?");
				email = JOptionPane.showInputDialog("Email?");
				p = new Pessoa(0, nome, fone, email);
				pessoaDao.inserir(p);
				break;
			case 2:
				nome = JOptionPane.showInputDialog("Nome?");
				fone = JOptionPane.showInputDialog("Fone?");
				email = JOptionPane.showInputDialog("Email?");
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
				p = new Pessoa(codigo, nome, fone, email);
				pessoaDao.atualizar(p);
				break;
			case 3:
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
				p = new Pessoa();
				p.setCodigo(codigo);
				pessoaDao.apagar(p);
				break;
			case 4:
				List<Pessoa> pessoas = pessoaDao.listar();
				for (int i = 0; i < pessoas.size(); i++) {
					JOptionPane.showMessageDialog(null, pessoas.get(i));
				}
				break;
			case 5: // Exibir dados de uma pessoa
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
				p = new Pessoa(codigo, null, null, null);
				JOptionPane.showMessageDialog(null, pessoaDao.listarPessoaPorCodigo(p));
				break;
			case 6: // Apagar pessoa por email
				email = JOptionPane.showInputDialog("Email?");
				p = new Pessoa();
				p.setEmail(email);
				pessoaDao.apagarPorEmail(p);
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		} while (op != 0);
	}
}