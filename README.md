# M09UF2
# Activitat 01: Programació de Fils

## Introducció

Aquesta activitat introdueix la programació concurrent en Java mitjançant l'ús de fils. Es tracta de fer que dues instàncies de la classe Fil (una per a "Juan" i una altra per a "Pepe") es comportin de diferents maneres segons les especificacions. El codi simula tres comportaments de concurrència utilitzant diverses tècniques de control de fils.

Comportaments Implementats

## Comportament 1: Execució Intercalada

Els fils "Juan" i "Pepe" s'executen de manera intercalada de forma no estricta. Això es controla deixant que el sistema operatiu decideixi l'ordre d'execució dels fils, sense cap mecanisme addicional.

Exemple de sortida:

Main thread finalitzat.
Juan 1
Pepe 1
Juan 2
Pepe 2
...
Termina el fil Juan
Termina el fil Pepe

Mecanisme Utilitzat:
Es creen els fils sense cap prioritat o control addicional. El sistema operatiu planifica l'execució.

## Comportament 2: Primer Pepe, Després Juan

El fil "Pepe" s'executa completament abans que el fil "Juan". Això es fa ajustant les prioritats dels fils.

Exemple de sortida:

Main thread finalitzat.
Pepe 1
Pepe 2
...
Pepe 9
Termina el fil Pepe
Juan 1
...
Termina el fil Juan

Mecanisme Utilitzat:
S'estableix una prioritat màxima per a "Pepe" (Thread.MAX_PRIORITY) i una prioritat mínima per a "Juan" (Thread.MIN_PRIORITY). Això augmenta les probabilitats que "Pepe" acabi abans.

## Comportament 3: Execució Alterna Estricta

Els fils s'executen de manera alterna (Juan -> Pepe -> Juan -> ...). Això es garanteix mitjançant un mecanisme de control de torns.

Exemple de sortida:

Main thread finalitzat.
Juan 1
Pepe 1
Juan 2
Pepe 2
...
Juan 9
Pepe 9
Termina el fil Juan
Termina el fil Pepe

Mecanisme Utilitzat:
Una variable compartida (tornActual) s'utilitza per sincronitzar l'execució dels fils. Només el fil amb el torn actual pot executar-se. Els altres fils cedeixen el control mitjançant Thread.yield().

## Conclusions

Aquest exercici mostra com gestionar fils en Java i les diferències en els resultats segons el mecanisme de control emprat. Això introdueix conceptes bàsics de concurrència, com ara la planificació de fils i la sincronització.
