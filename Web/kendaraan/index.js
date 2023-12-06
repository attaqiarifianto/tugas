const express = require("express")
const bodyParser = require("body-parser")
const cors = require("cors")
const mysql = require("mysql")
const { error, count } = require("console")

const app = express()
app.use(cors())
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended: true}))

const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "penyewaan_kendaraan"
})

db.connect(error => {
    if(error){
        console.log(error.message)
    } else{
        console.log("MySQL Connected")
    }
})

//end-point akses data penyewa
app.get("/pemilik", (req,res) => {
    let sql = "select * from pemilik"

    db.query(sql, (error, result) => {
        let response = null
        if(error){
            response = {
                message: error.message
            }
        } else{
            response = {
                count: result.length,
                pemilik: result
            }
        }
        res.json(response)
    })
})

// end-point akses data penyewa berdasarkan id_penyewa tertentu
app.get("/pemilik/:id", (req, res) => {
    let data = {
        id_pemilik: req.params.id
    }
    // create sql query
    let sql = "select * from pemilik where ?"

    // run query
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message // pesan error
            }            
        } else {
            response = {
                count: result.length, // jumlah data
                pemilik: result // isi data
            }            
        }
        res.json(response) // send response
    })
})

// end-point menyimpan data penyewa
app.post("/pemilik", (req,res) => {

    // prepare data
    let data = {
        nama_pemilik: req.body.nama_pemilik,
        alamat: req.body.alamat
    }

    // create sql query insert
    let sql = "insert into pemilik set ?"

    // run query
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message
            }
        } else {
            response = {
                message: result.affectedRows + " data inserted"
            }
        }
        res.json(response) // send response
    })
})

// end-point mengubah data penyewa
app.put("/pemilik", (req,res) => {

    // prepare data
    let data = [
        // data
        {
            nama_pemilik: req.body.nama_pemilik,
            alamat: req.body.alamat
        },

        // parameter (primary key)
        {
            id_pemilik: req.body.id_pemilik
        }
    ]

    // create sql query update
    let sql = "update pemilik set ? where ?"

    // run query
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message
            }
        } else {
            response = {
                message: result.affectedRows + " data updated"
            }
        }
        res.json(response) // send response
    })
})

// end-point menghapus data penyewa berdasarkan id_penyewa
app.delete("/pemilik/:id", (req,res) => {
    // prepare data
    let data = {
        id_pemilik: req.params.id
    }

    // create query sql delete
    let sql = "delete from pemilik where ?"

    
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message
            }
        } else {
            response = {
                message: result.affectedRows + " data deleted"
            }
        }
        res.json(response)
    })
})

//end-point akses data penyewa
app.get("/penyewa", (req,res) => {
    let sql = "select * from penyewa"

    db.query(sql, (error, result) => {
        let response = null
        if(error){
            response = {
                message: error.message
            }
        } else{
            response = {
                count: result.length,
                penyewa: result
            }
        }
        res.json(response)
    })
})

// end-point akses data penyewa berdasarkan id_penyewa tertentu
app.get("/penyewa/:id", (req, res) => {
    let data = {
        id_penyewa: req.params.id
    }
    // create sql query
    let sql = "select * from penyewa where ?"

    // run query
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message // pesan error
            }            
        } else {
            response = {
                count: result.length, // jumlah data
                penyewa: result // isi data
            }            
        }
        res.json(response) // send response
    })
})

// end-point menyimpan data penyewa
app.post("/penyewa", (req,res) => {

    // prepare data
    let data = {
        nama_penyewa: req.body.nama_penyewa,
        alamat: req.body.alamat
    }

    // create sql query insert
    let sql = "insert into penyewa set ?"

    // run query
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message
            }
        } else {
            response = {
                message: result.affectedRows + " data inserted"
            }
        }
        res.json(response) // send response
    })
})

// end-point mengubah data penyewa
app.put("/penyewa", (req,res) => {

    // prepare data
    let data = [
        // data
        {
            nama_penyewa: req.body.nama_penyewa,
            alamat: req.body.alamat
        },

        // parameter (primary key)
        {
            id_penyewa: req.body.id_penyewa
        }
    ]

    // create sql query update
    let sql = "update penyewa set ? where ?"

    // run query
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message
            }
        } else {
            response = {
                message: result.affectedRows + " data updated"
            }
        }
        res.json(response) // send response
    })
})

// end-point menghapus data penyewa berdasarkan id_penyewa
app.delete("/penyewa/:id", (req,res) => {
    // prepare data
    let data = {
        id_penyewa: req.params.id
    }

    // create query sql delete
    let sql = "delete from penyewa where ?"

    
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message
            }
        } else {
            response = {
                message: result.affectedRows + " data deleted"
            }
        }
        res.json(response)
    })
})

//end-point akses data kendaraan
app.get("/kendaraan", (req,res) => {
    let sql = "select * from kendaraan"

    db.query(sql, (error, result) => {
        let response = null
        if(error){
            response = {
                message: error.message
            }
        } else{
            response = {
                count: result.length,
                kendaraan: result
            }
        }
        res.json(response)
    })
})

// end-point akses data kendaraan berdasarkan id_kendaraan tertentu
app.get("/kendaraan/:id", (req, res) => {
    let data = {
        id_kendaraan: req.params.id
    }
    // create sql query
    let sql = "select * from kendaraan where ?"

    // run query
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message // pesan error
            }            
        } else {
            response = {
                count: result.length, // jumlah data
                kendaraan: result // isi data
            }            
        }
        res.json(response) // send response
    })
})

// end-point menyimpan data kendaraan
app.post("/kendaraan", (req,res) => {

    // prepare data
    let data = {
        plat_nomor: req.body.plat_nomor,
        jenis_kendaraan: req.body.jenis_kendaraan
    }

    // create sql query insert
    let sql = "insert into kendaraan set ?"

    // run query
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message
            }
        } else {
            response = {
                message: result.affectedRows + " data inserted"
            }
        }
        res.json(response) // send response
    })
})

// end-point mengubah data penyewa
app.put("/kendaraan", (req,res) => {

    // prepare data
    let data = [
        // data
        {
            plat_nomor: req.body.plat_nomor,
            jenis_kendaraan: req.body.jenis_kendaraan
        },

        // parameter (primary key)
        {
            id_kendaraan: req.body.id_kendaraan
        }
    ]

    // create sql query update
    let sql = "update kendaraan set ? where ?"

    // run query
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message
            }
        } else {
            response = {
                message: result.affectedRows + " data updated"
            }
        }
        res.json(response) // send response
    })
})

// end-point menghapus data penyewa berdasarkan id_penyewa
app.delete("/kendaraan/:id", (req,res) => {
    // prepare data
    let data = {
        id_kendaraan: req.params.id
    }

    // create query sql delete
    let sql = "delete from kendaraan where ?"

    
    db.query(sql, data, (error, result) => {
        let response = null
        if (error) {
            response = {
                message: error.message
            }
        } else {
            response = {
                message: result.affectedRows + " data deleted"
            }
        }
        res.json(response)
    })
})

app.listen(8000, () => {
    console.log("Run on port 8000")
})