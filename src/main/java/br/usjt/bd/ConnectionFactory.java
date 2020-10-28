package br.usjt.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private String usuario = "alunos";
	private String senha = "alunos";
	private String host = "localhost";
	private String porta = "3306";
	private String bd = "db_pessoas";

	public Connection obterConexao() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd, usuario, senha);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}