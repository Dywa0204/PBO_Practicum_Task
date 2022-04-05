/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dywa Pratama
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int kategori, pilihan;
        String nama, asal;
        double nilai1, nilai2, nilai3, nilai4, nilaiAkhir = 0;
        
        System.out.println("Lomba Apresiasi Pahlawan Wanita Indonesia Oleh UPNVYK");
        System.out.println("Terdapat 2 kategori perlombaan");
        System.out.println("    1. Animasi (tim)");
        System.out.println("    2. Menulis Surat (Individu)");
        System.out.print("Pilih Kategoti Perlombaan : ");
        kategori = input.nextInt();
        input.nextLine();
        
        System.out.println("=== Form Pendaftaran ===");
        System.out.print("Input Nama    : ");
        nama = input.nextLine();
        System.out.print("Asal Sekolah  : ");
        asal = input.nextLine();
        
        PesertaLomba peserta =  new PesertaLomba(nama, asal, kategori);
        
        System.out.println("--- Form Penilaian ---");
        System.out.println("Keterangan : Nilai yang valid berada dintara 0 - 100\n");
        
        switch (kategori){
            case 1 :
                System.out.print("Input Nilai Alur Cerita: ");
                nilai1 = input.nextDouble();
                System.out.print("Input Nilai Konten: ");
                nilai2 = input.nextDouble();
                System.out.print("Input Nilai Kreativitas: ");
                nilai3 = input.nextDouble();
                System.out.print("Input Nilai Sinematografi: ");
                nilai4 = input.nextDouble();
                peserta.setNilaiAnimasi(nilai1, nilai2, nilai3, nilai4);
                nilaiAkhir = peserta.getNilaiAnimasi();
                break;
            case 2 :
                System.out.print("Input Nilai Struktur Surat: ");
                nilai1 = input.nextDouble();
                System.out.print("Input Nilai Isi Surat: ");
                nilai2 = input.nextDouble();
                System.out.print("Input Nilai Kreativitas: ");
                nilai3 = input.nextDouble();
                System.out.print("Input Nilai Penerapan Kaidah Bahasa: ");
                nilai4 = input.nextDouble();
                peserta.setNilaiSurat(nilai1, nilai2, nilai3, nilai4);
                nilaiAkhir = peserta.getNilaiSurat();
                break;
        }
        
        do {
            System.out.println("+++ MENU +++");
            System.out.println("\t1. Tampil");
            System.out.println("\t2. Edit");
            System.out.println("\t3. Exit");
            System.out.print("Pilih : ");
            pilihan = input.nextInt();
            switch (pilihan){
                case 1 :
                    System.out.println("\n   Nilai Akhir : " + nilaiAkhir);
                    System.out.print("   KETERANGAN : ");
                    if(nilaiAkhir >= 85) System.out.println("LOLOS");
                    else System.out.println("GAGAL");
                    break;
                case 2 :
                    break;
                case 3 :
                    System.exit(0);
                    break;
            }

        } while (true);
    }
}
