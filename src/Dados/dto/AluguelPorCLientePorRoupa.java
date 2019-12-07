/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.dto;

import Dados.Entidades.Aluguel;
import Dados.Entidades.Cliente;
import Dados.Entidades.Roupa;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author Michael
 */
public class AluguelPorCLientePorRoupa {
    
    private Cliente cliente;
    private Roupa roupa;
    private Aluguel aluguel;
    
    public AluguelPorCLientePorRoupa(Cliente c, Roupa r, Aluguel a){
        setCliente(c);
        setRoupa(r);
        setAluguel(a);
    }
    
    public String getDataAluguelFormatada(){
        
        DateTimeFormatter formatador = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM);
        
        String formatado = aluguel.getDataAluguel().format(formatador);
        return formatado;
        
    }
    
     public String getDataDevolucaoFormatada(){
        
        DateTimeFormatter formatador = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM);
        
        String formatado = aluguel.getDataDevolucao().format(formatador);
        return formatado;
        
    }
          
          public  String getValorTabela(){
                  
                  return aluguel.getValor().toString();
          
     
                          }
     
     
     
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Roupa getRoupa() {
        return roupa;
    }

    public void setRoupa(Roupa roupa) {
        this.roupa = roupa;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
    
    
    
}
