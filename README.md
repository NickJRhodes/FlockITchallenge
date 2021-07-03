# Aclaraciones

Para levantar el proyecto, se puede utilizar: mvn spring-boot:run
  - Proyecto Maven
  - Se ultiliza Spring Boot 2.5.2 como framework de base
  - No se utiliza una capa de persistencia ni DTO
  - Se generaron tests unitarios sólo de la capa de servicio
  - La aplicación levanta en el puerto 8080 con Tomcat embebido
  - Se utilizan comentarios en las clases según las especificaciones de JavaDoc

# Login

  El procedimiento de login del usuario no es un proceso de autenticción real. No se manejan sesiones, tokens, cifrado, base de datos ni nada por el estilo. Simplemente se valida que el valor de los atributos username y password, que viajan dentro del cuerpo de la solicitud, sean iguales a los que encontramos dentro del archivo application.properties (claves user.username y user.password respectivamente).\n
  Endpoint - POST: http://localhost:8080/login
  
# Longitud y latitud

  Este endpoint nos sirve de "pasa manos" con una API pública que es la que realmente hace la "magia". Recibe como parámetro el nombre de una provincia Argentina y devuelve las coordenadas geográficas latitud y longitud.
  Endpoint - GET: http://localhost:8080/coordinates/{province}
  
# Logs

  Para el manejo de logs, se utiliza Logback, framwork de logs predeterminado en Spring Boot. 
  Como se solicita en el requerimiento de este proyecto, es necesario almacenar los logs en un archivo o en una base de datos. Se optó por la primera opción, por lo tanto, podemos encontrar el archivo de logs en {DIRECTORIO_RAIZ}/challenge/logs/.
  
# Documentación de APIs

  Para la documentación automática de APIs, se utiliza OpenAPI 3.
  Para visualizar el documento de especificación de las apis de este proyecto en formato JSON, se puede acceder a esta url: http://localhost:8080/v3/api-docs/
  Para tener una interfáz gráfica de dicha documentación y, además, tener una herramienta de interacción con nuestros endpoints, se puede acceder a: http://localhost:8080/swagger-ui.html
  
 ## Tiempo estimado de desarrollo: 6hs.
 ## Desarrollador: Nicolás Rodriguez
