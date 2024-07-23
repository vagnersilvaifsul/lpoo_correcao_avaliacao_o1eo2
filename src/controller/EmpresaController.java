package controller;

import model.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpresaController {
    public static void main(String[] args) {
        //b
        ClientePessoaFisica cpf1 = new ClientePessoaFisica("Ana", "Silva", "ana@email.com", 7, 10.0, "111.222.333-34");
        ClientePessoaFisica cpf2 = new ClientePessoaFisica("Rafael", "Torres", "rafa@email.com", 6, 10.0, "222.333.444-55");
        ClientePessoaJuridica cpj1 = new ClientePessoaJuridica("Silva Construções", "", "silva_construcoes@email.com", 3, 10.0, "12340001-23");
        ClientePessoaJuridica cpj2 = new ClientePessoaJuridica("Torres Varejo", "", "torres_varejo@email.com", 4, 10.0, "888840001-43");
        Vendedor v1 = new Vendedor("João", "Santos", 3000.0, 8, 10.0, 5.0);
        Vendedor v2 = new Vendedor("Maria", "Dias", 3000.0, 2, 10.0, 5.0);
        Gerente g1 = new Gerente("Pedro", "Alvarez", 12000.0, 1, 10.0, 2.0);
        Gerente g2 = new Gerente("Silvia", "Ramos", 12000.0, 8, 10.0, 2.0);

        //c
        System.out.println("******** C ********");
        System.out.println(cpf1);
        System.out.println(cpf2);
        System.out.println(cpj1);
        System.out.println(cpj2);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(g1);
        System.out.println(g2);

        //d
        System.out.println("******** D ********");
        List<Socio> socios = new ArrayList<>();
        socios.add(cpf1);
        socios.add(cpf2);
        socios.add(cpj1);
        socios.add(cpj2);
        socios.add(v1);
        socios.add(v2);
        socios.add(g1);
        socios.add(g2);
        System.out.println("Lista criada:");
        System.out.println(socios);

        //e feito nos construtores
        System.out.println("******** E ********");

        //f
        System.out.println("******** F ********");
        double acum_folha = 0.0;
        for (Socio socio : socios) {
            if(socio instanceof Funcionario){
                acum_folha += ((Funcionario) socio).getSalario();
            }

        }
        System.out.println("Folha salarial sem Comissões e Bonificações: "
            + NumberFormat.getCurrencyInstance().format(acum_folha));

        //g
        System.out.println("******** G ********");
        double acum_custoVendedor = 0.0;
        double acum_custoGerente = 0.0;
        for (Socio socio : socios) {
            if(socio instanceof Vendedor){
                acum_custoVendedor += ((Vendedor) socio).getSalario()
                    + (500000.0 * (((Vendedor) socio).getTaxaDeComissao()/100));
            }
            if(socio instanceof Gerente){
                acum_custoGerente += ((Gerente) socio).getSalario()
                    + (1000000.0 * (((Gerente) socio).getTaxaDeBonificacao()/100));
            }
        }
        System.out.println("Custo Vendedores= " + acum_custoVendedor);
        System.out.println("Custo Gerentes= " + acum_custoGerente);

        //h
        System.out.println("******** H ********");
        socios.sort(Comparator.comparing(Socio::getQuantidadeDeAcoes));
        System.out.println(socios);

//        List<Socio> socioList = new ArrayList<>();
//        socioList.addAll(listaDeFuncionarios);
//        socioList.addAll(listaDeClientes);
//        socios.sort(Comparator.comparing(Socio::getQuantidadeDeAcoes));
//        System.out.println(socios);

        //i
        System.out.println("******** I ********");
        List<Cliente> clientes = new ArrayList<>();
        socios.forEach(s -> {
            if(s instanceof Cliente) {
                clientes.add((Cliente) s);
            }
        });
        clientes.sort(Comparator.comparing(Cliente::getNome));
        System.out.println(clientes);

        //j
        System.out.println("******** J ********");
        double total_de_acoes = 0.0;
        for (Socio socio : socios) {
            total_de_acoes += socio.getQuantidadeDeAcoes();
        }
        System.out.println("Total de ações da empresa=" + total_de_acoes);
        System.out.println("Valor de mercado=" + (total_de_acoes * 10.0));

        //k
        System.out.println("******** K ********");
        Socio socio_max = Collections.max(socios, Comparator.comparing(Socio::getQuantidadeDeAcoes));
        for (Socio socio : socios) {
            if(socio_max.getQuantidadeDeAcoes() == socio.getQuantidadeDeAcoes()){
                System.out.println(socio);
            }
        }

        int max = socios.stream().mapToInt(Socio::getQuantidadeDeAcoes).max().getAsInt();
        for (Socio socio : socios) {
            if(max == socio.getQuantidadeDeAcoes()){
                System.out.println(socio);
            }
        }
    }
}
