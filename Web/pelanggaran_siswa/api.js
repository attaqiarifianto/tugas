const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const mysql = require("mysql");
const moment = require("moment");

const app = express();
app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "pelanggaran_siswa"
});

db.connect(error => {
    if (error) {
        console.error("Error connecting to MySQL:", error);
    } else {
        console.log("MySQL Connected");
    }
});

app.get("/siswa", (req, res) => {
    let sql = "SELECT * FROM siswa";

    db.query(sql, (error, result) => {
        if (error) {
            console.error("Error retrieving students:", error);
            res.status(500).json({ message: "Error retrieving students" });
        } else {
            res.json({ count: result.length, siswa: result });
        }
    });
});

app.get("/siswa/:id", (req, res) => {
    const id = req.params.id;
    let sql = "SELECT * FROM siswa WHERE id_siswa = ?";

    db.query(sql, id, (error, result) => {
        if (error) {
            console.error("Error retrieving student by ID:", error);
            res.status(500).json({ message: "Error retrieving student by ID" });
        } else {
            res.json({ count: result.length, siswa: result });
        }
    });
});

app.post("/siswa", (req, res) => {
    const { nis, nama_siswa, kelas, poin } = req.body;
    const data = { nis, nama_siswa, kelas, poin };

    let sql = "INSERT INTO siswa SET ?";

    db.query(sql, data, (error, result) => {
        if (error) {
            console.error("Error adding student:", error);
            res.status(500).json({ message: "Error adding student" });
        } else {
            res.json({ message: result.affectedRows + " data inserted" });
        }
    });
});

app.put("/siswa/:id", (req, res) => {
    const id = req.params.id;
    const { nis, nama_siswa, kelas, poin } = req.body;
    const data = { nis, nama_siswa, kelas, poin };

    let sql = "UPDATE siswa SET ? WHERE id_siswa = ?";

    db.query(sql, [data, id], (error, result) => {
        if (error) {
            console.error("Error updating student:", error);
            res.status(500).json({ message: "Error updating student" });
        } else {
            res.json({ message: result.affectedRows + " data updated" });
        }
    });
});

app.delete("/siswa/:id", (req, res) => {
    const id = req.params.id;
    let sql = "DELETE FROM siswa WHERE id_siswa = ?";

    db.query(sql, id, (error, result) => {
        if (error) {
            console.error("Error deleting student:", error);
            res.status(500).json({ message: "Error deleting student" });
        } else {
            res.json({ message: result.affectedRows + " data deleted" });
        }
    });
});

app.listen(8000, () => {
    console.log("Server running on port 8000");
});
