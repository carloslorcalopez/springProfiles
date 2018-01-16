# springProfiles
## Seteo Profile Ejecucion

### Correr Clase

El profile se puede setear por una variable de ambiente
```
System.setProperty("spring.profiles.active", "prod");
```

O como parametro de la invocación '-Dspring.profiles.active'
```
$ java -jar -Dspring.profiles.active=production demo-0.0.1-SNAPSHOT.jar
```
O setearlo en el ambiente
```
export spring_profiles_active=dev
```

### Correr Tests

Se puede determinar el profile a correr a través de la anotación profile

```
@ActiveProfiles(profiles="prod")
```

## Seleccion de archivo properties

### Multiple profiles un unico application.yml

Se pueden configurar secciones generales y especificas para profile (spring.profiles.active)
```
logging:
  level:
    .: error
    org.springframework: ERROR
---
spring:
  profiles:
    active: "dev"
  application:
        name: TodoDev
server:
  email: default@mkyong.com
  port: 8090
---
spring:
  profiles:
    active: "prod"
  application:
        name: TodoProd
server:
  email: default@mkyong.com
  port: 8100
  
---
spring:
  profiles:
    active: "test"
  application:
        name: TodoTest
server:
  email: default@mkyong.com
  port: 8200
```

La marca '---' identifica una sección, si la sección no incluye spring.profiles.active se aplica a cualquier profile.

### Multiples application.yml

Es posible utilizar multiples archivos de configuración. Cuando se utiliza el profile 'XXXXX' se utilizan los parametros application-XXXXX.yml . 

