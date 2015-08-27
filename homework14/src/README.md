TASK #1 – KNJIGA ŽALBI

Napraviti dvije GUI aplikacije, jedna koja bilježi žalbe (za mušterije), a druga koja prikazuje sve te žalbe (za osoblje).

Žalbe se trebaju stavljati u bazu podataka (SQL) i potrebno je bilježiti (automatski) u koje se vrijeme i na koji datum postavila žalba, kao i uneseni tekst žalbe. Naravno, neka vrsta ID-a se mora implementirati da bude u bazi i da se automatski mijenja.

Izgled aplikacije je proizvoljan.

TASK #2 – UNOŠENJE ARTIKALA

Napraviti GUI aplikaciju preko koje se unose artikli u bazu podataka. Artikli sadrže poseban code u obliku deset cifara (mogu biti nule na poèetku), koji je unikatan za svaki artikal, ime, kao i cijenu artikla. Preko GUI aplikacije se unose sve te informacije o artiklu.

Bitno je naglasiti da se treba ispisati greška ako postoji isti artikal (isti code), a ukoliko postoji isto ime samo ispisati upozorenje i pitati korisnika da li je siguran da æe to uraditi.

Sve moguæe smetnje je potrebno otkloniti, poput onih koje nastaju kada se pogrešna informacija upiše, npr. code ima slova ili nema deset cifara.

TASK #3 – BRISANJE ARTIKALA

Napraviti GUI aplikaciju, baziranu na prethodnoj, koja briše jedan od ponuðenih artikala. Artikal se ponudi korisniku za brisanje (npr. preko JList ili JComboBox), a zatim korisnik pritisne dugme obriši i taj artikal se obriše iz baze podataka.