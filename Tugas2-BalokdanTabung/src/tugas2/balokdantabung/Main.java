/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2.balokdantabung;

/**
 *
 * @author Dywa Pratama
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int select, repeat;
        double p, l, t, r;
        
        do{
            System.out.print(
                "==========\n" +
                "MENU UTAMA\n" +
                "==========\n" +
                "1. Hitung Balok\n" +
                "2. Hitung Tabung\n" +
                "0. Exit\n" +
                "Pilih : "
            );
            select = input.nextInt();

            switch(select){
                case 1 :
                    System.out.print("\nInput Panjang : ");
                    p = input.nextInt();
                    System.out.print("Input Lebar   : ");
                    l = input.nextInt();
                    System.out.print("Input Tinggi  : ");
                    t = input.nextInt();

                    Balok balok = new Balok(p, l, t);

                    System.out.println(
                        "\nLuas Persegi Panjang      : " + balok.cariLuas() +
                        "\nKeliling Persegi Panjang  : " + balok.cariKeliling() +
                        "\nVolume Balok              : " + balok.cariVolume() +
                        "\nLuas Permukaan Balok      : " + balok.cariLuasPermukaan()
                    );
                break;
                case 2 :
                    System.out.print("\nInput Tinggi      : ");
                    t = input.nextInt();
                    System.out.print("Input Jari-Jari   : ");
                    r = input.nextInt();

                    Tabung tabung = new Tabung(r, t);

                    System.out.println(
                        "\nLuas Lingkaran        : " + tabung.cariLuas() +
                        "\nKeliling Lingkaran    : " + tabung.cariKeliling() +
                        "\nVolume Tabung         : " + tabung.cariVolume() +
                        "\nLuas Permukaan Tabung : " + tabung.cariLuasPermukaan()
                    );
                break;
                case 3 :
                    return;
            }
            System.out.print("\nUlangi? (Ya = 1 || Tidak = 0) : ");
            repeat = input.nextInt();
            System.out.println("\n");
            
        }while(repeat == 1);
    }
    
}
