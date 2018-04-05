
package model.bean;



public class Cliente {
    private String login;
    private String senha;
    private String nome;
    private int idade;
    
    public Cliente(){}
    
    public Cliente(String login, String senha, String nome, int idade){
        this.login = login;
        this.idade = idade;
        this.senha = senha;
        this.nome = nome;
    
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
