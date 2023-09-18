<?php
$hostname = "localhost";
$username = "root";
$password1 = "";
$database = "perpus_native";

$koneksi = mysqli_connect($hostname, $username, $password1, $database);

if ($koneksi) {
    echo "";
} else {
    die("<script>alert('Koneksi ke database gagal')</script>") . mysqli_connect_error();
}