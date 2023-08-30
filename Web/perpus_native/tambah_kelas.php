<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" />
</head>

<body>
    <header></header>
    <main>
        <h3>Tambah Kelas</h3>
        <form action="proses_tambah_kelas.php" method="post">
            <!--text-->
            <label for="nama_kelas">Nama Kelas: </label><br />
            <input type="text" id="nama_kelas" name="nama_kelas" class="form-control" /><br />
            <label for="kelompok">Kelompok: </label><br />
            <input type="text" id="kelompok" name="kelompok" class="form-control" /><br />
            <!--submit-->
            <input type="submit" name="simpan" value="Tambah Kelas" class="btn btn-primary" />
        </form>
    </main>
</body>

</html>