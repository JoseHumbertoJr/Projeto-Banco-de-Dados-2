package br.ProdutosDeDefesa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		
		Empresa empresa = new Empresa();
		Compra compra = new Compra();
		Conexao conexao = new Conexao();
		String linha = new String();
		String caminhoArq = "C:\\\\Users\\\\José Humberto\\\\Desktop\\\\SI\\\\Banco de Dados II\\\\P2\\\\produtos_de_defesa.csv";
		String separador = ",";
		File arquivoCSV = new File(caminhoArq);

		int idEmpresa = 1;
		int idCompra = 1;
		String[] coin = linha.split(separador);
		try {
			FileReader leitorArquivos = new FileReader(caminhoArq);
			BufferedReader conteudo = new BufferedReader(leitorArquivos);
			linha = conteudo.readLine();
			while((linha = conteudo.readLine()) != null) {
				coin = linha.split(separador);
				empresa.setId(idEmpresa);
				empresa.setNome(coin[0]);
				empresa.setCnpj(coin[1]);
				empresa.setNumeroPed(coin[2]);
				empresa.setSite(coin[6]);
				
				compra.setId(idCompra);
				compra.setData(coin[3]);
				compra.setProduto(coin[4]);
				compra.setClassificacao(coin[5]);
				compra.setId_empresa(idEmpresa);
				conexao.getInstancia();
				conexao.add(empresa, compra);
				System.out.println("Empresa: "+coin[0]+" Cnpj/NPed: "+coin[1]+" NumeroPed: "+coin[2]+" Data: "+coin[3]+" Produtos: "+coin[4]+
						" Classificação: "+coin[5]+" Site: "+coin[6]);
				idCompra++;
				idEmpresa++;
			}
			conteudo.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
