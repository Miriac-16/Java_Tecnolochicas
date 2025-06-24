### Reto 2: Acceso Controlado a Recurso Médico Crítico (ReentrantLock)
- **Objetivo:** Simular una situación hospitalaria donde múltiples profesionales médicos necesitan acceder a un recurso crítico (como una sala de cirugía), aplicando sincronización con `ReentrantLock` para evitar condiciones de carrera y garantizar la integridad del sistema.
- **Contexto del Reto:** Este reto simuló una situación hospitalaria donde múltiples profesionales médicos necesitan acceder a un recurso crítico, aplicando sincronización con `ReentrantLock`.
- **Tareas Clave:** Implementamos tareas que representan a médicos intentando usar el recurso y ejecutamos la simulación con `ExecutorService`, asegurando que solo un hilo accediera al recurso a la vez.
