package com.mycompany.sistem.penyewaan.sepeda;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemPenyewaanSepeda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sepeda> daftarSepeda = new ArrayList<>();
        ArrayList<TransaksiSewa> daftarTransaksi = new ArrayList<>();

        daftarSepeda.add(new Sepeda("S01", "Polygon", "Mountain Bike", 50000));
        daftarSepeda.add(new Sepeda("S02", "United", "Fixie", 35000));

        int pilihan = 0;

        do {
            System.out.println("\n=== SISTEM PENYEWAAN SEPEDA ===");
            System.out.println("1. Tampilkan Daftar Sepeda");
            System.out.println("2. Tambah Data Sepeda");
            System.out.println("3. Ubah Data Sepeda");
            System.out.println("4. Hapus Data Sepeda");
            System.out.println("5. Transaksi Penyewaan");
            System.out.println("6. Tampilkan Riwayat Transaksi");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu (1-7): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR SEPEDA ---");
                    if (daftarSepeda.isEmpty()) {
                        System.out.println("Belum ada data sepeda.");
                    } else {
                        for (Sepeda s : daftarSepeda) {
                            System.out.println("ID: " + s.getIdSepeda() + 
                                               " | Merk: " + s.getMerk() + 
                                               " | Jenis: " + s.getJenis() + 
                                               " | Harga/Hari: Rp" + s.getHargaSewaPerHari());
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- TAMBAH SEPEDA BARU ---");
                    System.out.print("Masukkan ID Sepeda: ");
                    String idBaru = scanner.nextLine();
                    System.out.print("Masukkan Merk: ");
                    String merkBaru = scanner.nextLine();
                    System.out.print("Masukkan Jenis: ");
                    String jenisBaru = scanner.nextLine();
                    System.out.print("Masukkan Harga Sewa/Hari: ");
                    double hargaBaru = scanner.nextDouble();

                    daftarSepeda.add(new Sepeda(idBaru, merkBaru, jenisBaru, hargaBaru));
                    System.out.println("Data sepeda berhasil ditambahkan!");
                    break;

                case 3:
                    System.out.println("\n--- UBAH DATA SEPEDA ---");
                    System.out.print("Masukkan ID Sepeda yang ingin diubah: ");
                    String idCariUpdate = scanner.nextLine();
                    boolean ditemukanUpdate = false;

                    for (Sepeda s : daftarSepeda) {
                        if (s.getIdSepeda().equalsIgnoreCase(idCariUpdate)) {
                            System.out.print("Masukkan Merk Baru: ");
                            s.setMerk(scanner.nextLine());
                            System.out.print("Masukkan Jenis Baru: ");
                            s.setJenis(scanner.nextLine());
                            System.out.print("Masukkan Harga Sewa Baru: ");
                            s.setHargaSewaPerHari(scanner.nextDouble());
                            ditemukanUpdate = true;
                            System.out.println("Data sepeda berhasil diperbarui!");
                            break;
                        }
                    }
                    if (!ditemukanUpdate) {
                        System.out.println("ID Sepeda tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- HAPUS DATA SEPEDA ---");
                    System.out.print("Masukkan ID Sepeda yang ingin dihapus: ");
                    String idCariHapus = scanner.nextLine();
                    boolean ditemukanHapus = false;

                    for (int i = 0; i < daftarSepeda.size(); i++) {
                        if (daftarSepeda.get(i).getIdSepeda().equalsIgnoreCase(idCariHapus)) {
                            daftarSepeda.remove(i);
                            ditemukanHapus = true;
                            System.out.println("Sepeda berhasil dihapus!");
                            break;
                        }
                    }
                    if (!ditemukanHapus) {
                        System.out.println("ID Sepeda tidak ditemukan.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- TRANSAKSI PENYEWAAN ---");
                    if (daftarSepeda.isEmpty()) {
                        System.out.println("Tidak ada sepeda yang tersedia.");
                        break;
                    }
                    System.out.print("Masukkan ID Transaksi: ");
                    String idTrx = scanner.nextLine();
                    System.out.print("Masukkan ID Pelanggan: ");
                    String idPel = scanner.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String namaPel = scanner.nextLine();
                    System.out.print("Masukkan No HP Pelanggan: ");
                    String noHpPel = scanner.nextLine();

                    Pelanggan pel = new Pelanggan(idPel, namaPel, noHpPel);

                    System.out.print("Masukkan ID Sepeda yang disewa: ");
                    String idSepedaSewa = scanner.nextLine();
                    Sepeda sepedaDipilih = null;

                    for (Sepeda s : daftarSepeda) {
                        if (s.getIdSepeda().equalsIgnoreCase(idSepedaSewa)) {
                            sepedaDipilih = s;
                            break;
                        }
                    }

                    if (sepedaDipilih != null) {
                        System.out.print("Masukkan Lama Sewa (Hari): ");
                        int lama = scanner.nextInt();
                        TransaksiSewa trx = new TransaksiSewa(idTrx, pel, sepedaDipilih, lama);
                        daftarTransaksi.add(trx);
                        System.out.println("Transaksi berhasil dicatat! Total Biaya: Rp" + trx.hitungTotalBiaya());
                    } else {
                        System.out.println("Sepeda tidak ditemukan.");
                    }
                    break;

                case 6:
                    System.out.println("\n--- RIWAYAT TRANSAKSI ---");
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Belum ada transaksi.");
                    } else {
                        for (TransaksiSewa t : daftarTransaksi) {
                            System.out.println("ID Trx: " + t.getIdTransaksi() + 
                                               " | Penyewa: " + t.getPelanggan().getNama() + 
                                               " | Sepeda: " + t.getSepeda().getMerk() + 
                                               " | Lama: " + t.getLamaSewaHari() + " Hari" +
                                               " | Total: Rp" + t.hitungTotalBiaya());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Terima kasih, program selesai!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 7);

        scanner.close();
    }
}
