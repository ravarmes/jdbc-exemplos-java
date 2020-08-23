package jdbc.exemplos.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.exemplos.java.model.Cliente;

/**
 *
 * @author Rafael Vargas Mesquita
 */
public class MainUpdate {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        String DATABASE_URL = "jdbc:derby://localhost:1527/bdteste";
        String usuario = "root";
        String senha = "123";
        
        Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        
        String sql = "UPDATE CLIENTES SET nome=?, cpf=?, telefone=? WHERE ID=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        Cliente cliente = new Cliente(1, "Cliente 0", "000.000.000-00", "(00) 0000-0000");
        
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getTelefone());
        ps.setInt(4, cliente.getId());
        ps.execute();
    }
}
