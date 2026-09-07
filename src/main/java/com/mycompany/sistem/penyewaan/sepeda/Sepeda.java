package com.mycompany.sistem.penyewaan.sepeda;

public class Sepeda {
    private String idSepeda;
    private String merk;
    private String jenis;
    private double hargaSewaPerHari;

    public Sepeda(String idSepeda, String merk, String jenis, double hargaSewaPerHari) {
        this.idSepeda = idSepeda;
        this.merk = merk;
        this.jenis = jenis;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public String getIdSepeda() { return idSepeda; }
    public void setIdSepeda(String idSepeda) { this.idSepeda = idSepeda; }

    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public double getHargaSewaPerHari() { return hargaSewaPerHari; }
    public void setHargaSewaPerHari(double hargaSewaPerHari) { this.hargaSewaPerHari = hargaSewaPerHari; }
}