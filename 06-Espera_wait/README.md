# Per què s'atura l'execució al cap d'un temps?

Perquè els fils poden quedar bloquejats esperant una notificació (wait) si no hi ha canvis en les reserves.

# Què passaria amb probabilitats del 70% (reservar) i 30% (cancel·lar)?

Es reemplaça random.nextBoolean() (50%-50%) per random.nextInt(100) < 30, el que significa: El 30% de les vegades s'executarà ferReserva() El 70% de les vegades s'executarà cancelaReserva() Com que hi ha més cancel·lacions que reserves, les places mai estaran completament plenes i sempre hi haurà espai disponible.


Sortida:
Assistent-3 ha cancel·lat una reserva. Places disponibles: 2  
Assistent-5 ha cancel·lat una reserva. Places disponibles: 3  
Assistent-1 ha fet una reserva. Places disponibles: 2  
Assistent-2 ha cancel·lat una reserva. Places disponibles: 3  
Assistent-7 ha cancel·lat una reserva. Places disponibles: 4  
Assistent-8 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-0 ha fet una reserva. Places disponibles: 4  
Assistent-4 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-6 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-9 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-2 ha fet una reserva. Places disponibles: 4  
Assistent-7 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-1 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-0 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-3 ha fet una reserva. Places disponibles: 4  
Assistent-5 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-8 ha fet una reserva. Places disponibles: 4  
Assistent-4 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-6 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-9 ha fet una reserva. Places disponibles: 4  
Assistent-2 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-7 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-3 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-8 ha cancel·lat una reserva. Places disponibles: 5  
Assistent-1 ha fet una reserva. Places disponibles: 4  
Assistent-0 ha cancel·lat una reserva. Places disponibles: 5 
...

# Per què necessitem una llista i no només una variable de reserves?

Per identificar quin assistent ha fet una reserva i poder cancel·lar-la correctament.