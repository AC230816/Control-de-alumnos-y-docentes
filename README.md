# Control-de-alumnos-y-docentes

Participantes:

Daniel Alejandro Ábrego Coto - AC230816
Diego Antonio Fuentes Guardado - FG230381
Douglas Johan López Landaverde - LL231775
Jefferson Adonis Melgar Sura - MS230365
Anderson Alessandro Pablo Beltrán - PB230838
Franly Azael Marroquin Carmona  - MC230204


Enlace al video explicativo:

https://drive.google.com/drive/folders/1sY6tu-tuJ5QvEDWfvkKsBooPMsF2zgRd?usp=sharing

Configuración de tomcat:

Se sugiere iniciar el proyecto con la siguiente url: http://localhost:8080/login.jsp
El puerto puede variar
Para evitar problemas con la conexión a base de datos, tomar el script alojado en la carpeta DATABASE de este proyecto y ejecutar 
el código en el gestor de base de datos phpMyAdmin. Luego verificar que el archivo pom.xml contenga la dependencia que permite 
las conexiones con bases de datos. Si no está, puede insertar estas líneas:

<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.33</version>
</dependency>

También puede proceder a instalar el driver como una librería usando el siguiente enlace: https://dev.mysql.com/downloads/connector/j/

