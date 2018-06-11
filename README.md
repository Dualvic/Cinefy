# CINEFY

**Motivación.**

Mi principal motivacion era poder ofrecer una herramienta con la que poder comprar entradas de cine de una manera comoda y sencilla, de forma amigable e intuitiva. 
Con esto tambien se quiere ayudar a los cines a recibir opiniones y valoraciones sobre los servicios que ofrecen, asi como captar sponsors y aumentar sus beneficios a largo plazo.

Esta idea surgió en una cena con amigos donde se nos ocurrio ir al cine, pero al llegar a dicha sala, las entradas ya estaban terminadas para esa sesion.

**Objetivos.**

Los objetivos están definidos como historias de usuario.

Quién? Un estudiante que quiere ir al cine con sus amigos. Qué? Quiere comprar entradas desde cualquier sitio. Para qué? Para poder organizar planes de cine con sus amigos.

Quién? Un director de cualquier centro educativo. Qué? Quiere poder reservar salas o comprar n entradas. Para qué? Para organizar un evento en su centro.

Quién? Un usuario de la aplicación. Qué? Quiere poder gestionar su cuenta. Para qué? Para poder personalizar o cambiar datos en su cuenta.

Quién? Un usuario. Qué? Quiere poder consultar sus pases/tickets comprados. Para qué? Para poder tenerlo todo mas organizado y consultar sus compras

**Demostración del funcionamiento de la aplicación, en base a los objetivos definidos en el anteproyecto.**



**Descripción técnica:**

1.  **Arquitectura de la aplicación y tecnologías utilizadas.**

El proyecto consiste en la realización de una aplicación web orientada a móvil. He utilizado la arquitectura a tres capas que permite que la aplicación sea sostenible, sea fácil la implementan de nuevas funcionalidades, así como organizar mejor la aplicación y poder testear la misma de manera mucho mas sencilla.

Capa de presentación:

Presenta y recoge la información del usuario. Para la implementación de la capa se usarán las funcionalidades básicas de Bootstrap, junto a HTML clásico, CSS y JQuery.

	- Bootstrap 4.1.11, HTML, CSS3, JQuery 3.3.1 (Algunos casos 3.1.0)

Capa de negocio:

La capa de negocio es la encargada de almacenar la logica de la aplicacion:

- Interceptores: Para el uso de las sesiones y el encargado de manejar eventos especiales.
- Actions: Encargados de recoger las peticiones lanzadas desde la capa de presentación ya sea mediante formularios o Ajax, para esto he utilizado Struts, que mapea las acciones a su clase Java y método específico.

		-JAVA8, Struts 2.5.16, Hibernate 5.3

Capa de datos:
Esta capa es la encargada de ofrecer a la capa de negocio los datos que requiera:
- Modelos: Son los conectores a la base de Datos, realizado con Persistence de Hibernate, ayuda a recoger los datos de las columnas en la Base de datos.
-  DAO: Las clases con "DAO" al final, hacen referencia a "Data Access Object, es donde se crea el CRUD básico y las operaciones SQL personalizadas que se necesiten.

		- Hibernate 5.3

2.  **Diagrama de clases.**
Esta es una vista general de mi UML, en el proyecto puedes abrirlo y navegar mas en detalle sobre el mismo, para ver una relación en concreto o visualizar mas sobre dicha clase.
[![image alt text](https://github.com/Dualvic/CINEFY/blob/master/uml.gif?raw=true)](https://github.com/Dualvic/CINEFY/blob/master/uml.gif?raw=true)

3.  **Diagrama E/R de la base de datos.**

[![image alt text](https://github.com/Dualvic/CINEFY/blob/master/BDDiagram.PNG?raw=true)](https://github.com/Dualvic/CINEFY/blob/master/BDDiagram.PNG?raw=true)

La logica que he seguido para la creacion de esta BD es la siguiente:

- Un cine puede tener muchas peliculas en cartelera.
- Una pelicula puede tener varios cines donde la ofrecen.
- Tanto cines como películas pueden tener n valoraciones.
- Un pase solo puede tener un usuario.
- Un usuario puede tener n pases.

**Metodología de desarrollo utilizada.**
La metodología utilizada ha sido en cascada, al ser tecnologías que ya había tocado previamente el proceso de planificación e implementación fueron fáciles y el flujo fue continuo, aun así debí estudiar mejor las versiones de las tecnologías que iba a utilizar, ya que la estimación del proyecto se vio mermada debido a que muchas de las tecnologías que quería usar, al ser ultimas versiones no tenían tanto soporte y fue más difícil su implementación.

Debido a esto ultimo el diagrama de Gantt queda asi:

**Diagrama de Gantt previo y final del desarrollo de la app.**

[![image alt text](https://github.com/Dualvic/CINEFY/blob/master/gantt.PNG?raw=true)](https://github.com/Dualvic/CINEFY/blob/master/gantt.PNG?raw=true)

[![image alt text](https://github.com/Dualvic/CINEFY/blob/master/gantt2.PNG?raw=true)](https://github.com/Dualvic/CINEFY/blob/master/gantt2.PNG?raw=true)


**Análisis y justificación de las diferencias en las estimaciones.**

La estimación la realice mediante tokens de media hora, por falta de investigación en las versiones de las tecnologías que iba a utilizar en el análisis del anteproyecto, los apartados de "Analisis del proyecto" e "Implementación" se vieron muy afectadas casi duplicando la estimación inicial.

Un ejemplo seria que la ultima version de Struts no funciona con Java9, ya que esta cambió sus Binds entre clases a modulos, lo que hacia que Struts no funcionase.

Ejemplos como este no pararon de ocurrir durante las dos primeras semanas de desarrollo donde la estructura del proyecto no terminaba de ser solida.

Frente a la estimación inicial del anteproyecto, la he sobrepasado por 19 horas.

**Presupuesto de la app para el comprador con el coste del software amortizado utilizado en cada fase del ciclo de vida de la app.**

![image alt text](https://github.com/Dualvic/CINEFY/blob/master/material%20utilizado.PNG?raw=true)](https://github.com/Dualvic/CINEFY/blob/master/material%20utilizado.PNG?raw=true)


Para el precio he tomado de referencia mi trabajo actual de becario en KUMOINTERNET y calculé que la hora de desarollo salia a 14,34€

Dando un precio final de 1946€, este precio seria por hora y no estando titulado como desarrollador y costandome mas el desarrollo que un Senior consolodidado, el precio bajaria mucho, ya que no me pareceria un precio justo por este desarrollo.


**Conclusiones.**

Creo que mi mayor fallo fue en la planificacion del proyecto,  a medida que pasaban las semanas se me ocurrian nuevas funcionalidades y el potencial del proyecto. Pero por culpa de los contratiempos en la realizacion de la estructura del proyecto, vi muy limitadas las horas a dedicarle a nuevas funcionalidades.

He conseguido completar las 3 historias mas grandes de la aplicación, con 130 horas aun asi, me parecen escasas.

Tambien añadir que realicé un panel kanban al ver la cantidad de tareas que tenia que realizar:
![image alt text](https://github.com/Dualvic/CINEFY/blob/master/kanban.jpeg?raw=true)](https://github.com/Dualvic/CINEFY/blob/master/kanban.jpeg?raw=true)
