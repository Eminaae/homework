Zadaci za vje�be

Programming with Objects

Zadatak 1
Napisati klasu koja opisuje temperaturu napolju. Temperatura je spremljena u jedan atribut, u �C.
Napisati konstruktor koji inicijalizira vrijednost temperature
Napisati metodu getTemperatureInC() koja vra�a temperaturu u Celzijusima
Napisati metodu getTemperatureInK() koja vra�a temperaturu u Kelvinima
Napisati metodu getTemperatureInF() koja vra�a temperaturu u Farenhajtim
Napisati metodu setTemperature(int) koja postavlja vrijednost temperature
Napisati javadoc za sve metode

Zadatak 2
Napisati klasu koja opisuje �a�u. �a�a prima samo jednu vrstu te�nosti. Dati objekat opisuju tri atributa, vrsta
te�nosti, koli�inu te�nosti i maksimalnu koli�inu te�nosti.
Napisati konstruktor koji inicijalizira koli�inu na 0, vrstu na null i max. koli�inu na datu vrijednost
Napisati metodu getTypeOfLiquid() koja vra�a tip te�nosti koji se nalazi u �a�i
Napisati metodu getMaxCapacity() koja vra�a maksimalni kapacitet �a�e
Napisati metodu getCurrentCapacity() koja vra�a trenutni kapacitet �a�e
Napisati metodu addLiquid(String, int) koja dodaje neku koli�inu nekog tipa te�nosti u �a�u
o Ukoliko �a�a sadr�i te�nost koja nije kao data onda ni�ta ne raditi
o Ukoliko �a�a sadr�i te�nost koja je i data onda pove�ati za datu koli�inu
Svaki vi�ak te�nosti se �prelije� i trenutni kapacitet bude isti kao i maksimalni
Napisati metodu emptyGlass() koja �prospe� svu te�nost iz �a�e
Napisati javadoc za sve metode

Zadatak 3
Napisati klasu koja opisuje jedan printer. Printer ima sljede�e atribute:
Ime printera
Koli�ina papira u printeru
Koli�ina tinte u printeru
Ukupno isprintano stranica
Printer ima sljede�e konstruktore:
Prazni konstruktor koji inicijalizira ime na �DefaultPrinter�, a koli�inu papira i tinte na 0
Konstruktor koji inicijalizira ime na dati parametar, a koli�inu papira i tinte na 0
o Oba konstruktora inicijaliziraju ukupno isprintano stranica na 0
Printer ima sljede�e metode:
Metoda koja vra�a da li ima tinte (true/false)
Metoda koja vra�a da li ima papira (true/false)
Metoda koja vra�a koliko je ukupno isprintano stranica od tog printera
Metoda koja dodaje papira u printer (void metoda)
o Uzeti u obzir da se ne mo�e imati vi�e od 100 papira u printeru
Metoda koja napuni tintu na max. (void metoda)
o Maksimalno tinte je 100
Metoda koja �printa� stranice papira (void metoda)
o Metoda prima int parametar koji predstavlja koliko stranica isprintati
o Za svaku isprintanu stranicu oduzeti jedan papir iz printera
o Za svaku isprintanu stranicu oduzeti tri iz atributa tinta
o Ukoliko nema papira ili ako nema tinte onda ne treba printati
Pored toga Printer klasa sadr�i sljede�e:
toString metodu koja printa ime printera i trenutno stanje
o Stanje mo�e biti �Ready�, �No ink�, �No paper�, �No ink nor paper�
static varijablu koja bilje�i koliko ukupno stranica je isprintano
Napisati i metodu koja vra�a vrijednost te varijable
Napisati malu demonstraciju rada va�e klase u main metodi.