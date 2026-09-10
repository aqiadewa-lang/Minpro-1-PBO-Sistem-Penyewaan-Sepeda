package com.mycompany.sistem.penyewaan.sepeda;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sepeda> daftarSepeda = new ArrayList<>();

        // Data bawaan untuk tes
        daftarSepeda.add(new Sepeda("S01", "Polygon", "Mountain Bike", 50000));
        daftarSepeda.add(new Sepeda("S02", "United", "Fixie", 35000));

        int pilihan = 0;

        do {
            System.out.println("\n=== MANAJEMEN DATA SEPEDA ===");
            System.out.println("1. Tampilkan Sepeda (Read)");
            System.out.println("2. Tambah Sepeda (Create)");
            System.out.println("3. Ubah Data Sepeda (Update)");
            System.out.println("4. Hapus Sepeda (Delete)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input salah, masukkan angka 1-5.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR SEPEDA ---");
                    if (daftarSepeda.isEmpty()) {
                        System.out.println("Belum ada data sepeda.");
                    } else {
                        for (Sepeda s : daftarSepeda) {
                            System.out.println("[" + s.getIdSepeda() + "] " + s.getMerk() + " - " + s.getJenis() + " (Rp " + s.getHargaSewaPerHari() + "/hari)");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- TAMBAH SEPEDA ---");
                    System.out.print("ID Sepeda: ");
                    String idBaru = scanner.nextLine();
                    System.out.print("Merk: ");
                    String merkBaru = scanner.nextLine();
                    System.out.print("Jenis: ");
                    String jenisBaru = scanner.nextLine();
                    
                    double hargaBaru = 0;
                    while (true) {
                        try {
                            System.out.print("Harga Sewa/Hari: Rp ");
                            hargaBaru = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ketik angkanya saja!");
                        }
                    }

                    daftarSepeda.add(new Sepeda(idBaru, merkBaru, jenisBaru, hargaBaru));
                    System.out.println("Data sepeda berhasil ditambahkan.");
                    break;

                case 3:
                    System.out.println("\n--- UBAH SEPEDA ---");
                    System.out.print("Masukkan ID Sepeda: ");
                    String idEdit = scanner.nextLine();
                    boolean adaEdit = false;

                    for (Sepeda s : daftarSepeda) {
                        if (s.getIdSepeda().equalsIgnoreCase(idEdit)) {
                            System.out.print("Merk Baru: ");
                            s.setMerk(scanner.nextLine());
                            System.out.print("Jenis Baru: ");
                            s.setJenis(scanner.nextLine());
                            
                            while (true) {
                                try {
                                    System.out.print("Harga Baru: Rp ");
                                    s.setHargaSewaPerHari(Double.parseDouble(scanner.nextLine()));
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Ketik angkanya saja!");
                                }
                            }
                            adaEdit = true;
                            System.out.println("Data sepeda berhasil diperbarui.");
                            break;
                        }
                    }
                    if (!adaEdit) {
                        System.out.println("ID Sepeda tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- HAPUS SEPEDA ---");
                    System.out.print("Masukkan ID Sepeda: ");
                    String idHapus = scanner.nextLine();
                    boolean adaHapus = false;

                    for (int i = 0; i < daftarSepeda.size(); i++) {
                        if (daftarSepeda.get(i).getIdSepeda().equalsIgnoreCase(idHapus)) {
                            daftarSepeda.remove(i);
                            adaHapus = true;
                            System.out.println("Data sepeda berhasil dihapus.");
                            break;
                        }
                    }
                    if (!adaHapus) {
                        System.out.println("ID Sepeda tidak ditemukan.");
                    }
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak ada, pilih 1-5.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}