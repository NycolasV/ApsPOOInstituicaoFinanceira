package br.com.uam.apspoo.models;


/**
 * @author NycolasVieira
 */
public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome.isBlank())
            throw new Exception("Nome não pode ser nulo, tente novamente");
            
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if(cpf.isBlank())
            throw new Exception("CPF incorreto, tente novamente");
        
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        if(telefone.isBlank())
            throw new Exception("Telefone não pode ser nulo, tente novamente");
        
        this.telefone = telefone;
    }
    
    public String imprimir(){
        return "NOME: " + this.nome + "\n" 
                + "CPF: " + this.cpf + "\n" 
                + "TELEFONE: " + this.telefone + "\n";        
    }
}
