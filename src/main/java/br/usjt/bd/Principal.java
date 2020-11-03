package br.usjt.bd;

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
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 1:
				nome = JOptionPane.showInputDialog("Nome?");
				fone = JOptionPane.showInputDialog("Fone?");
				email = JOptionPane.showInputDialog("Email?");
				p = new Pessoa();
				p.setNome(nome);
				p.setFone(fone);
				p.setEmail(email);
				p.inserir();
				break;
			case 2:
				nome = JOptionPane.showInputDialog("Nome?");
				fone = JOptionPane.showInputDialog("Fone?");
				email = JOptionPane.showInputDialog("Email?");
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
				p = new Pessoa();
				p.setNome(nome);
				p.setFone(fone);
				p.setEmail(email);
				p.setCodigo(codigo);
				p.atualizar();
				break;
			case 3:
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
				p = new Pessoa();
				p.setCodigo(codigo);
				p.apagar();
				break;
			case 4:
				p = new Pessoa();
				p.listar();
				break;
			case 5: // Exibir dados de uma pessoa
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
				p = new Pessoa();
				p.setCodigo(codigo);
				p.listarPessoaPorCodigo();
				break;
			case 6: // Apagar pessoa por email
				email = JOptionPane.showInputDialog("Email?");
				p = new Pessoa();
				p.setEmail(email);
				p.apagarPorEmail();
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		} while (op != 0);
	}
}