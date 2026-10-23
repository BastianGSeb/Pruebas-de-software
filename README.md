# CS-320: Pruebas de software, automatización y garantía de calidad

Este repositorio reúne una selección de los trabajos realizados en el curso de Pruebas de Software. Incluye la implementación y las pruebas unitarias del servicio de contactos (Proyecto Final I), así como el informe de síntesis y reflexiones sobre las estrategias de prueba utilizadas (Proyecto Final II).

## Archivos del portafolio

- `Contact.java`: representa un contacto y valida sus atributos.
- `ContactService.java`: administra contactos en memoria y permite agregarlos, actualizarlos y eliminarlos.
- `ContactTest.java`: comprueba las restricciones y el comportamiento del objeto de contacto.
- `ContactServiceTest.java`: verifica las operaciones del servicio y el manejo de entradas inválidas.
- Informe de síntesis y reflexiones del Proyecto Final II: analiza las técnicas de prueba empleadas, los resultados de cobertura y las lecciones aprendidas.

## Reflexión

### ¿Cómo me aseguro de que mi código, programa o software sea funcional y seguro?

Primero, compruebo que el código cumpla los requisitos mediante pruebas unitarias que incluyen escenarios válidos e inválidos. En el servicio de contactos utilicé JUnit para verificar restricciones como la longitud de los campos, la presencia de valores obligatorios, el formato del teléfono y el rechazo de identificadores duplicados. También medí la cobertura con EclEmma para evaluar qué partes del código habían sido ejecutadas por las pruebas; las clases `Contact.java` y `ContactService.java` alcanzaron un 100 % de cobertura en la medición realizada. Para mejorar la seguridad, aplico validación de entradas y encapsulación de datos, aunque reconozco que la cobertura de pruebas no garantiza por sí sola que una aplicación esté libre de defectos o vulnerabilidades.

### ¿Cómo interpreto las necesidades del usuario y las incorporo en un programa?

Comienzo identificando los requisitos funcionales y las restricciones que debe cumplir la aplicación. Después, los traduzco en reglas concretas y casos de prueba verificables. Por ejemplo, los requisitos del servicio de contactos establecían que cada contacto tuviera un identificador único que no pudiera modificarse y que los demás campos respetaran formatos y límites definidos. Implementé esas reglas en las clases Java y utilicé las pruebas unitarias para comprobar tanto las operaciones permitidas como las que debían rechazarse.

### ¿Cómo abordo el diseño de software?

Procuro dividir el programa en componentes con responsabilidades claras y mantener el código sencillo, legible y fácil de probar. En este proyecto separé el objeto `Contact`, encargado de representar y validar los datos, de `ContactService`, responsable de administrar los contactos mediante una estructura `HashMap` en memoria. También mantuve las pruebas JUnit en clases independientes para verificar cada componente. Trabajar de manera incremental, ejecutar las pruebas después de cada cambio y revisar los resultados me permitió corregir errores y mejorar la confiabilidad del software.