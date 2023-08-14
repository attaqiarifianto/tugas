package TokoOnline;

import java.util.*;

class TokoOnline {
    List<Pengguna> daftarPengguna;
    List<Produk> daftarProduk;

    public TokoOnline() {
        daftarPengguna = new ArrayList<>();
        daftarProduk = new ArrayList<>();
    }

    public void run() {
        daftarPengguna("user1", "password1", 100);
        daftarPengguna("user2", "password2", 200);
        daftarPengguna("user3", "password3", 400);
        tambahProduk("Laptop", 800);
        tambahProduk("Ponsel", 400);
        tambahProduk("Headphone", 50);
        tambahProduk("Monitor", 200);
        tambahProduk("Mouse", 40);
        tambahProduk("Tablet", 500);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di toko online!");

        while (true) {
            System.out.print("Nama Pengguna: ");
            String username = scanner.nextLine();
            System.out.print("Kata Sandi: ");
            String password = scanner.nextLine();

            Pengguna penggunaMasuk = null;

            for (Pengguna pengguna : daftarPengguna) {
                if (pengguna.username.equals(username) && pengguna.password.equals(password)) {
                    penggunaMasuk = pengguna;
                    break;
                }
            }

            if (penggunaMasuk != null) {
                System.out.println("Login berhasil!\n");
                System.out.println("Saldo Anda: Rp" + penggunaMasuk.saldo);

                while (true) {
                    System.out.println("\n1. Tampilkan Produk");
                    System.out.println("2. Tambah ke Keranjang");
                    System.out.println("3. Lihat Keranjang");
                    System.out.println("4. Tampilkan Saldo");
                    System.out.println("5. Isi Saldo");
                    System.out.println("6. Checkout");
                    System.out.println("7. Keluar");
                    System.out.print("Pilih opsi: ");
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilihan) {
                        case 1:
                            tampilkanProduk();
                            break;
                        case 2:
                            tampilkanProduk();
                            System.out.print("Pilih produk untuk ditambahkan ke keranjang: ");
                            int indeksProduk = scanner.nextInt() - 1;
                            System.out.print("Jumlah produk yang ingin dibeli: ");
                            int jumlahProduk = scanner.nextInt();
                            scanner.nextLine();
                            tambahKeKeranjang(penggunaMasuk, daftarProduk.get(indeksProduk), jumlahProduk);
                            break;
                        case 3:
                            tampilkanKeranjang(penggunaMasuk);
                            break;
                        case 4:
                            tampilkanSaldo(penggunaMasuk);
                            break;
                        case 5:
                            isiSaldo(penggunaMasuk);
                            break;
                        case 6:
                            checkout(penggunaMasuk);
                            break;
                        case 7:
                            System.out.println("Keluar.");
                            break;
                        default:
                            System.out.println("Opsi tidak valid. Silakan coba lagi.");
                            break;
                    }

                    if (pilihan == 7) {
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

    public void daftarPengguna(String username, String password, int saldo) {
        daftarPengguna.add(new Pengguna(username, password, saldo));
    }

    public void tambahProduk(String nama, int harga) {
        daftarProduk.add(new Produk(nama, harga));
    }

    public void tampilkanProduk() {
        System.out.println("Produk Tersedia:");
        for (int i = 0; i < daftarProduk.size(); i++) {
            Produk produk = daftarProduk.get(i);
            System.out.println(i + 1 + ". " + produk.nama + " - Rp" + produk.harga);
        }
    }

    public void tambahKeKeranjang(Pengguna pengguna, Produk produk, int jumlah) {
        for (int i = 0; i < jumlah; i++) {
            pengguna.keranjang.add(produk);
        }
        System.out.println("Produk ditambahkan ke keranjang.");
    }

    public void tampilkanKeranjang(Pengguna pengguna) {
        System.out.println("Keranjang Anda:");
        for (Produk produk : pengguna.keranjang) {
            System.out.println(produk.nama + " - Rp" + produk.harga);
        }
        System.out.println("Total: Rp" + hitungTotal(pengguna));
    }

    public void tampilkanSaldo(Pengguna pengguna) {
        System.out.println("Saldo Anda: Rp" + pengguna.saldo);
    }

    public void isiSaldo(Pengguna pengguna) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Jumlah saldo yang ingin diisi: ");
        int saldoTambah = scanner.nextInt();
        scanner.nextLine();

        if (saldoTambah > 0) {
            pengguna.saldo += saldoTambah;
            System.out.println("Saldo berhasil diisi. Saldo Anda sekarang: Rp" + pengguna.saldo);
        } else {
            System.out.println("Jumlah saldo tidak valid.");
        }
        scanner.close();
    }

    public void checkout(Pengguna pengguna) {
        int total = hitungTotal(pengguna);
        System.out.println("Total: Rp" + total);

        if (pengguna.saldo >= total) {
            System.out.println("Terima kasih telah berbelanja!");
            pengguna.keranjang.clear();
            pengguna.saldo -= total;
        } else {
            System.out.println("Saldo tidak mencukupi. Silakan isi saldo Anda.");
        }
    }

    public int hitungTotal(Pengguna pengguna) {
        int total = 0;
        for (Produk produk : pengguna.keranjang) {
            total += produk.harga;
        }
        return total;
    }
}