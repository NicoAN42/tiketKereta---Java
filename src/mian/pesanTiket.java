/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mian;

import java.io.*;
/**
 *
 * @author Acer
 */
public class pesanTiket {

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader getRead = new BufferedReader(input);

    String nama[] = new String[255];
    String nomorHp[] = new String[255];
    int pnomorId[] = new int[255];
    int umur[] = new int[255];
    int tiket[] = new int[255];
    int pCount = 0;
    int pId = 1;
    int maxEx = 80;
    int maxBis = 150;
    int maxEco = 250;

    public static void main(String[] args) throws Exception {
        pesanTiket temp = new pesanTiket();
        temp.mainMenu();
    }

    private void mainMenu() throws Exception {
        int pilih = 0;
        do {
            System.out.println(" ");
            viewTitle();
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Pembatalan Tiket");
            System.out.println("3. Cari data Penumpang");
            System.out.println("4. Daftar Pemesanan");
            System.out.println("5. Daftar Tiket Sisa");
            System.out.println("6. Exit");
            System.out.println(" ");
            System.out.print("Pilih Menu [1-6]: ");
            pilih = Integer.parseInt(getRead.readLine());

            switch (pilih) {
                case 1: {
                    menuPesan();
                    break;
                }
                case 2: {
                    menuBatal();
                    break;
                }
                case 3: {
                    menuCari();
                    break;
                }
                case 4: {
                    menuPemesan();
                    break;
                }
                case 5: {
                    menuTiket();
                    break;
                }
                case 6: {
                    doExit();
                    break;
                }
                default:
                    System.out.println("Cek kembali pilihan Anda");
            }
            char reset = (char) getRead.read();

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } while (pilih != 6);
    }

    private void viewTitle() throws Exception {
        System.out.println("--------------------------------------");
        System.out.println("------- Pemesanan Tiket Kereta -------");
        System.out.println("--------------------------------------");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void menuPesan() throws Exception {
        System.out.println("Pilih Tipe Tiket");
        System.out.println("1. Eksekutif || 2. Bisnis || 3. Ekonomi");
        System.out.print(">> ");
        int tipe = Integer.parseInt(getRead.readLine());
        System.out.println("Input Jumlah Tiket");
        System.out.print(">> ");
        int nominal = Integer.parseInt(getRead.readLine());

        int tiketTersedia = 0;
        if (tipe == 1 && maxEx >= nominal) {
            tiketTersedia = 1;
        }
        if (tipe == 2 && maxBis >= nominal) {
            tiketTersedia = 1;
        }
        if (tipe == 3 && maxEco >= nominal) {
            tiketTersedia = 1;
        }

        if (tiketTersedia == 1) {
            for (int i = 0; i < nominal; i++) {
                pnomorId[pCount] = pId;
                System.out.println("Input Nama Anda");
                System.out.print(">> ");
                nama[pCount] = getRead.readLine();
                System.out.println("Input Umur Anda");
                System.out.print(">> ");
                umur[pCount] = Integer.parseInt(getRead.readLine());
                tiket[pCount] = tipe;
                System.out.println("Input Nomor Hp Anda");
                System.out.print(">> ");
                nomorHp[pCount] = getRead.readLine();
                pCount++;
                pId++;

                System.out.println(" ");
                System.out.println("Ticket Successfully Booked");

            }
            if (tipe == 1) {
                maxEx -= nominal;
                System.out.println("Harga Tiket Rp." + nominal * 2500);
            }
            if (tipe == 2) {
                maxBis -= nominal;
                System.out.println("Harga Tiket Rp." + nominal * 1500);
            }
            if (tipe == 3) {
                maxEco -= nominal;
                System.out.println("Harga Tiket Rp." + nominal * 1000);
            }
        }
        System.out.println(" ");
        System.out.println("--Press Enter to Back--");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void menuBatal() throws Exception {
        String temp_nama[] = new String[255];
        String temp_nomorHp[] = new String[255];
        int temp_pnomorId[] = new int[255];
        int temp_umur[] = new int[255];
        int temp_tiket[] = new int[255];
        int temp_pCount = 0;
        int pValid = 0;

        System.out.println("Input Nomor Id Pelanggan");
        System.out.print(">> ");

        int searchId = Integer.parseInt(getRead.readLine());
        for (int i = 0; i < pCount; i++) {
            if (pnomorId[i] != searchId) {
                temp_pnomorId[temp_pCount] = pnomorId[i];
                temp_nama[temp_pCount] = nama[i];
                temp_nomorHp[temp_pCount] = nomorHp[i];
                temp_umur[temp_pCount] = umur[i];
                temp_tiket[temp_pCount] = tiket[i];
                temp_pCount++;
            } else {
                pValid = 1;
                if (tiket[i] == 1) {
                    maxEx++;

                    System.out.println("Total Refund Rp." + 2500);
                }
                if (tiket[i] == 2) {
                    maxBis++;

                    System.out.println("Total Refund Rp." + 1500);
                }
                if (tiket[i] == 3) {
                    maxEco++;

                    System.out.println("Total Refund Rp." + 1000);
                }
            }
            System.out.println(" ");
            System.out.println("--Press Enter to Back--");
        }
        if (pValid == 1) {
            pnomorId = temp_pnomorId;
            nama = temp_nama;
            nomorHp = temp_nomorHp;
            umur = temp_umur;
            tiket = temp_tiket;
            pCount = temp_pCount;
            System.out.println("Ticket Successfully Cancelled");
            System.out.println(" ");
            System.out.println("--Press Enter to Back--");
        }

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void menuCari() throws Exception {
        int pValid = 0;
        System.out.println("Cari Nomor Id Pelanggan");
        System.out.print(">> ");
        int searchId = Integer.parseInt(getRead.readLine());

        for (int i = 0; i < pCount; i++) {
            if (pnomorId[i] == searchId) {
                System.out.println("Data Found");
                pValid = 1;
                System.out.println("No Id. = " + pnomorId[i]);
                System.out.println("Nama          = " + nama[i]);
                System.out.println("Tiket Clas    = " + tiket[i]);
                System.out.println("Nomor Hp      = " + nomorHp[i]);
                System.out.println("Umur          = " + umur[i]);
            }
        }
        if (pValid == 0) {
            System.out.println("No Data Available");
        }
        System.out.println(" ");
        System.out.println("--Press Enter to Back--");

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void menuPemesan() throws Exception {
        System.out.println("-------- Data Transaksi --------");
        System.out.println(" ");

        System.out.println("Data Penumpang Class Eksekutif");
        System.out.println("Nomor Id \t Nama \t\t Umur \t Nomor Hp");
        for (int i = 0; i < pCount; i++) {
            if (tiket[i] == 1) {
                System.out.println(pnomorId[i] + "\t\t " + nama[i] + "\t\t " + umur[i] + "\t " + nomorHp[i]);
            }
        }

        System.out.println("--------------------------------");

        System.out.println("Data Penumpang Class Bisnis");
        System.out.println("Nomor Id \t Nama \t\t Umur \t Nomor Hp");
        for (int i = 0; i < pCount; i++) {
            if (tiket[i] == 2) {
                System.out.println(pnomorId[i] + "\t\t " + nama[i] + "\t\t " + umur[i] + "\t " + nomorHp[i]);
            }
        }

        System.out.println("--------------------------------");

        System.out.println("Data Penumpang Class Ekonomi");
        System.out.println("Nomor Id \t Nama \t\t Umur \t Nomor Hp");
        for (int i = 0; i < pCount; i++) {
            if (tiket[i] == 3) {
                System.out.println(pnomorId[i] + "\t\t " + nama[i] + "\t\t " + umur[i] + "\t " + nomorHp[i]);
            }
        }

        System.out.println(" ");
        System.out.println("--Press Enter to Back--");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void menuTiket() throws Exception {
        System.out.println("Status Jumlah Tiket");
        System.out.println("Class Eksekutif  : " + maxEx);
        System.out.println("Class Bisnis     : " + maxBis);
        System.out.println("Class Ekonomi    : " + maxEco);
        System.out.println(" ");
        System.out.println("--Press Enter to Back--");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doExit() {
        System.out.println("Thank You!");
    }
;

}
