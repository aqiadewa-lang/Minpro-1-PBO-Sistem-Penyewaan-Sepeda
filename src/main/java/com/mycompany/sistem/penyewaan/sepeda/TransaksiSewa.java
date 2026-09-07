package com.mycompany.sistem.penyewaan.sepeda;

public class TransaksiSewa {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private Sepeda sepeda;
    private int lamaSewaHari;

    public TransaksiSewa(String idTransaksi, Pelanggan pelanggan, Sepeda sepeda, int lamaSewaHari) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.sepeda = sepeda;
        this.lamaSewaHari = lamaSewaHari;
    }

    public double hitungTotalBiaya() {
        return lamaSewaHari * sepeda.getHargaSewaPerHari();
    }

    public String getIdTransaksi() { return idTransaksi; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public Sepeda getSepeda() { return sepeda; }
    public int getLamaSewaHari() { return lamaSewaHari; }
}