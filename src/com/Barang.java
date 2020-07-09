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
public class Barang {
    private int id_barang;
    private String nama, keterangan, garansi;
    private int stok, id_jenis, id_merk;

    public Barang(int id_barang, String nama, String keterangan, String garansi, int stok, int id_jenis, int id_merk) {
        this.id_barang = id_barang;
        this.nama = nama;
        this.keterangan = keterangan;
        this.garansi = garansi;
        this.stok = stok;
        this.id_jenis = id_jenis;
        this.id_merk = id_merk;
    }

    public Barang(String nama, String keterangan, String garansi, int stok, int id_jenis, int id_merk) {
        this.nama = nama;
        this.keterangan = keterangan;
        this.garansi = garansi;
        this.stok = stok;
        this.id_jenis = id_jenis;
        this.id_merk = id_merk;
    }

    public Barang(int id_barang, String nama) {
        this.id_barang = id_barang;
        this.nama = nama;
    }

    public Barang() {
    }
    
    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
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

    public String getGaransi() {
        return garansi;
    }

    public void setGaransi(String garansi) {
        this.garansi = garansi;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getId_jenis() {
        return id_jenis;
    }

    public void setId_jenis(int id_jenis) {
        this.id_jenis = id_jenis;
    }

    public int getId_merk() {
        return id_merk;
    }

    public void setId_merk(int id_merk) {
        this.id_merk = id_merk;
    }

    @Override
    public String toString() {
        return id_barang + ": " + nama ;
    }
    
    
}
