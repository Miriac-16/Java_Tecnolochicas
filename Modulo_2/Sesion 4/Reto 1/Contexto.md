### Reto 1: App de Movilidad Asíncrona (CompletableFuture)
- **Objetivo:** Aplicar `CompletableFuture` para simular procesos asincrónicos en una app de movilidad, realizando tareas en paralelo.
- **Contexto del Reto:** Este reto aplicó `CompletableFuture` para simular procesos asíncronos en una app de movilidad (tipo Uber o DiDi).
- **Tareas Clave:** Se realizaron tareas en paralelo como calcular la ruta óptima y estimar la tarifa, enviando una notificación al usuario una vez finalizadas. El objetivo fue encadenar estas operaciones usando `thenCombine` y manejar errores con `exceptionally`.
