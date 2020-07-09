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
public class Pelanggan {
    private int id_pelanggan;
    private String nama, no_telpon, alamat;

    public Pelanggan(int id_pelanggan, String nama, String no_telpon, String alamat) {
        this.id_pelanggan = id_pelanggan;
        this.nama = nama;
        this.no_telpon = no_telpon;
        this.alamat = alamat;
    }

    public Pelanggan(String nama, String no_telpon, String alamat) {
        this.nama = nama;
        this.no_telpon = no_telpon;
        this.alamat = alamat;
    }

    public Pelanggan(int id_pelanggan, String nama) {
        this.id_pelanggan = id_pelanggan;
        this.nama = nama;
    }

    public Pelanggan() {
    }
    

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telpon() {
        return no_telpon;
    }

    public void setNo_telpon(String no_telpon) {
        this.no_telpon = no_telpon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return  + id_pelanggan + ": " + nama;
    }
    
    
}
