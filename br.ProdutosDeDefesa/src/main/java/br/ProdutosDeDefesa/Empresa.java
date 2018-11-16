package br.ProdutosDeDefesa;

public class Empresa {
	
	private long id;
	private String nome;
	private String cnpj_portaria;
	private String numeroPed;
	private String site;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj_portaria;
	}
	public void setCnpj(String cnpj) {
		this.cnpj_portaria = cnpj;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getNumeroPed() {
		return numeroPed;
	}
	public void setNumeroPed(String numeroPed) {
		this.numeroPed = numeroPed;
	}
	
}
