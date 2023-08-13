package TokoOnline;

import java.util.*;

class Pengguna {
    String username;
    String password;
    List<Produk> keranjang;

    public Pengguna(String username, String password) {
        this.username = username;
        this.password = password;
        this.keranjang = new ArrayList<>();
    }

    public void tambahKeKeranjang(Produk produk, int jumlah) {
        for (int i = 0; i < jumlah; i++) {
            keranjang.add(produk);
        }
    }

    public int hitungTotal() {
        int total = 0;
        for (Produk produk : keranjang) {
            total += produk.harga;
        }
        return total;
    }
}