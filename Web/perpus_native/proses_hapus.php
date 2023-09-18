<?php
if($_GET['id_siswa']){
    include "koneksi.php";
    $qry_proses_hapus=mysqli_query($koneksi,"delete from siswa where id_siswa='".$_GET['id_siswa']."'");
    if($qry_proses_hapus){
        echo "<script>alert('Sukses hapus siswa');location.href='tampil_siswa.php';</script>";
    } else {
        echo "<script>alert('Gagal hapus siswa');location.href='tampil_siswa.php';</script>";
    }
}
