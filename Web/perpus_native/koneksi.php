<?php
$hostname = "localhost";
$username = "root";
$password = "";
$database = "perpus_native";

$koneksi = mysqli_connect($hostname, $username, $password, $database);

if ($koneksi) {
    echo "Koneksi ke database berhasil";
} else {
    die("Koneksi ke database gagal") . mysqli_connect_error();
}