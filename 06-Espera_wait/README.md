
# ¿Por qué se detiene la ejecución después de un tiempo?

Porque los hilos pueden quedar bloqueados esperando una notificación (wait) si no hay cambios en las reservas.

# ¿Qué pasaría con probabilidades de 70% (reservar) y 30% (cancelar)?

Si hay más reservas que cancelaciones, se llenará rápido y los hilos quedarán bloqueados en wait().
Con 30% reservar y 70% cancelar, siempre habrá plazas disponibles y pocos hilos esperando.

# ¿Por qué necesitamos una lista y no solo una variable de reservas?

Para identificar qué asistente hizo una reserva y poder cancelarla correctamente.
