![](./images/logos_feder.png)

# ASIO - Web publication backend

|     | Master |
| --- | ------ |
| Quality Gate | [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=HerculesCRUE_ib-web-publication-backend&metric=alert_status)](https://sonarcloud.io/dashboard?id=HerculesCRUE_ib-web-publication-backend) |

Arquetipo Java para API Rest con base de datos relacional

## OnBoarding

Para iniciar el entorno de desarrollo se necesita cumplir los siguientes requisitos:

* OpenJDK 11 (en caso de querer JDK8: Oracle JDK 8)
* Eclipse JEE 2019-09 con plugins:
** Spring Tools 4
** m2e-apt
** Lombok
* Docker


### Instalar Lombok

Para la instalación de Lombok, es preciso descargar la última versión desde [https://projectlombok.org/download](https://projectlombok.org/download). Se descargará un jar que precisa ser ejecutado:

	java -jar lombok.jar

Se seleccionará la ubicación en la que se encuentra instalado Eclipse.

En caso que de problemas a la hora de generar las clases de Mapstruct, es preciso utilizar una versión parcheada de lombok. Para ello, se ha dejado en \\rackstation\Desarrollo\fuentes\Entorno de desarrollo\Eclipses el fichero lombok-patched-1.18.6.jar. Se deberá configurar en el fichero eclipse.ini, sustituyendo el jar que tiene configurado actualmente por el parcheado

```
-javaagent:C:\desarrollo\java\install\eclipse-jee-2018-12-R-win32-x86_64\lombok-patched-1.18.6.jar
```

## Inicialización de la base de datos y solr

La inicialización de la base de datos y solr se realiza con docker. En primer lugar es preciso modificar el fichero ```docker-devenv\.env``` y actualizar la variable de entorno ```COMPOSE_PROJECT_NAME```

En el directorio docker-devenv se ha configurado un fichero docker-compose.yml para poder arrancar el entorno de desarrollo. Actualmente contiene los siguientes elementos:

* Postgre 11.1
* Solr 7.7 (no activo por defecto)

En caso de querer cambiar una versión o añadir un nuevo elemento al docker-compose, se puede buscar la imagen apropiada en https://hub.docker.com/

Se pueden eliminar los elementos que no se vayan a utilizar.

Para arrancar el entorno:

	docker-compose up -d

Para pararlo:

	docker-compose down

En caso de querer levantar Solr, se precisa descomentar del fichero ```docker-compose.yml``` la sección correspondiente. Acceder a solr (http://localhost:8983/solr/#/~collections) y crear una colección llamada app con el esquema default

## Inserción de usuario inicial

La inserción de un usuario administrador inicial, con nombre de usuario ```user``` y contraseña ```secret``` se hace mediante el siguiente script:

```sql
INSERT INTO APPLICATION_USER 
	(ID, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, ADDRESS, CITY, COUNTRY, CREDENTIALS_NON_EXPIRED, EMAIL, ENABLED, LANGUAGE, NAME, PASSWORD, PASSWORD_RECOVERY_HASH, USERNAME, VERSION) 
VALUES 
	('1', true, true, '1', '1', '1', true, 'b@t.com', true, '1', 'user', '{bcrypt}$2a$10$08d0l3aRNN.DQ/CgHFmZNOUmpaWSjWsTRzN/Dcd.1WEhpQ13CEDxK', 'secret', 'user', 1);

INSERT INTO application_user_role (ROLE, USER_ID) VALUES ('ADMINISTRATOR', '1');
```

Se ha dejado el script en ```db\02.default-data.sql```

## OAuth

En caso de querer utilizar OAuth con persistencia de sus datos en base de datos, además de configurar la aplicación, es preciso crear las tablas correspondientes. Se ha dejado el script en ```db\01.oauth-schema.sql```. Esto creará también un cliente con el usuario ```acme``` y contraseña ```acmesecret```.

## Java 11

La aplicación está preparada para funcionar con JDK 11. En caso de necesitar trabajar con un JDK anterior, es preciso especificar una propiedad en el POM:

```xml
<properties>
	<java.version>1.8</java.version>
</properties>
```

Para descargar JDK 11, se precisa utilizar openjdk, la cual se puede obtener de https://jdk.java.net/11/

### Swagger

Se ha añadido la posibilidad de utilizar Swagger, el cual se ha configurado como Starter:

Para acceder a Swagger, se utilizará la siguiente URL:

http://localhost:8080/swagger-ui.html
