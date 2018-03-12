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
	 * Renderiza index
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
	public static Result listAllPessoas() {
		Pessoa lstPessoa = new Pessoa();
		return ok(Json.toJson(lstPessoa.listPessoas()));
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
		pessoa = pessoa.buscarCpf(Long.parseLong(request.getCpf()));
		Double peso;
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Calendar data = Calendar.getInstance();
		
		/** Verifica entrada de dados erradas de peso e data  */
		if (pessoa.validarData(request.getAno(),(request.getMes()),request.getDia())) {
			if (request.getAno() > 0 && (request.getMes()) > 0 && request.getDia() > 0) {
				data.set(request.getAno(),(request.getMes()-1),request.getDia());
				pessoa.setDataNascimento(df.format(data.getTime()));
			}
		} else {
			response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDesc(),
					AbstractResponse.TypeEnum.WARNING.getDescricao(), "Verifique o campo Data de Nascimento");
			return ok(Json.toJson(response));
		}
		
		peso = Double.parseDouble(request.getPeso().toString());
	
		if (pessoa.validarPeso(peso)) {
			pessoa.setPeso(peso);
		} else {
			response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDesc(),
					AbstractResponse.TypeEnum.WARNING.getDescricao(), "Verifique o campo Peso");
			return ok(Json.toJson(response));
		}
		
		
		/** valida se foi selecionado alguma uf **/
		if (!pessoa.validaUf(request.getUf())) {
			pessoa.setUf(request.getUf());
		}		
		
		
		/** Verifica se existem pessoas com o mesmo cpf **/
		if (pessoa.validarCpfIgual(pessoa)) {
			pessoa.setNome(request.getNome());
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
		Double peso;


		pessoa.setCpf(Long.parseLong(request.getCpf()));
		pessoa.setNome(request.getNome());
		
		/** Verifica entrada de dados erradas de peso e data  */
		if (pessoa.validarData(request.getAno(),(request.getMes()),request.getDia())) {
			if (request.getAno() > 0 && (request.getMes()) > 0 && request.getDia() > 0) {
				data.set(request.getAno(),(request.getMes()-1),request.getDia());
				pessoa.setDataNascimento(df.format(data.getTime()));
			}
		} else {
			response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDesc(),
					AbstractResponse.TypeEnum.WARNING.getDescricao(), "Verifique o campo Data de Nascimento");
			return ok(Json.toJson(response));
		}

		
		peso = Double.parseDouble(request.getPeso().toString());
			
		if (pessoa.validarPeso(peso)) {
			pessoa.setPeso(peso);
		} else {
			response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDesc(),
					AbstractResponse.TypeEnum.WARNING.getDescricao(), "Verifique o campo Peso");
			return ok(Json.toJson(response));
		}
		
		/** valida se foi selecionado alguma uf **/
		if (!pessoa.validaUf(request.getUf())) {
			pessoa.setUf(request.getUf());
		}		
			
		/** Verifica se existem pessoas com o mesmo cpf **/
		if (!pessoa.validarCpfIgual(pessoa)) {
			response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDesc(),
					AbstractResponse.TypeEnum.SUCCESS.getDescricao(), "Pessoa adicionada com Sucesso!");
		}

		else {
			response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDesc(),
					AbstractResponse.TypeEnum.WARNING.getDescricao(), " CPF da pessoa já existe!");
		}

		
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
		pessoa = pessoa.buscarCpf(cpf);
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
