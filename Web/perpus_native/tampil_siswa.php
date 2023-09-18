<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    <title>Tampil Siswa</title>
</head>

<body>
    <main>
        <h3>Tampil Siswa</h3>
        <table class="table table-hover table-striped">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>NAMA SISWA</th>
                    <th>TANGGAL LAHIR</th>
                    <th>ALAMAT</th>
                    <th>GENDER</th>
                    <th>USERNAME</th>
                    <th>KELAS</th>
                    <th>AKSI</th>
                </tr>
            </thead>
            <tbody>
                <?php
                include "koneksi.php";
                $qry_siswa = mysqli_query($koneksi, "select * from siswa join kelas on kelas.id_kelas=siswa.id_kelas");
                $no = 0;
                while ($data_siswa = mysqli_fetch_array($qry_siswa)) {
                    $no++; ?>
                <tr>
                    <td><?= $no ?></td>
                    <td><?= $data_siswa['nama_siswa'] ?></td>
                    <td><?= $data_siswa['tanggal_lahir'] ?></td>
                    <td><?= $data_siswa['alamat'] ?></td>
                    <td><?= $data_siswa['gender'] ?></td>
                    <td><?= $data_siswa['username'] ?></td>
                    <td><?= $data_siswa['nama_kelas'] ?></td>
                    <td>
                        <a href="ubah_siswa.php?id_siswa=<?= $data_siswa['id_siswa'] ?>"
                            class="btn btn-success">Ubah</a> |
                        <a href="proses_hapus.php?id_siswa=<?= $data_siswa['id_siswa'] ?>"
                            onclick="return confirm('Apakah anda yakin menghapus data ini?')"
                            class="btn btn-danger"><b>Hapus</b></a>
                    </td>
                </tr>
                <?php
                }
                ?>
            </tbody>
        </table>
    </main>

</body>

</html>