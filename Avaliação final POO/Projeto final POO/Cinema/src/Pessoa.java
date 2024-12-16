public abstract class Pessoa {

    private String cpf;
    private String nome;
    private String email;

    public Pessoa(String cpf, String nome, String email){

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;

    }

    public String getcpf() {

        return cpf;

    }

    public void setcpf(String cpf) {

        this.cpf = cpf;

    }

    public String getnome(){

        return nome;

    }

    public void setnome(String nome){

        this.nome = nome;

    }

    public String getemail(){

        return email;

    }

    public void setemail(String email){

        this.email = email;

    }

}
