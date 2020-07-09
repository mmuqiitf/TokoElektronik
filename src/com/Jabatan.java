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
public class Jabatan {
    private int id_jabatan;
    private String nama;

    public Jabatan(int id_jabatan, String nama) {
        this.id_jabatan = id_jabatan;
        this.nama = nama;
    }

    public Jabatan(String nama) {
        this.nama = nama;
    }

    public Jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }
    
    public Jabatan() {
    }
    
    public int getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return id_jabatan + ": " + nama;
    }
    
    
}
