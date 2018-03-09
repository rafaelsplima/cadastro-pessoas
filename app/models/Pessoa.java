package models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jfree.util.Log;

import entitys.response.AbstractResponse;
import play.Logger;
import play.db.ebean.Model;

@Entity
@Table(name = "pessoa")
public class Pessoa extends Model {
	private static final long serialVersionUID = -143072177321560L;

	public static Finder<Long, Pessoa> find = new Finder<Long, Pessoa>(Long.class, Pessoa.class);

	/**
	 * Atributos
	 */
	@Id
	private Long cpf;

	private String nome;

	private String dataNascimento = "n/d";

	private BigDecimal peso = BigDecimal.ZERO;

	private String uf = "n/d";

	/**
	 * Get/Set
	 *
	 */
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * Busca pessoa a partir do seu cpf
	 * 
	 * @param cpf
	 *            cpf da pessoa a ser buscado
	 * @return Pessoa
	 */

	public Pessoa findByCPF(Long cpf) {
		return find.where().eq("cpf", cpf).findUnique();
	}

	/**
	 * Lista com todas as pessoas cadastradas
	 * 
	 * @return Lista de pessoas
	 */
	public List<Pessoa> findAllPessoa() {
		return find.all();
	}

	/**
	 * Verifica se existem pessoas com o mesmo cpf
	 * 
	 * @param pessoa
	 *            a ser verificada
	 * @return true - existem pessoas com o mesmo cpf false - não existem
	 *         pessoas com o mesmo cpf
	 */
	public  boolean validarCpfIgual(Pessoa pessoa) {

		if (pessoa.findByCPF(pessoa.getCpf()) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Verifica se ah unidade peso está válida
	 * @param peso
	 * @return true - se válida
	 *         false - se inválida
	 */
	public boolean validarPeso (BigDecimal peso) {
		int p = peso.compareTo(BigDecimal.ZERO);
		
		if (p > 0|| p == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Verifica se data nascimento está válida
	 * @param ano 
	 * @param mes
	 * @param dia
	 * @return true se válida
	 *         false se inválida
	 */
	public boolean validarData (int ano, int mes, int dia) {
		if (ano > 0 &&  mes >  0 && dia > 0) {
			return true;
			
		} else {
			if (ano < 0 || mes < 0 || dia < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Verfica se Uf foi selecionada
	 * @param uf
	 * @return true se uf não foi selecioada
	 *         false se uf foi selecionada
	 */    
	
	public boolean validaUf(String uf) {
		if(uf.isEmpty()) {
			return true;
		}
		
		return false;
	}

	/**
	 * Cadastrar pessoas
	 * 
	 * @param pessoa
	 *            Pessoa a ser cadastrada
	 */
	public void cadastrarPessoaModel(Pessoa pessoa) {
		try {
			if (!this.validarCpfIgual(pessoa)) {
				pessoa.save();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Edita Pessoa
	 * 
	 * @param pessoa
	 *            Pessoa a ser editada
	 */
	public void editarPessoaModel(Pessoa pessoa) {
		try {
			if (this.validarCpfIgual(pessoa))
				pessoa.update();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta Pessoa
	 * 
	 * @param cpf
	 *            cpf da pessoa a ser deletada
	 */
	public void deletarModel(Long cpf) {
		try {
			Pessoa pessoa = this.findByCPF(cpf);
			if (pessoa != null) {
				pessoa.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
