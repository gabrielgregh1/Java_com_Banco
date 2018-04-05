
package model.dao;

import Connection.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Cliente;


public class ClienteDAO {
    
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
    public void create(Cliente c){
        try{
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO cliente (login, senha, nome, idade) VALUES (?,MD5(?), ?, ?)");
            stmt.setString(1, c.getLogin());
            stmt.setString(2,c.getSenha());
            stmt.setString(3, c.getNome());
            stmt.setInt(4, c.getIdade());
        
            stmt.executeUpdate();
    
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Cliente> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try{
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setLogin(rs.getString("login"));
                c.setSenha(rs.getString("senha"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                
                clientes.add(c);
            }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao tentar exibir os dados");
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }
    
}
