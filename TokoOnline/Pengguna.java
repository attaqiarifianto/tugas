package TokoOnline;

import java.util.*;

class Pengguna {
    String username;
    String password;
    int saldo;
    List<Produk> keranjang;

    public Pengguna(String username, String password, int saldo) {
        this.username = username;
        this.password = password;
        this.saldo = saldo;
        this.keranjang = new ArrayList<>();
    }
}