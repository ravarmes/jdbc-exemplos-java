package jdbc.exemplos.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.exemplos.java.model.Cliente;

/**
 *
 * @author Rafael Vargas Mesquita
 */
public class MainSelect {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        String DATABASE_URL = "jdbc:derby://localhost:1527/bdteste";
        String usuario = "root";
        String senha = "123";
        
        Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        
        String sql = "SELECT * FROM CLIENTES";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("telefone"));
            System.out.println(cliente);
        }
    }
}
