Weekend Homework #14

Zadatak 1
Napisati klasu koja predstavlja jednog fudbalskog igraèa. Klasa ima sljedeæe atribute:
Ime igraèa
Godište
Pozicija (npr. „Forward“ ili „Goalkeeper“)

Zadatak 2
Napisati klasu koja predstavlja jedan fudbalski tim. Klasa sadrži sljedeæe atribute:
Ime tima
Niz igraèa (koristiti predhodnu klasu)

Zadatak 3
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametre, jedan tim i jednu godinu. Metoda
vraæa koliko ima igraèa u datom timu toga godišta.
Metoda: int countPlayers(Team t, int year)

Zadatak 4
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametre, jedan tim i jednu poziciju. Metoda
vraæa koliko ima igraèa u datom timu da igra tu poziciju.
Metoda: int countPlayers(Team t, String position)

Zadatak 5
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametar, jedan tim. Metoda vraæa igraèa koji
je najmlaði u timu.
Metoda: Player getYoungestPlayer(Team t)
Sljedeæi zadaci su nevezani za prethodne.
Pisati javadoc komentare!

Zadatak 6
Napisati klasu koja predstavlja jednu knjigu. Atributi su sljedeæi:
Ime knjige
Godina
Žanr
Da li je bestseller?

Zadatak 7
Napisati klasu koja predstavlja jednog autora. Atributi su sljedeæi:
Ime autora
Godište
Niz knjiga koje je autor napisao

Zadatak 8
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametar, jednog autora. Metoda vraæa broj
koji odgovara broju bestseller knjiga od tog autora.
Metoda: int countBestsellingBooks(Author a)

Zadatak 9
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametre, jednog autora i dvije godine. Metoda
vraæa broj koji odgovara broju knjiga objavljenih izmeðu date dvije godine (ukljuèujuæi obije) od strane datog
autora.
Metoda: int getNumberOfWrittenBooks(Author a, int year1, int year2)

Zadatak 10
Napisati metodu (u klasi gdje je main metoda) koja prima, kao parametar, niz autora. Metoda vraæa autora koji
je autor imao najviše bestsellera iz datog niza autora.
Metoda: Author getAuthorWithMostBestsellers(Author[] authors)
Sljedeæi zadaci su nevezani za prethodne.
Pisati javadoc komentare!

Zadatak 11
Napisati klasu koja predstavlja jednu školu. Atributi su sljedeæi:
Ime škole
Direktor (objekat koji ima atribute ime i godište)
Niz razreda (svaki razred ima ime i broj uèenika)

Zadatak 13
Napisati metodu koja prima, kao parametar, jednu školu. Metoda vraæa ime razreda koje ima najviše uèenika.
Metoda: String getNameOfClassWithTheMostStudents(School s)

Zadatak 14
Napisati metodu koja prima, kao parametar, niz škola. Metoda vraæa školu koja ima najmlaðeg direktora.
Metoda: School getSchoolWithYoungestDirector(School[] schools)

Zadatak 15
Napisati metodu koja prima, kao parametre, dvije škole. Metoda vraæa ime škole koja ima više uèenika.
Metoda: String getNameOfSchoolWithMoreStudents(School s1, School s2)
Pisati javadoc komentare!