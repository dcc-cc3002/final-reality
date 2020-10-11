Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

Una vez cargado el projecto, se procede a correr el archivo build.grandle.kts, con lo cual el projecto estará listo para correr. Inicialmente, se crearon las interfases ICharacter y Iweapon, los cuales conforman la base del juego. Cada una fue implementada en una clase abstracta, donde se definian los métodos antes descritos en las interfases correspondientes. A partir de estas clases abstractas, se especializaron distintas clases con sus propios atributos y métodos, tal es el caso de AbstractCharacter, el cual se especializa en PlayerCharacter y Enemy.
