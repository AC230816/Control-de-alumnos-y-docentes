// Muestra el campo de selección de materias cuando se selecciona "Maestro" como ocupación
document.getElementById("ocupacion").addEventListener("change", function () {
  var materias = document.getElementById("materias");
  if (this.value === "maestro") {
    materias.style.display = "block";
  } else {
    materias.style.display = "none";
  }
});
