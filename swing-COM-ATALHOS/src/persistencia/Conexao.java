package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static Connection con;
	
	 @SuppressWarnings("finally")
	public static Connection conexao(){
		 		
		try{

			 con = DriverManager.getConnection("jdbc:sqlserver://DAVID-PC:1433;" +
			 		"databaseName=teste","eu","eu");
			 						
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	
		finally{
			return con;
		}
	}


}
