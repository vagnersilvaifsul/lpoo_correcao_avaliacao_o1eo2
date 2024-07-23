package model;

public class Vendedor extends Funcionario{
    private double taxaDeComissao;

    public Vendedor() {
    }

    public Vendedor(String nome, String sobrenome, double salario, int quantidadeDeAcoes, double valorDaAcao, double taxaDeComissao) {
        super(nome, sobrenome, salario, quantidadeDeAcoes, valorDaAcao);
        this.taxaDeComissao = taxaDeComissao;
    }

    public double getTaxaDeComissao() {
        return taxaDeComissao;
    }

    public void setTaxaDeComissao(double taxaDeComissao) {
        this.taxaDeComissao = taxaDeComissao;
    }

    @Override
    public String toString() {
        return "\nVendedor{" +
            "taxaDeComissao=" + taxaDeComissao +
            ", nome='" + nome + '\'' +
            ", sobrenome='" + sobrenome + '\'' +
            ", salario=" + salario +
            ", quantidade de ações= " + getQuantidadeDeAcoes() +
            "} ";
    }
}
