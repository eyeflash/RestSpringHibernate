/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufo.invrest.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riza
 */
@Entity
@Table(name = "DIVISI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisi.findAll", query = "SELECT d FROM Divisi d")
    , @NamedQuery(name = "Divisi.findByNomor", query = "SELECT d FROM Divisi d WHERE d.nomor = :arg1")
    , @NamedQuery(name = "Divisi.findByKode", query = "SELECT d FROM Divisi d WHERE d.kode = :arg1")
    , @NamedQuery(name = "Divisi.findByKeterangan", query = "SELECT d FROM Divisi d WHERE d.keterangan = :arg1")})
public class Divisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMOR")
    private Integer nomor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "KODE")
    private String kode;
    @Size(max = 128)
    @Column(name = "KETERANGAN")
    private String keterangan;

    public Divisi() {
    }

    public Divisi(Integer nomor) {
        this.nomor = nomor;
    }

    public Divisi(Integer nomor, String kode) {
        this.nomor = nomor;
        this.kode = kode;
    }

    public Integer getNomor() {
        return nomor;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomor != null ? nomor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisi)) {
            return false;
        }
        Divisi other = (Divisi) object;
        if ((this.nomor == null && other.nomor != null) || (this.nomor != null && !this.nomor.equals(other.nomor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufo.invrest.pojo.Divisi[ nomor=" + nomor + " ]";
    }
    
}
