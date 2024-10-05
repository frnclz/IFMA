import java.util.Collection;

public class LOCACAO {

	private float valorAluguel;

	private String periodoCidade;

	private float percentualMulta;

	private date diaVencimento;

	private date dataInicio;

	private date dataFim;

	private bit ativo;

	private BLOB contrato;

	private BLOB modeloRecibo;

	private String responsavelPagamento;

	private String caminhoSituacaoImovel;

	private String OBS;

	private Collection<ALUGUEIS> aLUGUEIS;

	private IMOVEIS imovel;

	private PROFISSIONAIS profissional;

	private CLIENTES cliente;

}
