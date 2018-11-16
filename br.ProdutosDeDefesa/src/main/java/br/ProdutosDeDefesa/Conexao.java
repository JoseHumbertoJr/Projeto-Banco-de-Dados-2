package br.ProdutosDeDefesa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	
	private Connection connection = null;
	private static String usuario = "postgres";
    private static String senha = "outolook1";
    private static String stringDeConexao = "jdbc:postgresql://localhost:5432/MinisterioDaDefesa";
	
	public Connection getInstancia() {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(stringDeConexao, usuario, senha);
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
    		e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
    	return connection ;
	}
	public void add(Empresa empresa, Compra compra) {
		try {
			
			String insercaoEmpresa = "insert into empresa (id_empresa,nome,cnpj_portaria,numeroPed,site) "
					+ "values ( ?, ?, ?, ?, ?) returning nome "; 
			String insercaoCompra = "insert into compra (id_compra, data, produto,classificacao,id_empresa) "
					+ "values ( ?, ?, ?, ?, ?)";
			
			PreparedStatement inserirEmpresa = connection.prepareStatement(insercaoEmpresa);
			//EMPRESA
			inserirEmpresa.setLong(1, empresa.getId());
			inserirEmpresa.setString(2, empresa.getNome());
			inserirEmpresa.setString(3, empresa.getCnpj());
			inserirEmpresa.setString(4, empresa.getNumeroPed());
			inserirEmpresa.setString(5, empresa.getSite());
			PreparedStatement inserirCompra = connection.prepareStatement(insercaoCompra);
			//COMPRA
			inserirCompra.setLong(1, compra.getId());
			inserirCompra.setString(2, compra.getData());
			inserirCompra.setString(3, compra.getProduto());
			inserirCompra.setString(4, compra.getClassificacao());
			inserirCompra.setLong(5, compra.getId_empresa());

			// Executa o comando de cadastro do contato
			inserirEmpresa.execute();
			System.out.println("Empresa Cadastrada!!");
			inserirCompra.execute();
			System.out.println("Compra Cadastrada!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
	}

}
