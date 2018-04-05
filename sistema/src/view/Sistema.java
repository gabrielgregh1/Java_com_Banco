
package view;

import model.bean.Cliente;
import model.dao.ClienteDAO;


public class Sistema {


    public static void main(String[] args) {
       
        Cliente c = new Cliente("flavin@hotmail.com","wsajof", "Luis", 23);
        ClienteDAO cdao = new ClienteDAO();
        
        cdao.create(c);
        
        for(Cliente cli : cdao.read()){
            System.out.println("---------------------");
            System.out.println(cli.getLogin());
            System.out.println(cli.getSenha());
            System.out.println(cli.getIdade());
            System.out.println(cli.getNome());
            
        }
    }
    
}
