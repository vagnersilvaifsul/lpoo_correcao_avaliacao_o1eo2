package model;

public abstract class Cliente implements Socio{
    protected String nome;
    protected String sobrenome;
    protected String email;
    private int quantidadeDeAcoes;
    private double valorDaAcao;

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String email, int quantidadeDeAcoes, double valorDaAcao) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.quantidadeDeAcoes = quantidadeDeAcoes;
        this.valorDaAcao = valorDaAcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQuantidadeDeAcoes(int quantidadeDeAcoes) {
        this.quantidadeDeAcoes = quantidadeDeAcoes;
    }

    public double getValorDaAcao() {
        return valorDaAcao;
    }

    public void setValorDaAcao(double valorDaAcao) {
        this.valorDaAcao = valorDaAcao;
    }

    @Override
    public int getQuantidadeDeAcoes() {
        return this.quantidadeDeAcoes;
    }

    @Override
    public double geValorDaAcao() {
        return this.valorDaAcao;
    }
}
