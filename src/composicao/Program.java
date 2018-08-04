/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicao;

import Entidade.ContratoPorHora;
import Entidade.Departamento;
import Entidade.Enum.NivelTrabalhador;
import Entidade.Trabalhador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Digite o departamento: ");
        String nomeDep = sc.nextLine();
        System.out.println("Dados do trabalhador:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Nivel: ");
        String nivel = sc.nextLine();
        System.out.print("Salario base: ");
        double salarioBase = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase, new Departamento(nomeDep));
        
        System.out.print("Digite a quantidade de contratos este trabalhador tem? ");
        int qtdContratos = sc.nextInt();
        
        for (int i = 0; i < qtdContratos; i++) {
            System.out.println("Digite os dados do " +(i+1)+" contrato: ");
            System.out.print("Data(DD/MM/YYYY):");
            Date dataContrato = sdf.parse(sc.next());
            System.out.println("Valor por hora: ");
            double valorPorHora = sc.nextDouble();
            System.out.println("Duração(Horas): ");
            int horas = sc.nextInt();
            
            ContratoPorHora contratoPorHora = new ContratoPorHora(dataContrato, valorPorHora, horas);
            trabalhador.adicionarContrato(contratoPorHora);
        }
        System.out.println();
        System.out.println("Entre com o mês e o ano para ver o retorno: (MM/YYYY):");
        String mesAno = sc.next();
        int mes = Integer.parseInt(mesAno.substring(0,2));
        int ano = Integer.parseInt(mesAno.substring(3));
        
        System.out.println("Nome: "+trabalhador.getNome());
        System.out.println("Departamento: " +trabalhador.getDepartamento().getNome());
        System.out.println("Retorno "+mesAno+ ": "+trabalhador.rendimento(ano, mes));
        
        sc.close();
    }

}
