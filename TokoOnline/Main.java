package TokoOnline;

import java.util.*;

class TokoOnline {
    List<Pengguna> pengguna;
    List<Produk> produk;

    public TokoOnline() {
        pengguna = new ArrayList<>();
        produk = new ArrayList<>();
    }

    public void daftarPengguna(String username, String password) {
        pengguna.add(new Pengguna(username, password));
    }

    public boolean masukPengguna(String username, String password) {
        for (Pengguna pengguna : pengguna) {
            if (pengguna.username.equals(username) && pengguna.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void tambahProduk(String nama, int harga) {
        produk.add(new Produk(nama, harga));
    }

    public void tampilkanProduk() {
        System.out.println("Produk Tersedia:");
        for (int i = 0; i < produk.size(); i++) {
            Produk produk = this.produk.get(i);
            System.out.println(i + 1 + ". " + produk.nama + " - Rp" + produk.harga);
        }
    }

    public static void main(String[] args) {
        TokoOnline sistem = new TokoOnline();

        sistem.daftarPengguna("fadhil", "fadhil9090");
        sistem.tambahProduk("Laptop", 8_000_000);
        sistem.tambahProduk("Ponsel", 4_000_000);
        sistem.tambahProduk("Headphone", 500_000);
        sistem.tambahProduk("Monitor", 2_000_000);
        sistem.tambahProduk("Mouse", 400_000);
        sistem.tambahProduk("Tablet", 5_000_000);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di toko online!");

        while (true) {
            System.out.print("Nama Pengguna: ");
            String username = scanner.nextLine();
            System.out.print("Kata Sandi: ");
            String password = scanner.nextLine();

            if (sistem.masukPengguna(username, password)) {
                System.out.println("Login berhasil!");
                Pengguna pengguna = null;

                for (Pengguna user : sistem.pengguna) {
                    if (user.username.equals(username)) {
                        pengguna = user;
                        break;
                    }
                }

                while (true) {
                    System.out.println("\n1. Tampilkan Produk");
                    System.out.println("2. Tambah ke Keranjang");
                    System.out.println("3. Lihat Keranjang");
                    System.out.println("4. Checkout");
                    System.out.println("5. Keluar");
                    System.out.print("Pilih opsi: ");
                    int pilihan = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline

                    switch (pilihan) {
                        case 1:
                            sistem.tampilkanProduk();
                            break;
                        case 2:
                            sistem.tampilkanProduk();
                            System.out.print("Pilih produk untuk ditambahkan ke keranjang: ");
                            int indeksProduk = scanner.nextInt() - 1;
                            System.out.print("Jumlah produk yang ingin dibeli: ");
                            int jumlahProduk = scanner.nextInt();
                            pengguna.tambahKeKeranjang(sistem.produk.get(indeksProduk), jumlahProduk);
                            System.out.println("Produk ditambahkan ke keranjang.");
                            break;
                        case 3:
                            System.out.println("Keranjang Anda:");
                            for (Produk produk : pengguna.keranjang) {
                                System.out.println(produk.nama + " - Rp" + produk.harga);
                            }
                            System.out.println("Total: Rp" + pengguna.hitungTotal());
                            break;
                        case 4:
                            System.out.println("Total: Rp" + pengguna.hitungTotal());
                            System.out.println("Terima kasih telah berbelanja!");
                            pengguna.keranjang.clear();
                            break;
                        case 5:
                            System.out.println("Keluar.");
                            break;
                        default:
                            System.out.println("Opsi tidak valid. Silakan coba lagi.");
                            break;
                    }

                    if (pilihan == 5) {
                        break;
                    }
                }

                break;
            } else {
                System.out.println("Nama pengguna atau kata sandi tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}