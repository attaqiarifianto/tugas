<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    <title>Ubah Siswa</title>
</head>

<body>
    <main>
        <?php
        include "koneksi.php";
        $qry_get_siswa = mysqli_query($koneksi, "select * from siswa where 
    id_siswa = '" . $_GET['id_siswa'] . "'");
        $dt_siswa = mysqli_fetch_array($qry_get_siswa);
        ?>
        <h3>Tambah Siswa</h3>
        <form action="proses_tambah_siswa.php" method="post">
            <input type="hidden" name="id_siswa" value="<?= $dt_siswa['id_siswa'] ?>">
            <label for="nama_siswa">Nama Siswa :</label>
            <input type="text" name="nama_siswa" value="<?= $dt_siswa['nama_siswa'] ?>" class="form-control">
            <label for="tanggal_lahir">Tanggal Lahir :</label>
            <input type="text" name="tanggal_lahir" value="<?= $dt_siswa['tanggal_lahir'] ?>" class="form-control">
            Gender :
            <?php
            $arr_gender = array('L' => 'Laki-laki', 'P' => 'Perempuan');
            ?>
            <select name="gender" class="form-control">
                <option></option>
                <?php foreach ($arr_gender as $key_gender => $val_gender) :
                    if ($key_gender == $dt_siswa['gender']) {
                        $select = "selected";
                    } else {
                        $select = "";
                    }
                ?>
                <option value="<?= $key_gender ?>" <?= $select ?>><?= $val_gender ?></option>
                <?php endforeach ?>
            </select>
            <label for="alamat">Alamat :</label>
            <textarea name="alamat" class="form-control" rows="4"><?= $dt_siswa['alamat'] ?></textarea>
            <label for="id_kelas">Kelas :</label>
            <select name="id_kelas" class="form-control">
                <option></option>
                <?php
                //include koneksi
                $qry_kelas = mysqli_query($koneksi, "select * from kelas");
                while ($data_kelas = mysqli_fetch_array($qry_kelas)) {
                    if ($data_kelas['id_kelas'] == $dt_siswa['id_kelas']) {
                        $select = "selected";
                    } else {
                        $select = "";
                    }
                    echo '<option value="' . $data_kelas['id_kelas'] . '"
                ' . $select . '>' . $data_kelas['nama_kelas'] . '</option>';
                }
                ?>
            </select>
            <label for="username">Username:</label>
            <input type="text" name="username" value="<?= $dt_siswa['username'] ?>" class="form-control">
            <label for="password">Password</label>
            <input type="password" name="password" value="Ubah Siswa" class="format-control">
            <input type="submit" name="update" value="Ubah Siswa" class="btn btn-primary">
    </main>

    </form>
</body>

</html>