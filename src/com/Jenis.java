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
public class Jenis {
    private int id_jenis;
    private String nama, keterangan;

    public Jenis(int id_jenis, String nama, String keterangan) {
        this.id_jenis = id_jenis;
        this.nama = nama;
        this.keterangan = keterangan;
    }

    public Jenis(String nama, String keterangan) {
        this.nama = nama;
        this.keterangan = keterangan;
    }

    public Jenis(int id_jenis, String nama) {
        this.id_jenis = id_jenis;
        this.nama = nama;
    }

    public Jenis() {
    }
    
    

    public int getId_jenis() {
        return id_jenis;
    }

    public void setId_jenis(int id_jenis) {
        this.id_jenis = id_jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return  id_jenis + ": " + nama;
    }
    
    
}
