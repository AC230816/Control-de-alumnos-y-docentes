// Muestra el campo de selección de materias cuando se selecciona "Maestro" como ocupación
document.getElementById("ocupacion").addEventListener("change", function () {
  var materias = document.getElementById("materias");
  if (this.value === "maestro") {
    materias.style.display = "block";
  } else {
    materias.style.display = "none";
  }
});

//VALIDAMOS EL FORMULARIO
function validarFormulario() {
  var nombre = document.getElementById("nombre").value;
  var apellido = document.getElementById("apellido").value;
  var edad = document.getElementById("edad").value;
  var password = document.getElementById("password").value;
  var confirm_password = document.getElementById("confirm_password").value;

  var regex = /^[A-Za-z\s]+$/;

  if (!regex.test(nombre) || !regex.test(apellido)) {
    alert("Ingrese un Nombre o Apellido valido");
    return false;
  }

  if (isNaN(edad) || edad <= 0) {
    alert("Ingrese una edad valida");
    return false;
  }

  if (password !== confirm_password) {
    alert("Las contraseñas no coinciden");
    return false;
  }
  return true;
}

document.getElementById("botonRegistrar").addEventListener("click", function(event) {
  if (!validarFormulario()) {
    event.preventDefault();
  }
});