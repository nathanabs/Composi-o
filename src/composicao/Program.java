/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicao;

import Entidade.Departamento;
import Entidade.Enum.NivelTrabalhador;
import Entidade.Trabalhador;
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
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

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
        
        
        sc.close();
    }

}
