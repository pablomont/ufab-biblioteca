package com.ufab.enumerador;

/***
 * Enumerador contendo todas as mensagens que os sistema loga, ou apresenta para o usuário final.
 * @author Davi
 *
 */
public enum MensagensEnum {
	// Geral 
	USUARIO_NAO_EXISTE("Usuário não existe."),
	CONTROLADOR_ERRO_RECUPERAR_PARAMETRO("Erro ao recuperar parametro do Formulário."), 
	CONTROLADOR_ERRO_AO_INSERIR("Erro ao inserir Objeto."),
	CONTROLADOR_ERRO_DESCONHECIDO("Erro desconhecido."),  
	//	Item Servico
	ITEM_SERVICO_O_ITEM_NAO_PODE_SER_NULO("O Item nao pode ser Nulo."), 
	ITEM_SERVICO_ERRO_AO_VALIDAR_ITEM("Erro ao validar Item."), 
	ITEM_SERVICO_O_NOME_PODE_NAO_SER_NULO("O Item deve conter um nome."),
	ITEM_SERVICO_O_TITULO_PODE_NAO_SER_NULO("O Item deve conter um titulo."),
	ITEM_SERVICO_ITEM_JA_CADASTRADO("O Item informado ja esta cadastrado no sistema."),
	ITEM_SERVICO_O_TIPO_DE_ITEM_NAO_PODE_SER_NULO("O Tipo de item deve ser informado."), 
	ITEM_SERVICO_PARAMETRO_DE_BUSCA_TITULO_VAZIO("O parametro titulo deve ser informado."),
	ITEM_SERVICO_ERRO_DESCONHECIDO("Erro desconhecido ao executar uma operacao relacionado ao Item."),
	ITEM_SERVICO_ERRO_PARAMETRO_ITEM_NULO("Um Item deve ser informado"),
//	Curso Servico

	CURSO_SERVICO_O_CURSO_NAO_PODE_SER_NULO("O Curso nao pode ser Nulo."), 
	CURSO_SERVICO_ERRO_AO_VALIDAR_CURSO("Erro ao validar Curso."), 
	CURSO_SERVICO_O_NOME_PODE_NAO_SER_NULO("O Curso deve conter um nome."),
	CURSO_SERVICO_A_AREA_PODE_NAO_SER_NULO("O Curso deve conter uma area."),
	CURSO_SERVICO_CURSO_JA_CADASTRADO("O Curso informado ja esta cadastrado no sistema."),
	CURSO_SERVICO_O_TIPO_DE_CURSO_NAO_PODE_SER_NULO("O Tipo de Curso deve ser informado."),
	CURSO_SERVICO_PARAMETRO_DE_BUSCA_NOME_VAZIO("O parametro nome do curso deve ser informado."), 
	CURSO_SERVICO_ERRO_DESCONHECIDO("Erro desconhecido ao executar uma operação relacionado ao Curso."), 
	CURSO_SERVICO_ERRO_PARAMETRO_CURSO_NULO("Um Curso deve ser informado."),
	CURSO_SERVICO_TAG_NULO("A TAG do curso deve ser informada."),
	CURSO_SERVICO_TAG_INVALIDA("A TAG do curso está inválida, o número máximo de caracteres foi ultrapassado."),
	
//	Usuario Servico
	USUARIO_SERVICO_ERRO_AO_VALIDAR_USUARIO("Erro ao validar as informações do usuário."), 
	USUARIO_SERVICO_ERRO_AO_INSERIR("Erro ao inserir usuário."), 
	USUARIO_SERVICO_ERRO_AO_ATUALIZAR("Erro ao atualizar usuário."), 
	USUARIO_SERVICO_ERRO_AO_REMOVER("Erro ao remover usuário."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_CPF_NULO("CPF deve ser informado."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_CPF("CPF informado está inválido."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_SENHA_NULO("A senha deve ser informada."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_DATA_NASCIMENTO_NULO("A data de nascimento deve ser informada."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_ENDERECO_NULO("O endereço deve ser informado."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_NATURALIDADE_NULO("A naturalidade deve ser informada."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_RG_NULO("O RG deve ser informado."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_NOME_NULO("O nome deve ser informado."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_TELEFONE_NULO("O telefone deve se informado."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_PERFIL_NULO("O perfil deve ser informado."), 
	USUARIO_SERVICO_ERRO_AO_VALIDAR_USUARIO_NULO("O objeto usuário deve ser informado."),
	USUARIO_SERVICO_ERRO_AO_VALIDAR_USUARIO_ALUNO("Erro ao validar as informações do aluno."),
//	Permissao Servico
	PERMISSAO_SERVICO_USUARIO_NAO_POSSUI_PERMISSAO("O usuário não possui permissao para esta ação."),
//	Aluno Servico
	ALUNO_SERVICO_ERRO_AO_VALIDAR_MATRICULA("A matrícula do aluno deve ser informada."), 
	ALUNO_SERVICO_ERRO_AO_VALIDAR_NIVEL("O nível do aluno deve ser informado."), 
//	Locacao Servico
	LOCACAO_SERVICO_ERRO_AO_VALIDAR("Erro ao validar a locacao."),
	LOCACAO_SERVICO_VALIDACAO_NULL("A locacao nao pode ser vazia."),
	LOCACAO_SERVICO_VALIDACAO_DT_LOCACAO("A data da locacao deve ser informada."),
	LOCACAO_SERVICO_VALIDACAO_DT_DEVOLUCAO("A data de devolucao deve ser informada."),
	LOCACAO_SERVICO_VALIDACAO_ALUNO("O aluno da locacao deve ser informado."),
	LOCACAO_SERVICO_VALIDACAO_ITEM("O item da locacao deve ser informado."), 
//	Reserva Servico
	RESERVA_SERVICO_VALIDACAO_NULL("A reserva nao pode ser vazia."),
	RESERVA_SERVICO_VALIDACAO_DT_RESERVA("A data da reserva não pode ser vazia."),
	RESERVA_SERVICO_VALIDACAO_ALUNO("O Aluno para a reserva deve ser informado."),
	RESERVA_SERVICO_VALIDACAO_ITEM("O Item para reserva deve ser informado."), 
	RESERVA_SERVICO_ERRO_AO_VALIDAR("Erro ao validar uma reserva."), 
	;


	
	private String valor;

	MensagensEnum(String msg) {
		this.valor = msg;
	}

	public String getValor() {
		return this.valor;
	}
}
