/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Entidades;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author IFNMG
 */
@Entity
public class Roupa {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoupa;
    private String tipoRoupa;
    private String cor;
    private String tamanho;
    private String detalhes;
    private String genero;

    public Roupa(String tipoRoupa, String cor, String tamanho, String detalhes, String genero) {
        this.tipoRoupa = tipoRoupa;
        this.cor = cor;
        this.tamanho = tamanho;
        this.detalhes = detalhes;
        this.genero = genero;
        
        
    }

    public Roupa(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idRoupa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Roupa other = (Roupa) obj;
        if (!Objects.equals(this.idRoupa, other.idRoupa)) {
            return false;
        }
        return true;
    }

    public Integer getIdRoupa() {
        return idRoupa;
    }

    public void setIdRoupa(Integer idRoupa) {
        this.idRoupa = idRoupa;
    }

    public String getTipoRoupa() {
        return tipoRoupa;
    }

    public void setTipoRoupa(String tipoRoupa) {
        this.tipoRoupa = tipoRoupa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    



    }
