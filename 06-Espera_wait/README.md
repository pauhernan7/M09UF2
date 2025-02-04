# Per què s'atura l'execució al cap d'un temps?

Perquè els fils poden quedar bloquejats esperant una notificació (wait) si no hi ha canvis en les reserves.

# Què passaria amb probabilitats del 70% (reservar) i 30% (cancel·lar)?

Si hi ha més reserves que cancel·lacions, l'esdeveniment s'omplirà ràpidament i els fils quedaran bloquejats en wait().
Amb un 30% per reservar i un 70% per cancel·lar, sempre hi haurà places disponibles i pocs fils esperant.

# Per què necessitem una llista i no només una variable de reserves?

Per identificar quin assistent ha fet una reserva i poder cancel·lar-la correctament.