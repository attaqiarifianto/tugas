function persegi(){
    var sisi = document.getElementById("sisi").value;
    var hasil = sisi*sisi;
    var tampilan = document.getElementById("tampilan")
    tampilan.innerHTML = hasil
}

function persegipanjang(){
    var panjang = document.getElementById("panjang").value;
    var lebar = document.getElementById("lebar").value;
    var hasil = panjang*lebar;
    var tampilan = document.getElementById("tampilan")
    tampilan.innerHTML = hasil
}

function segitiga(){
    var tinggi = document.getElementById("tinggi").value;
    var alas = document.getElementById("alas").value;
    var hasil = tinggi*alas*0.5;
    var tampilan = document.getElementById("tampilan")
    tampilan.innerHTML = hasil
}

function lingkaran(){
    var jari = document.getElementById("jari").value;
    var hasil = jari*jari*3.14;
    var tampilan = document.getElementById("tampilan")
    tampilan.innerHTML = hasil
}


