package fabricas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum TipoDeConexao {
      	SQL_SERVER {
        @Override
        public Connection getInstancia() {
        	try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
      },
      	MYSQL {
          @Override
          public Connection getInstancia() {
        	  Connection connection = null;
        	  try {
  				Class.forName("com.mysql.jdbc.Driver");
  				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cliente?useTimezone=true&serverTimezone=UTC","JH","outolook1");
  				System.out.println("conectou");
          	} catch (SQLException e) {
  				System.out.println("Problemas na conexão");
  			} catch (Exception e) {
  				System.out.println("Problemas na conexão");
  			}
          	
          	return connection ;
          }   
        },	
      	
       POSTGRES {

		@Override
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
    	  
      }, 
       
       LISTA{

		@Override
		public Connection getInstancia() {
			// Utilizado apenas de forma didática.
			return null;
		} 
      }
      ;

	// Utilizados como forma de configuração. No próximo exemplo, utilize um arquivo XML de configuração
    public abstract Connection getInstancia();
    private static Connection connection;
    
    private static String usuario = "postgres";
    private static String senha = "outolook1";
    
    // SQL_SERVER = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;databaseName=agenda"
    
    private static String stringDeConexao = "jdbc:postgresql://localhost:5432/Jdbc";
    
}