**Spring Boot with H2 demo**

This is demo project withs Spring Boot and H2.

H2 connected with Embedded mode.
You can see some configs in application.properties.

Copy address http://localhost:8080/h2-console for connection with H2 when application is run. If you see more informative log and the port delete *logging.level.root=warn* before.

SQL script was performed in started H2 database. See the script in *src/main/resources/scripts/startdb.sql*.