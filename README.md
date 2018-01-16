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

## Utilizar Distintas propiedades dependiendo del profile

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

## Uso de Beans a partir de un profile

Con la anotación profile se pueden demarcar las clases de configuracion y los Bean para que se carguen solo en determinados profile

```
@Profile("prod")
@Configuration
public class Prod {
	
	private static final Logger _log = LoggerFactory.getLogger(Prod.class); 
	@Bean
	public Todo getTodo() {
		_log.info("Cargando TODO @Profile({})",this.getClass().getName());
		Todo todo = new Todo();
		todo.setListo(false);
		todo.setTarea("Prod");
		return todo;
	}
}
```

## Aplicacion de ejemplo

La aplicacion Todo presenta todas estas combinaciones

### Clase Main

La clasae Main carga el 'profile' prod por defecto

### Jpa

Cada profile carga una configuración distinta de JPA sobre una base de datos embebida distinta (H2,Derby,HSQL)

### package cl.welinux.todo.profiles

Contiene distintas clases de configuracion demarcadas por profile y que generan un Bean Todo el cual viene inicializado de distinta forma dependiendo el profile


