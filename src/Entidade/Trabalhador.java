/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import Entidade.Enum.NivelTrabalhador;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Nathan
 */
public class Trabalhador {
    private String nome;
    private NivelTrabalhador nivel;
    private double salarioBase;
    
    private Departamento departamento;
    private List<ContratoPorHora> contratos = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String nome, NivelTrabalhador nivel, double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoPorHora> getContratos() {
        return contratos;
    }
    
    public void adicionarContrato(ContratoPorHora contrato){
        contratos.add(contrato);
    }
    public void removeContrato(ContratoPorHora contrato){
        contratos.remove(contrato);
    }
    public double rendimento(int ano, int mes){
        double soma = this.salarioBase;
        Calendar cal = Calendar.getInstance();
        
        for (ContratoPorHora c : contratos){
            cal.setTime(c.getData());
            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = cal.get(Calendar.MONTH);
            
            if(ano == c_ano && c_mes == mes){
                soma += c.valorTotal();
            }
        }
        
        return soma;
    }
}
