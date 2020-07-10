/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import exec.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ALIK
 */
public class ConvertListToObject {
    public String[][] getPegawai(){
        List<Pegawai> myP = new ArrayList<Pegawai>();
        ExecutePegawai executePegawai = new ExecutePegawai();
        myP = executePegawai.getAllData();
        String[][] dataPegawai = new String[myP.size()][10];
        int i=0;
        for(Pegawai p : myP){
            dataPegawai[i][0]= ""+p.getId_pegawai();
            dataPegawai[i][1]= p.getUsername();
            dataPegawai[i][2]= p.getPassword();
            dataPegawai[i][3]= p.getNama();
            dataPegawai[i][4]= p.getNo_telpon();
            dataPegawai[i][5]= p.getAlamat();
            dataPegawai[i][6]= ""+p.getId_jabatan();
            dataPegawai[i][7]= p.getLevel();
            i++;
        }
        return dataPegawai;
    }

    public String[][] getPelanggan(){
        List<Pelanggan> myP = new ArrayList<Pelanggan>();
        ExecutePelanggan executePelanggan = new ExecutePelanggan();
        myP = executePelanggan.getAllData();
        String[][] dataPelanggan = new String[myP.size()][4];
        int i=0;
        for(Pelanggan p : myP){
            dataPelanggan[i][0]= ""+p.getId_pelanggan();
            dataPelanggan[i][1]= p.getNama();
            dataPelanggan[i][2]= p.getNo_telpon();
            dataPelanggan[i][3]= p.getAlamat();
            i++;
        }
        return dataPelanggan;
    }

    public String[][] getBarang(){
        List<Barang> myB = new ArrayList<Barang>();
        ExecuteBarang executeBarang = new ExecuteBarang();
        myB = executeBarang.getAllData();
        String[][] dataBarang = new String[myB.size()][8];
        int i=0;
        for(Barang b : myB){
            dataBarang[i][0]= ""+b.getId_barang();
            dataBarang[i][1]= b.getNama();
            dataBarang[i][2]= b.getKeterangan();
            dataBarang[i][3]= b.getGaransi();
            dataBarang[i][4]= ""+b.getStok();
            dataBarang[i][5]= ""+b.getHarga();
            dataBarang[i][6]= ""+b.getId_jenis();
            dataBarang[i][7]= ""+b.getId_merk();
            i++;
        }
        return dataBarang;
    }
    
    public String[][] getDaftarBarang(){
        List<Barang> myB = new ArrayList<Barang>();
        ExecuteBarang executeBarang = new ExecuteBarang();
        myB = executeBarang.getAllDataWithStock();
        String[][] dataBarang = new String[myB.size()][8];
        int i=0;
        for(Barang b : myB){
            dataBarang[i][0]= ""+b.getId_barang();
            dataBarang[i][1]= b.getNama();
            dataBarang[i][2]= b.getKeterangan();
            dataBarang[i][3]= b.getGaransi();
            dataBarang[i][4]= ""+b.getStok();
            dataBarang[i][5]= ""+b.getHarga();
            dataBarang[i][6]= ""+b.getId_jenis();
            dataBarang[i][7]= ""+b.getId_merk();
            i++;
        }
        return dataBarang;
    }

    public String[][] getTransaksi(){
        List<Transaksi> myS = new ArrayList<>();
        ExecuteTransaksi et = new ExecuteTransaksi();
        myS = et.getAllData();
        String[][] dataTransaksi = new String[myS.size()][5];
        int i=0;
        for(Transaksi t : myS){
            dataTransaksi[i][0]= ""+t.getId_transaksi();
            dataTransaksi[i][1]= ""+t.getId_pelanggan();
            dataTransaksi[i][2]= ""+t.getId_barang();
            dataTransaksi[i][3]= ""+t.getId_pegawai();
            dataTransaksi[i][4]= ""+t.getQty();
            i++;
        }
        return dataTransaksi;
    }

    public String[][] getJabatan(){
        List<Jabatan> myList = new ArrayList<>();
        ExecuteJabatan et = new ExecuteJabatan();
        myList = et.getAllData();
        String[][] dataJabatan = new String[myList.size()][5];
        int i=0;
        for(Jabatan j: myList){
            dataJabatan[i][0]= ""+j.getId_jabatan();
            dataJabatan[i][1]= j.getNama();
            i++;
        }
        return dataJabatan;
    }

    public String[][] getMerk(){
        List<Merk> myList = new ArrayList<>();
        ExecuteMerk et = new ExecuteMerk();
        myList = et.getAllData();
        String[][] dataMerk = new String[myList.size()][5];
        int i=0;
        for(Merk m: myList){
            dataMerk[i][0]= ""+m.getId_merk();
            dataMerk[i][1]= m.getNama();
            i++;
        }
        return dataMerk;
    }

    public String[][] getJenis(){
        List<Jenis> myList = new ArrayList<>();
        ExecuteJenis et = new ExecuteJenis();
        myList = et.getAllData();
        String[][] dataJenis = new String[myList.size()][5];
        int i=0;
        for(Jenis j: myList){
            dataJenis[i][0]= ""+j.getId_jenis();
            dataJenis[i][1]= j.getNama();
            dataJenis[i][2]= j.getKeterangan();
            i++;
        }
        return dataJenis;
    }
}
