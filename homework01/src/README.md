Weekend Homework #14

Zadatak 1
Napisati klasu koja predstavlja jednog fudbalskog igra�a. Klasa ima sljede�e atribute:
Ime igra�a
Godi�te
Pozicija (npr. �Forward� ili �Goalkeeper�)

Zadatak 2
Napisati klasu koja predstavlja jedan fudbalski tim. Klasa sadr�i sljede�e atribute:
Ime tima
Niz igra�a (koristiti predhodnu klasu)

Zadatak 3
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametre, jedan tim i jednu godinu. Metoda
vra�a koliko ima igra�a u datom timu toga godi�ta.
Metoda: int countPlayers(Team t, int year)

Zadatak 4
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametre, jedan tim i jednu poziciju. Metoda
vra�a koliko ima igra�a u datom timu da igra tu poziciju.
Metoda: int countPlayers(Team t, String position)

Zadatak 5
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametar, jedan tim. Metoda vra�a igra�a koji
je najmla�i u timu.
Metoda: Player getYoungestPlayer(Team t)
Sljede�i zadaci su nevezani za prethodne.
Pisati javadoc komentare!

Zadatak 6
Napisati klasu koja predstavlja jednu knjigu. Atributi su sljede�i:
Ime knjige
Godina
�anr
Da li je bestseller?

Zadatak 7
Napisati klasu koja predstavlja jednog autora. Atributi su sljede�i:
Ime autora
Godi�te
Niz knjiga koje je autor napisao

Zadatak 8
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametar, jednog autora. Metoda vra�a broj
koji odgovara broju bestseller knjiga od tog autora.
Metoda: int countBestsellingBooks(Author a)

Zadatak 9
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametre, jednog autora i dvije godine. Metoda
vra�a broj koji odgovara broju knjiga objavljenih izme�u date dvije godine (uklju�uju�i obije) od strane datog
autora.
Metoda: int getNumberOfWrittenBooks(Author a, int year1, int year2)

Zadatak 10
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametar, niz autora. Metoda vra�a autora koji
je autor imao najvi�e bestsellera iz datog niza autora.
Metoda: Author getAuthorWithMostBestsellers(Author[] authors)
Sljede�i zadaci su nevezani za prethodne.
Pisati javadoc komentare!

Zadatak 11
Napisati klasu koja predstavlja jednu �kolu. Atributi su sljede�i:
Ime �kole
Direktor (objekat koji ima atribute ime i godi�te)
Niz razreda (svaki razred ima ime i broj u�enika)

Zadatak 13
Napisati metodu koja prima, kao parametar, jednu �kolu. Metoda vra�a ime razreda koje ima najvi�e u�enika.
Metoda: String getNameOfClassWithTheMostStudents(School s)

Zadatak 14
Napisati metodu koja prima, kao parametar, niz �kola. Metoda vra�a �kolu koja ima najmla�eg direktora.
Metoda: School getSchoolWithYoungestDirector(School[] schools)

Zadatak 15
Napisati metodu koja prima, kao parametre, dvije �kole. Metoda vra�a ime �kole koja ima vi�e u�enika.
Metoda: String getNameOfSchoolWithMoreStudents(School s1, School s2)
Pisati javadoc komentare!