package br.usjt.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

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

	public void listar() {
		// 1: Definir o comando SQL
		String sql = "SELECT * FROM tb_pessoa";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				String email = rs.getString("email");
				String aux = String.format("Código: %d, Nome: %s, Fone: %s, Email: %s", codigo, nome, fone, email);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listarPessoaPorCodigo() {
		String sql = "select * from tb_pessoa where codigo = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				String email = rs.getString("email");
				String aux = String.format("Código: %d, Nome: %s, Fone: %s, Email: %s", codigo, nome, fone, email);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apagarPorEmail() {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM tb_pessoa WHERE email like ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, email);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
