const mysql = require("mysql")
const { createConnection } = ruquire("net")

const db = mysql .createConnection({
    host:"localhost",
    user:"root",
    password:"",
    database:"pelanggaran_siswa"
})
