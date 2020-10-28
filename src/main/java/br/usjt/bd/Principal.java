package br.usjt.bd;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";
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
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		} while (op != 0);
	}
}