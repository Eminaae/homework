Zadaci za vježbe

Programming with Objects

Zadatak 1
Napisati klasu koja opisuje temperaturu napolju. Temperatura je spremljena u jedan atribut, u °C.
Napisati konstruktor koji inicijalizira vrijednost temperature
Napisati metodu getTemperatureInC() koja vraæa temperaturu u Celzijusima
Napisati metodu getTemperatureInK() koja vraæa temperaturu u Kelvinima
Napisati metodu getTemperatureInF() koja vraæa temperaturu u Farenhajtim
Napisati metodu setTemperature(int) koja postavlja vrijednost temperature
Napisati javadoc za sve metode

Zadatak 2
Napisati klasu koja opisuje èašu. Èaša prima samo jednu vrstu teènosti. Dati objekat opisuju tri atributa, vrsta
teènosti, kolièinu teènosti i maksimalnu kolièinu teènosti.
Napisati konstruktor koji inicijalizira kolièinu na 0, vrstu na null i max. kolièinu na datu vrijednost
Napisati metodu getTypeOfLiquid() koja vraæa tip teènosti koji se nalazi u èaši
Napisati metodu getMaxCapacity() koja vraæa maksimalni kapacitet èaše
Napisati metodu getCurrentCapacity() koja vraæa trenutni kapacitet èaše
Napisati metodu addLiquid(String, int) koja dodaje neku kolièinu nekog tipa teènosti u èašu
o Ukoliko èaša sadrži teènost koja nije kao data onda ništa ne raditi
o Ukoliko èaša sadrži teènost koja je i data onda poveæati za datu kolièinu
Svaki višak teènosti se „prelije“ i trenutni kapacitet bude isti kao i maksimalni
Napisati metodu emptyGlass() koja „prospe“ svu teènost iz èaše
Napisati javadoc za sve metode

Zadatak 3
Napisati klasu koja opisuje jedan printer. Printer ima sljedeæe atribute:
Ime printera
Kolièina papira u printeru
Kolièina tinte u printeru
Ukupno isprintano stranica
Printer ima sljedeæe konstruktore:
Prazni konstruktor koji inicijalizira ime na „DefaultPrinter“, a kolièinu papira i tinte na 0
Konstruktor koji inicijalizira ime na dati parametar, a kolièinu papira i tinte na 0
o Oba konstruktora inicijaliziraju ukupno isprintano stranica na 0
Printer ima sljedeæe metode:
Metoda koja vraæa da li ima tinte (true/false)
Metoda koja vraæa da li ima papira (true/false)
Metoda koja vraæa koliko je ukupno isprintano stranica od tog printera
Metoda koja dodaje papira u printer (void metoda)
o Uzeti u obzir da se ne može imati više od 100 papira u printeru
Metoda koja napuni tintu na max. (void metoda)
o Maksimalno tinte je 100
Metoda koja „printa“ stranice papira (void metoda)
o Metoda prima int parametar koji predstavlja koliko stranica isprintati
o Za svaku isprintanu stranicu oduzeti jedan papir iz printera
o Za svaku isprintanu stranicu oduzeti tri iz atributa tinta
o Ukoliko nema papira ili ako nema tinte onda ne treba printati
Pored toga Printer klasa sadrži sljedeæe:
toString metodu koja printa ime printera i trenutno stanje
o Stanje može biti „Ready“, „No ink“, „No paper“, „No ink nor paper“
static varijablu koja bilježi koliko ukupno stranica je isprintano
Napisati i metodu koja vraæa vrijednost te varijable
Napisati malu demonstraciju rada vaše klase u main metodi.