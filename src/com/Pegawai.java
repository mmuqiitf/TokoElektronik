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
public class Pegawai {
    private int id_pegawai;
    private String username, password, nama, no_telpon, alamat, level;
    private int id_jabatan;
    private Jabatan jabatan;

    public Pegawai(int id_pegawai, String username, String password, String nama, String no_telpon, String alamat, String level, int id_jabatan, Jabatan jabatan) {
        this.id_pegawai = id_pegawai;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.no_telpon = no_telpon;
        this.alamat = alamat;
        this.level = level;
        this.id_jabatan = id_jabatan;
        this.jabatan = jabatan;
    }
    
    

    public Pegawai(int id_pegawai, String username, String password, String nama, String no_telpon, String alamat, String level, int id_jabatan) {
        this.id_pegawai = id_pegawai;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.no_telpon = no_telpon;
        this.alamat = alamat;
        this.level = level;
        this.id_jabatan = id_jabatan;
    }

    public Pegawai(String username, String password, String nama, String no_telpon, String alamat, String level, int id_jabatan) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.no_telpon = no_telpon;
        this.alamat = alamat;
        this.level = level;
        this.id_jabatan = id_jabatan;
    }

    public Pegawai(int id_pegawai, String nama) {
        this.id_pegawai = id_pegawai;
        this.nama = nama;
    }

    public Pegawai() {
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public String toString() {
        return id_pegawai + ": " + nama;
    }
    
    
}
