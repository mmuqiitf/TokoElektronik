/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author ALIK
 */
public class Merk {
    private int id_merk;
    private String nama;

    public Merk(int id_merk, String nama) {
        this.id_merk = id_merk;
        this.nama = nama;
    }

    public Merk(String nama) {
        this.nama = nama;
    }

    public Merk() {
    }
    

    public int getId_merk() {
        return id_merk;
    }

    public void setId_merk(int id_merk) {
        this.id_merk = id_merk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return id_merk + ": " + nama;
    }
    
    
}
