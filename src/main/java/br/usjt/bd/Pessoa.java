package br.usjt.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
	private int codigo;
	private String nome;
	private String fone;
	private String email;

	public void inserir() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			ps.setString(2, fone);
			ps.setString(3, email);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar() {
		// 1: Definir o comando SQL
		String sql = "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE codigo = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			ps.setString(2, fone);
			ps.setString(3, email);
			ps.setInt(4, codigo);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apagar() {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM tb_pessoa WHERE codigo = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setInt(1, codigo);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
