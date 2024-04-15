Debe construir una aplicación (Proyecto Web Springboot con Java) que permita a un Usuario reservar un turno de una Cancha de Futbol.

Usuario es una entidad que tiene como atributos: dni (clave primaria), nombre, apellido, tipo (VISITANTE, ADMINISTRADOR) (revisar el tipo de dato adecuado para cada atributo).

Cancha de Futbol es una entidad que tiene como atributos: Código (clave primaria), capacidad (FUTBOL 7, FUTBOL 5), precio, horarios (para que sea sencillo utilizar los campos horario1, horario2 y horario3). 

El usuario VISITANTE accede a la aplicación y ve los horarios disponibles de las TRES canchas de fútbol. Debe seleccionar el turno y luego el sistema le pedirá que ingrese los datos para registrarlo y RESERVAR un horario en particular.
El usuario ADMINISTRADOR, debe cargar los datos y horarios de las canchas y las opciones de modificar y eliminar.
Debe implementar Spring Data para una Base de Datos con MySQL.

Para APROBAR debe:
1.- Inmediatamente compartir un repositorio remoto en Github para seguimiento
2.- El Domingo se revisará ese repositorio para observar los avances del proyecto.
3.- La entrega definitiva se deberá resolver hasta la noche del Lunes. El martes por la mañana se revisará el programa funcional. Si no funciona, no podrá aprobar.
4.- Una vez que se compruebe la funcionalidad, el Martes por la tarde se debe defender la tarea, exponiendo detalles del trabajo. Si no se logra expresar con claridad en la defensa, no podrá aprobar.

Debe CONFIRMAR ESTE MAIL para registrar su participación.
Cualquier duda se comunica respondiendo a este mail.
Saludos


# List de Cosas

- Cambiar  Usuario.DNI como a clave primaria
- Vista Formulario para Reservar asientos
- Vista con los horarios de las canchas: 
- Vista Administrador Modificar y Eliminar: resources/admin.html
- Registro de Usuarios: resources/registro.html resources/login.html
