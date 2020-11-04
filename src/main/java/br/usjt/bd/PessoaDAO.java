package br.usjt.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class PessoaDAO {
	public void inserir(Pessoa pessoa) {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getFone());
			ps.setString(3, pessoa.getEmail());
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Pessoa pessoa) {
		// 1: Definir o comando SQL
		String sql = "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE codigo = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getFone());
			ps.setString(3, pessoa.getEmail());
			ps.setInt(4, pessoa.getCodigo());
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apagar(Pessoa pessoa) {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM tb_pessoa WHERE codigo = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setInt(1, pessoa.getCodigo());
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Pessoa> listar() {
		List<Pessoa> pessoas = new LinkedList<>();
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
				Pessoa pessoa = new Pessoa(codigo, nome, fone, email);
				// String aux = String.format("Código: %d, Nome: %s, Fone: %s, Email: %s",
				// codigo, nome, fone, email);
				// JOptionPane.showMessageDialog(null, aux);
				pessoas.add(pessoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoas;
	}

	public Pessoa listarPessoaPorCodigo(Pessoa pessoa) {
		String sql = "select * from tb_pessoa where codigo = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, pessoa.getCodigo());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				String email = rs.getString("email");
//				String aux = String.format("Código: %d, Nome: %s, Fone: %s, Email: %s", codigo, nome, fone, email);
//				JOptionPane.showMessageDialog(null, aux);
				return new Pessoa(codigo, nome, fone, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Pessoa(); // FIXME Optional
	}

	public void apagarPorEmail(Pessoa pessoa) {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM tb_pessoa WHERE email like ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, pessoa.getEmail());
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
