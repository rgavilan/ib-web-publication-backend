![](./images/logos_feder.png)

# ASIO - Web publication backend

| Entregable     | Procesador de datos                                                                                                                                                                                                                                                                                                                  |
| -------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Fecha          | 30/11/2020                                                                                                                                                                                                                                                                                                                           |
| Proyecto       | [ASIO](https://www.um.es/web/hercules/proyectos/asio) (Arquitectura Semántica e Infraestructura Ontológica) en el marco de la iniciativa [Hércules](https://www.um.es/web/hercules/) para la Semántica de Datos de Investigación de Universidades que forma parte de [CRUE-TIC](http://www.crue.org/SitePages/ProyectoHercules.aspx) |
| Módulo         | Sistema de gestión                                                                                                                                                                                                                                                                                                                   |
| Tipo           | Software                                                                                                                                                                                                                                                                                                                             |
| Objetivo       | Sistema de gestión de datos del módulo de procesamiento para el proyecto Backend SGI (ASIO).                                                                                                                                                                                                                                         |
| Estado         | **30%** Controller para las primeras pantallas del front                                                                                                                                                                                                                                                                             |
| Próximos pasos | Se deben completar el resto de controllers pendientes.                                                                                                                                                                                                                                                                               |

|

# ASIO - Sistema de gestión

Sistema de gestión de datos del módulo de procesamiento para el proyecto Backend SGI (ASIO).

## OnBoarding

Para iniciar el entorno de desarrollo se necesita cumplir los siguientes requisitos:

- OpenJDK 11
- Eclipse JEE 2019-09 con plugins:
  - Spring Tools 4
  - m2e-apt
  - Lombok
- Docker

## Metodología de desarrollo

La metodología de desarrollo es Git Flow.

## Entorno de desarrollo Docker

La inicialización de los elementos adicionales al entorno de desarrollo se realiza con docker.

En el directorio docker-devenv se ha configurado un fichero docker-compose.yml para poder arrancar el entorno de desarrollo.

Para arrancar el entorno:

```bash
docker-compose up -d
```

Para pararlo:

```bash
docker-compose down
```

## Instalación en entorno real

Será preciso configurar las siguientes variables de entorno cuando se instale en un entorno real:

| Variable                | Descripción         | Valor por defecto                    |
| ----------------------- | ------------------- | ------------------------------------ |
| `APP_FUSEKITRELLIS_URL` | Url endpoint sparql | http://localhost:3030/trellis/sparql |

### Ejecución

Al generarse un JAR bootable la ejecución se realizará mediante el siguiente comando:

```bash
java -jar {jar-name}.jar
```

Sustituyendo `{jar-name}` por el nombre del fichero JAR generado.

No es necesario especificar la clase de inicio de la aplicación, ya que el fichero MANIFEST.MF generado ya contiene la información necesaria. Solamente se especificarán los parametros necesarios.

## Testing y cobertura

Se incluyen los resultados del testing y cobertura en los siguientes enlaces:

- [Testing TDD] TBD
- [Cobertura TDD] TBD
- [Testing BDD] TBD

## Documentación adicional

- [Compilación](docs/build.md)
- [Generación Docker](docs/docker.md)
