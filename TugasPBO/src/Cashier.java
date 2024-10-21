import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double p, String c, String n, int q) {
        items.add(new Item(c, n, p, q));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void displayTransaction() {
        double total = 0.0;
        System.out.println("----------------------------------");
        System.out.println("Daftar Transaksi:");
        for (Item item : items) {
            double subtotal = item.getPrice() * item.getQuantity();
            System.out.println("Kode Barang: " + item.getCode());
            System.out.println("Nama Barang: " + item.getName());
            System.out.println("Harga Barang: " + item.getPrice());
            System.out.println("Jumlah Pembelian: " + item.getQuantity());
            System.out.println("Subtotal: " + subtotal);
            System.out.println();
            total += subtotal;
        }
        System.out.println("Total Harga: " + total);
        System.out.println("----------------------------------");
    }

    public void pay() {
        double total = 0.0;
        for (Item item : items) {
            double subtotal = item.getPrice() * item.getQuantity();
            total += subtotal;
        }
        System.out.println("----------------------------------");
        System.out.print("Masukkan jumlah pembayaran: ");
        double payment = new Scanner(System.in).nextDouble();
        if (payment < total) {
            System.out.println("Pembayaran tidak cukup.");
        } else {
            double change = payment - total;
            System.out.println("Kembalian: " + change);
            System.out.println("----------------------------------");
            items.clear();
        }
    }
}