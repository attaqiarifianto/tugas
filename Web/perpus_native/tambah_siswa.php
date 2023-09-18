<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    <title>Tambah Siswa</title>
</head>

<body>
    <main>
        <h3>Tambah Siswa</h3>
        <form action="proses_tambah_siswa.php" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" id="username" class="form-control">
            <label for="password">Password:</label>
            <input type="text" name="password" id="password" class="form-control">
            <label for="nama_siswa">Nama Siswa:</label>
            <input type="text" id="nama_siswa" name="nama_siswa" class="form-control">
            <label for="tanggal_lahir">Tanggal Lahir:</label>
            <input type="date" id="tanggal_lahir" name="tanggal_lahir" class="form-control">
            <label for="alamat">Alamat:</label>
            <textarea name="alamat" id="alamat" class="form-control" cols="30" rows="5"></textarea>
            <label for="gender">Gender:</label>
            <select name="gender" id="gender" class="form-control">
                <option value="L">Laki-Laki</option>
                <option value="P">Perempuan</option>
            </select>
            <label for="id_kelas">Kelas Tersedia:</label>
            <select name="id_kelas" id="id_kelas" class="form-control">
                <option></option>
                <?php
                include "koneksi.php";
                $qry_kelas = mysqli_query($koneksi, "select * from kelas");
                while ($data_kelas = mysqli_fetch_array($qry_kelas)) {
                    echo '<option value="' . $data_kelas['id_kelas'] . '">' . $data_kelas['nama_kelas'] . '</option>';
                }
                ?>
            </select>
            <input type="submit" name="simpan" value="Tambah Siswa" class="btn btn-primary">
        </form>
        <a href="tambah_kelas.php">Tambah kelas.</a>
    </main>
</body>

</html>