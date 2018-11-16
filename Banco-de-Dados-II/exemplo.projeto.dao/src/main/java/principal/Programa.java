package principal;

import java.util.ArrayList;

import dados.Contato;
import dados.Telefone;
import dados.TipoTelefone;
import dao.ContatoDAO;
import dao.ContatoMySql;
import dao.ContatoPostgres;
import fabricas.FabricaDeContato;
import fabricas.TipoDeConexao;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		
		System.out.println("Iniciando exemplo didático");
		
		System.out.println("Criando conexão com o banco de dados");
		ContatoDAO contatoDAO = FabricaDeContato.getInstancia(TipoDeConexao.POSTGRES);
		ContatoPostgres postgress = new ContatoPostgres(TipoDeConexao.POSTGRES);
		
		try {
			
			/*/
			Contato contato = new Contato();
			contato.setCpf("12677925400");
			contato.setNome("jose");
			System.out.println("Busca Geral: ");
			
			Telefone telefone1 = new Telefone();
			telefone1.setNumero("93833844");
			telefone1.setTipo(TipoTelefone.Contato);
			
			Telefone telefone2 = new Telefone();
			telefone2.setNumero("98989898");
			telefone2.setTipo(TipoTelefone.Contato);
			
			contato.addTelefone(telefone1);
			contato.addTelefone(telefone2);
			
			//
			//
			 * 
			 */
			System.out.println("Adicionando dados ao banco");
			postgress.buscaGeral("jose");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Concluindo execução do exemplo.");
		}
		
	}

}
