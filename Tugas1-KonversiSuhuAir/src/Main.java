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
        double celcius;
        int opsi;
        
        System.out.print(
            "+---------------------------+\n" +
            "| PROGRAM KONVERSI SUHU AIR |\n" +
            "+---------------------------+\n" +
            "Input Data\n" +
            "----------\n" +
            "Suhu Dalam Celcius : "
        );
        celcius = input.nextDouble();
        
        while(true){
            System.out.print(
                "\nOpsi\n" +
                "----\n" +
                "1. Lihat Data Konversi\n" +
                "2. Edit Data Konversi\n" +
                "3. Exit\n" +
                "Pilih : "
            );
            opsi = input.nextInt();
            switch(opsi){
                case 1:
                    Konversi convert = new Konversi(celcius);
                    System.out.println(
                        "\nSuhu Dalam Celcius : " + celcius +
                        "\nDalam Fahrenheit   : " + convert.toFahrenheit() +
                        "\nDalam Reamur       : " + convert.toReamur() +
                        "\nDalam Kelvin       : " + convert.toKelvin() +
                        "\nKondisi Air " + convert.waterCondition()
                    );
                    break;
                case 2:
                    System.out.print(
                        "\nInput Data\n" +
                        "----------\n" +
                        "Suhu Dalam Celcius : "
                    );
                    celcius = input.nextDouble();
                    break;
                case 3 :
                    return;
                default :
                    System.out.println("Opsi tidak ada. Mohon masukkan opsi dengan benar");
            }
        }
    }
}
