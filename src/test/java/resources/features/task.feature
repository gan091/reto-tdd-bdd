Feature: Registro de Tareas
  Como usuario de la API de tareas,
  quiero poder crear una nueva tarea con título, descripción y estado,
  para que pueda registrar mis pendientes y organizarlos dentro de una aplicación web o
  móvil

    Escenario: Registrar la tarea "Hacer una presentación"
      Dado que el usuario ha iniciado sesión
      E ingresa a registrar una nueva tarea
      Cuando el usuario diligencia los datos de la tarea
      Entonces puede visualizar que su tarea ha sido registrada exitosamente

    Escenario: Registrar la tarea "Redactar informe" sin incluir la descripción
      Dado que el usuario ha iniciado sesión
      E ingresa a registrar una nueva tarea
      Cuando el usuario diligencia los datos de la tarea sin diligenciar todos los campos requeridos
      Entonces puede visualizar un mensaje de error indicando que los campos son obligatorios