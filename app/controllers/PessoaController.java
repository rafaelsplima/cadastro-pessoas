package controllers;

import models.Pessoa;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import request.PessoaRequestDTO;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import entitys.response.AbstractResponse;
import views.html.*;

public class PessoaController extends Controller {

	/**
	 * Renderiza index a partir de um templlate
	 * 
	 * @return
	 */
	public static Result index() {
		return ok(template.render());
	}

	/**
	 * Retorna todos os registros da tabela pessoa
	 * 
	 * @return
	 */
	public static Result findAllPessoas() {
		return ok(Json.toJson(Pessoa.findAllPessoa()));
	}

	/**
	 * Edita Pessoa
	 * 
	 * @return
	 */

	public static Result editarPessoa() {
		Form<PessoaRequestDTO> form = Form.form(PessoaRequestDTO.class);
		form = form.bindFromRequest();
		PessoaRequestDTO request = form.get();
		AbstractResponse response = null;
		Pessoa pessoa = new Pessoa();
		pessoa = pessoa.findByCPF(Long.parseLong(request.getCpf()));

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Calendar data = Calendar.getInstance();
		
		if (pessoa.validarCpfIgual(pessoa)) {
			pessoa.setNome(request.getNome());
			data.set(request.getAno(),(request.getMes()-1),request.getDia());
			pessoa.setDataNascimento(df.format(data.getTime()));
			pessoa.setPeso(request.getPeso());
			pessoa.setUf(request.getUf());
			pessoa.editarPessoaModel(pessoa);
			response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDesc(),
					AbstractResponse.TypeEnum.SUCCESS.getDescricao(), "Pessoa editada com sucesso!");
		} else {
			response = new AbstractResponse(AbstractResponse.IconEnum.REMOVE.getDesc(),
					AbstractResponse.TypeEnum.DANGER.getDescricao(), "Erro interno do servidor. Tente novamente");
		}
		return ok(Json.toJson(response));
	}

	/**
	 * Cadastra Pessoa
	 * 
	 * @return
	 */
	public static Result cadastrarPessoa() {
		Form<PessoaRequestDTO> form = Form.form(PessoaRequestDTO.class);
		form = form.bindFromRequest();
		PessoaRequestDTO request = form.get();
		AbstractResponse response = null;
		Pessoa pessoa = new Pessoa();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Calendar data = Calendar.getInstance();

		// Setando atributos de pessoas com os valores passados pelo front-end
		pessoa.setCpf(Long.parseLong(request.getCpf()));
		pessoa.setNome(request.getNome());
	
		if (pessoa.validarAno(request.getAno(),(request.getMes()-1),request.getDia())) {
			if (request.getAno() > 0 && (request.getMes()-1) > 0 && request.getDia() > 0) {
				data.set(request.getAno(),(request.getMes()-1),request.getDia());
				pessoa.setDataNascimento(df.format(data.getTime()));
			}
		} else {
			response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDesc(),
					AbstractResponse.TypeEnum.WARNING.getDescricao(), "Verifique o campo Ano");
			return ok(Json.toJson(response));
		}
		
	
		if (pessoa.validarPeso(request.getPeso())) {
			pessoa.setPeso(request.getPeso());
		} else {
			response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDesc(),
					AbstractResponse.TypeEnum.WARNING.getDescricao(), "Verifique o campo Peso");
			return ok(Json.toJson(response));
		}
		
	
		if (!request.getUf().isEmpty()) {
			pessoa.setUf(request.getUf());
		}		
		
		

		// Condição para retornar mensagem para Toast pela classe
		// AbstractResponse
		if (!pessoa.validarCpfIgual(pessoa)) {
			response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDesc(),
					AbstractResponse.TypeEnum.SUCCESS.getDescricao(), "Pessoa adicionada com Sucesso!");
		}

		else {
			response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDesc(),
					AbstractResponse.TypeEnum.WARNING.getDescricao(), " CPF da pessoa já existe!");
		}

		// Chamar função para cadastrar pessoa
		pessoa.cadastrarPessoaModel(pessoa);

		return ok(Json.toJson(response));
	}

	/**
	 * Deleta Pessoa
	 * 
	 * @param cpf
	 *            cpf da pessoa a ser deletada
	 * @return
	 */
	public static Result deletarPessoa(Long cpf) {
		AbstractResponse response = null;
		Pessoa pessoa = new Pessoa(); 
		pessoa = pessoa.findByCPF(cpf);
		if (pessoa != null) {
			try {
				pessoa.deletarModel(cpf);
				response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDesc(),
						AbstractResponse.TypeEnum.SUCCESS.getDescricao(), "Pessoa excluída com sucesso!");
			} catch (Exception e) {
				response = new AbstractResponse(AbstractResponse.IconEnum.REMOVE.getDesc(),
						AbstractResponse.TypeEnum.DANGER.getDescricao(), "Erro interno do servidor. Tente novamente");
			}
		}
		return ok(Json.toJson(response));
	}

}
