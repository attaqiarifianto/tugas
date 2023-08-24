package TokoOnlineJava;

import java.util.*;

class TokoOnline {
    private List<Pengguna> daftarPengguna;
    private List<Produk> daftarProduk;
    private Scanner scanner;

    public TokoOnline() {
        daftarPengguna = new ArrayList<>();
        daftarProduk = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        inisialisasiDataAwal();

        System.out.println("Selamat datang di toko online!");

        while (true) {
            System.out.print("Nama Pengguna: ");
            String username = scanner.nextLine();
            System.out.print("Kata Sandi: ");
            String password = scanner.nextLine();

            Pengguna penggunaMasuk = login(username, password);

            if (penggunaMasuk != null) {
                System.out.println("Login berhasil!\n");
                menuUtama(penggunaMasuk);
                break;
            } else {
                System.out.println("Nama pengguna atau kata sandi tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }

    private void inisialisasiDataAwal() {
        daftarPengguna.add(new Pengguna("fadhil", "fadhil9090", 100));
        daftarPengguna.add(new Pengguna("user2", "password2", 200));
        daftarPengguna.add(new Pengguna("user3", "password3", 400));

        daftarProduk.add(new Produk("Laptop", 800));
        daftarProduk.add(new Produk("Ponsel", 400));
        daftarProduk.add(new Produk("Headphone", 50));
        daftarProduk.add(new Produk("Monitor", 200));
        daftarProduk.add(new Produk("Mouse", 40));
        daftarProduk.add(new Produk("Tablet", 500));
    }

    private Pengguna login(String username, String password) {
        for (Pengguna pengguna : daftarPengguna) {
            if (pengguna.username.equals(username) && pengguna.password.equals(password)) {
                return pengguna;
            }
        }
        return null;
    }

    private void menuUtama(Pengguna pengguna) {
        while (true) {
            System.out.println("\n1. Tampilkan Produk");
            System.out.println("2. Tambah ke Keranjang");
            System.out.println("3. Lihat Keranjang");
            System.out.println("4. Tampilkan Saldo");
            System.out.println("5. Isi Saldo");
            System.out.println("6. Checkout");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1:
                    tampilkanProduk();
                    break;
                case 2:
                    tambahProdukKeKeranjang(pengguna);
                    break;
                case 3:
                    tampilkanKeranjang(pengguna);
                    break;
                case 4:
                    tampilkanSaldo(pengguna);
                    break;
                case 5:
                    isiSaldo(pengguna);
                    break;
                case 6:
                    checkout(pengguna);
                    break;
                case 7:
                    System.out.println("Keluar.");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void tampilkanProduk() {
        System.out.println("Produk Tersedia:");
        for (int i = 0; i < daftarProduk.size(); i++) {
            Produk produk = daftarProduk.get(i);
            System.out.println(i + 1 + ". " + produk.nama + " - Rp" + produk.harga);
        }
    }

    private void tambahProdukKeKeranjang(Pengguna pengguna) {
        tampilkanProduk();
        System.out.print("Pilih produk untuk ditambahkan ke keranjang: ");

        int indeksProduk = -1;
        try {
            indeksProduk = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Masukan tidak valid. Pemilihan produk dibatalkan.");
            return;
        }

        if (indeksProduk >= 0 && indeksProduk < daftarProduk.size()) {
            Produk produk = daftarProduk.get(indeksProduk);

            System.out.print("Jumlah produk yang ingin dibeli: ");
            int jumlahProduk = -1;
            try {
                jumlahProduk = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukan tidak valid. Penambahan produk dibatalkan.");
                return;
            }

            tambahKeKeranjang(pengguna, produk, jumlahProduk);
        } else {
            System.out.println("Pilihan produk tidak valid.");
        }
    }

    private void tambahKeKeranjang(Pengguna pengguna, Produk produk, int jumlah) {
        for (int i = 0; i < jumlah; i++) {
            pengguna.keranjang.add(produk);
        }
        System.out.println("Produk ditambahkan ke keranjang.");
    }

    private void tampilkanKeranjang(Pengguna pengguna) {
        System.out.println("Keranjang Anda:");
        for (Produk produk : pengguna.keranjang) {
            System.out.println(produk.nama + " - Rp" + produk.harga);
        }
        System.out.println("Total: Rp" + hitungTotal(pengguna));
    }

    private void tampilkanSaldo(Pengguna pengguna) {
        System.out.println("Saldo Anda: Rp" + pengguna.saldo);
    }

    private void isiSaldo(Pengguna pengguna) {
        System.out.print("Jumlah saldo yang ingin diisi: ");
        int saldoTambah = -1;
        try {
            saldoTambah = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Masukan tidak valid. Penambahan saldo dibatalkan.");
            return;
        }

        if (saldoTambah > 0) {
            pengguna.saldo += saldoTambah;
            System.out.println("Saldo berhasil diisi. Saldo Anda sekarang: Rp" + pengguna.saldo);
        } else {
            System.out.println("Jumlah saldo tidak valid.");
        }
    }

    private void checkout(Pengguna pengguna) {
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

    private int hitungTotal(Pengguna pengguna) {
        int total = 0;
        for (Produk produk : pengguna.keranjang) {
            total += produk.harga;
        }
        return total;
    }
}