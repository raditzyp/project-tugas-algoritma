// =============================================== IMPORT CLASS YANG DIBUTUHKAN =============================================== //
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class RamenShibuya {
    public static void main(String args[]) {

        // =================================== INISIALISASI OBJEK UNTUK MASING-MASING KELAS =================================== //
        Scanner input = new Scanner(System.in);
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        // ================================================ DEKLARASI VARIABEL ================================================ //
        int jum = 0, i = 0;
        double total_bayar = 0;
        String kodeVoucher;
        double potonganHarga = 0;

        // ================================================== DEKLARASI ARRAY ================================================== //
        int[] kode = new int[6];
        int[] qty = new int[6];
        int[] harga = new int[6];
        double[] sub_total = new double[6];
        String[] menu = new String[6];

        System.out.println(" ");
        System.out.println("+====================+ Selamat Datang di Ramen Shibuya +====================+");
        System.out.println(" ");
        System.out.print("Masukan jumlah Menu yang ingin dibeli : ");
        jum = input.nextInt();
        System.out.println(" ");
        {
            String tbl = "| %-15s | %-4d |%n";
        System.out.format("+-----+-----------------+--------------+%n");
        System.out.format("| ID  | Menu            | Harga        |%n");
        System.out.format("+-----+-----------------+--------------+%n");
        System.out.format("| 1   | Ramen           | 50.000       |%n");
        System.out.format("+-----+-----------------+--------------+%n");
        System.out.format("| 2   | Sushi           | 90.000       |%n");
        System.out.format("+-----+-----------------+--------------+%n");
        System.out.format("| 3   | Matcha          | 30.000       |%n");
        System.out.format("+-----+-----------------+--------------+%n");
        System.out.format("| 4   | Sake            | 10.000       |%n");
        System.out.format("+-----+-----------------+--------------+%n");
        System.out.format("| 5   | Yakitori        | 22.000       |%n");
        System.out.format("+-----+-----------------+--------------+%n");
        System.out.format("| 6   | Dorayaki        | 10.500       |%n");
        System.out.format("+-----+-----------------+--------------+%n");
        System.out.println(" ");
        }

        // ======================================================= VOUCHER ======================================================= //
        System.out.println(" ");
        System.out.print("Apakah Anda Mempunyai Voucher (y/t) : ");
        kodeVoucher = input.next();

        // ================================================== CEK KODE VOUCHER ================================================== //
        if (kodeVoucher.equals("y")) {
            potonganHarga = 0.1; // 10% potongan harga
            System.out.println("Anda mendapatkan potongan sebesar 10%");
            System.out.println(" ");
        } else if (kodeVoucher.equals("t")) {
            potonganHarga = 0; // potongan sebesar 50.000
            System.out.println("Maaf Anda tidak mendapatkan potongan ");
            System.out.println(" ");
        } else {
            System.out.println("Maaf Voucher Anda sudah Expired.");
            System.out.println(" ");
        }

        // =========================================== MEMASUKAN ELEMEN DI DALAM ARRAY =========================================== //
        for (i = 0; i < jum; i++) {
            boolean valid = false;
            while (!valid) {
                System.out.print("Masukan ID Menu Ke-" + (i + 1) + "      : ");
                kode[i] = input.nextInt();
                if (kode[i] < 1 || kode[i] > 6) {
                    System.out.println("ID Barang Tidak Tersedia, Silahkan Masukkan ID Yang Tersedia");
                    System.out.println(" ");
                } else {
                    valid = true;
                }
            }
            System.out.print("Masukan Quantity Ke-" + (i + 1) + "     : ");
            qty[i] = input.nextInt();
            System.out.println(" ");

        // ================================ MENENTUKAN BARANG BERDASARKAN KODE YANG DI MASUKKAN ================================ //
            switch (kode[i]) {
                case 1:
                    menu[i] = "Ramen                ";
                    harga[i] = 50000;
                    break;

                case 2:
                    menu[i] = "Sushi                ";
                    harga[i] = 90000;
                    break;

                case 3:
                    menu[i] = "Matcha               ";
                    harga[i] = 30000;
                    break;

                case 4:
                    menu[i] = "Sake                 ";
                    harga[i] = 10000;
                    break;

                case 5:
                    menu[i] = "Yakitori             ";
                    harga[i] = 22000;
                    break;

                case 6:
                    menu[i] = "Dorayaki             ";
                    harga[i] = 10500;
                    break;

                default:
                    System.out.println("ID Barang Tidak Tersedia");
            }
        }

        // ============================================= PENGATURAN FORMAT NUMBER ============================================= //
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);    

        System.out.println(" ");
        System.out.println("+--------------------------+ P R O S E S +------------------------------+");
        System.out.println("+-----+------------------------+----------------+-----+-----------------+");
        System.out.println("| No  | Menu                   | Harga          | QTY | Sub Total       |");
        System.out.println("+-----+------------------------+----------------+-----+-----------------+");

        // ==================================== MENAMPILKAN SELURUH ELEMEN DI DALAM ARRAY ==================================== //
        for (i = 0; i < jum; i++) {
            sub_total[i] = qty[i] * harga[i];
            total_bayar += sub_total[i];
            total_bayar-= (qty[i]*harga[i]*potonganHarga);
            System.out.println("  "+(i + 1)+"     " + menu[i] + "    " + kursIndonesia.format(harga[i]) + "     " + qty[i] + "    " + kursIndonesia.format(sub_total[i]));
        }
        System.out.println("+-----------------------------------------------------------------------+");

        // ============================================= MENAMPILKAN TOTAL BAYAR ============================================= //
        System.out.println("Total Bayar : " + kursIndonesia.format(total_bayar));
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("+=======================+ TERIMAKASIH SUDAH DATANG +=======================+");
        System.out.println("+=========================+ SEMOGA ANDA SENANG <3 +========================+");
    }
}
