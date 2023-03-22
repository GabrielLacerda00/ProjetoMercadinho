package dto;


import java.text.SimpleDateFormat;
import java.util.Date;

public class LoteDTO {
	
	private String idProduto;
	
	private int quantidade;


	private String dataValidade;


	public LoteDTO(String idProduto, int quantidade, String dataValidade) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.dataValidade = dataValidade;
	}
	
	public String getIdProduto() {
		return idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}

