package jdbc.exemplos.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rafael Vargas Mesquita
 */
public class MainDelete {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        String DATABASE_URL = "jdbc:derby://localhost:1527/bdteste";
        String usuario = "root";
        String senha = "123";
        
        Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        
        String sql = "DELETE FROM CLIENTES WHERE ID=1";
        PreparedStatement ps = connection.prepareStatement(sql);
                
        ps.execute();
    }
}
