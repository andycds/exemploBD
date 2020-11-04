package br.usjt.bd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pessoa {
	private int codigo;
	private String nome;
	private String fone;
	private String email;
}
