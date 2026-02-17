# 🗂️ Sistema de Gestión de Tareas

## 📚 Descripción del Proyecto

Proyecto educativo en Java que implementa un sistema básico de gestión de tareas.
Permite crear, listar, completar y eliminar tareas, aplicando validaciones para garantizar que los datos sean correctos y que los identificadores sean únicos.

---

## 🎯 Objetivos del Proyecto

- Aplicar principios de diseño limpio
- Implementar validaciones de negocio
- Manejar excepciones personalizadas
- Desarrollar pruebas unitarias con JUnit 5
- Practicar arquitectura por capas (model, service, view)
- Simular un CRUD completo en memoria

---

## 🏗️ Arquitectura del Proyecto
```
task-manager/
├── src/
│ ├── main/java/org/example/
│ │ ├── model/
│ │ │ └── Tarea.java
│ │ ├── service/
│ │ │ ├── TareaService.java
│ │ │ └── ValidacionService.java
│ │ ├── view/
│ │ │ └── Menu.java
│ │ └── exception/
│ │ ├── DatosInvalidosException.java
│ │ ├── OperacionInvalidaException.java
│ │ └── TareaNoEncontradaException.java
│ └── test/java/org/example/
│ └── service/
│ ├── TareaServiceTest.java
│ └── ValidacionServiceTest.java
└── pom.xml

```

---

## 📋 Funcionalidades

### 1️⃣ Gestión de Tareas

- ✔ Registrar tarea (ID único)
- ✔ Listar tareas
- ✔ Buscar tarea por ID
- ✔ Completar tarea
- ✔ Eliminar tarea

---

## 🔒 Validaciones Implementadas

- ID obligatorio y mayor que 0
- Nombre obligatorio
- ID único en el sistema
- No se puede completar o eliminar una tarea inexistente

---

## ⚙️ Tecnologías Utilizadas

- **Java 21**
- **Maven**
- **JUnit 5**
- **SLF4J (Logging)**

---

## 🚀 Cómo Ejecutar el Proyecto

### 🔧 Requisitos

- Java 21 o superior
- Maven 3.6 o superior
- IDE (IntelliJ, Eclipse, VS Code)

### ▶ Ejecutar aplicación

Ejecutar la clase:

Desde el IDE o usando:


---

## 🧪 Estrategia de Pruebas

Se implementaron pruebas unitarias usando:

- `assertThrows`
- `assertDoesNotThrow`
- `assertEquals`
- `assertTrue`
---
### Patrón AAA (Arrange - Act - Assert)

```java
@Test
void testCompletarTarea_correcto() {
    // ARRANGE
    tareaService.agregarTarea(1, "Tarea", "Descripcion");

    // ACT
    tareaService.completarTarea(1);

    // ASSERT
    assertTrue(tareaService.buscarPorId(1).isEstado());
}
```
---
🧱 Reglas de Negocio

No se pueden crear tareas con ID duplicado

No se pueden usar IDs nulos o negativos

No se pueden completar tareas inexistentes

No se pueden eliminar tareas inexistentes

📝 Convenciones de Código
Nombres de pruebas
test[Metodo]_[Condicion]_[ResultadoEsperado]


Ejemplos:

- `testAgregarTarea_idDuplicado`

- `testCompletarTarea_noExiste`

- `testEliminarTarea_correcto`

---
👨‍💻 Autor

Desarrollado por Manuel Rivera

GitHub: https://github.com/ManuelRivera24