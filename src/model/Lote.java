package model;

import java.util.Date;
import java.util.UUID;

public class Lote {

	private String id;

	private Produto produto;

	private double quantidade;

	private Date dataFabricacao;

	private Date dataValidade;

	public Lote(Produto produto, int quantidade, Date dataValidade) {
		this.id = UUID.randomUUID().toString();
		this.produto = produto;
		this.quantidade = quantidade;
		this.dataFabricacao = new Date();
		this.dataValidade = dataValidade;
	}

	public String getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setQuantidade(double d) {
		this.quantidade = d;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public void somaQuantidade(Double quantidade) {
		Double valor = getQuantidade();
	}

	public void printLote(String lote) {
		System.out.println(lote);
	}

	public String toString() {
		return "Lote ID: " + getId() + " - Produto: " + getProduto().getNome() + " - " + getQuantidade() + " itens";
	}
}
