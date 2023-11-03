var nombre = document.getElementById("div-nombre");
var apellido = document.getElementById("div-apellido");
var edad = document.getElementById("div-edad");
var password = document.getElementById("div-password");

window.onload = function (){
    nombre.style.display = "none";
    apellido.style.display = "none";
    edad.style.display = "none";
    password.style.display = "none";
}

document.getElementById("campos").addEventListener("change", function() {
    if (this.value === "nombre") {
        nombre.style.display = "block";
        apellido.style.display = "none";
        edad.style.display = "none";
        password.style.display = "none";
    } else if (this.value === "apellido") {
        nombre.style.display = "none";
        apellido.style.display = "block";
        edad.style.display = "none";
        password.style.display = "none";
    } else if (this.value === "edad") {
        nombre.style.display = "none";
        apellido.style.display = "none";
        edad.style.display = "block";
        password.style.display = "none";
    } else if (this.value === "password") {
        nombre.style.display = "none";
        apellido.style.display = "none";
        edad.style.display = "none";
        password.style.display = "block";
    } else {
        nombre.style.display = "block";
        apellido.style.display = "block";
        edad.style.display = "block";
        password.style.display = "block";
    }
});

