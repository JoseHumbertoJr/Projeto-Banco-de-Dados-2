package fabricas;

import dao.ContatoDAO;
import dao.ContatoLista;
import dao.ContatoMySql;
import dao.ContatoPostgres;
import dao.ContatoSQLServer;

public class FabricaDeContato {
	
	public static ContatoDAO getInstancia(TipoDeConexao tipo) {
		switch (tipo) {
		case MYSQL:
			return new ContatoMySql(tipo);
		case SQL_SERVER:
			return new ContatoSQLServer(tipo);
		case POSTGRES:
			return new ContatoPostgres(tipo);
		default:
			return new ContatoLista(tipo); // Conex�o default
		}
	}

}
