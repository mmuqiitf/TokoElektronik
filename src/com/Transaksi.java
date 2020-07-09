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
public class Transaksi {
    private int id_transaksi, id_pelanggan, id_barang, id_pegawai, qty;

    public Transaksi(int id_transaksi, int id_pelanggan, int id_barang, int id_pegawai, int qty) {
        this.id_transaksi = id_transaksi;
        this.id_pelanggan = id_pelanggan;
        this.id_barang = id_barang;
        this.id_pegawai = id_pegawai;
        this.qty = qty;
    }

    public Transaksi(int id_pelanggan, int id_barang, int id_pegawai, int qty) {
        this.id_pelanggan = id_pelanggan;
        this.id_barang = id_barang;
        this.id_pegawai = id_pegawai;
        this.qty = qty;
    }

    public Transaksi(int id_transaksi, int id_pelanggan, int id_barang) {
        this.id_transaksi = id_transaksi;
        this.id_pelanggan = id_pelanggan;
        this.id_barang = id_barang;
    }

    public Transaksi() {
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return id_transaksi + ": " + id_pelanggan + "-" + id_barang;
    }
    
    
}
