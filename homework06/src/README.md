Object Oriented Programming

Part 1

Zadatak 1

Napraviti klasu Computer, koja je abstract. Klasa sadrži ime i MAC adresu raèunara. Pored toga, napraviti i dva konstruktora, kao i dvije get metode. MAC adresa je objekat koju opisuje unutrašnja nestatièna klasa MACAddress. Objekat tog tipa treba sadržavati niz karaktera adrese, ali bez ':'. Klasa treba imati toString metodu i konstruktor. Napraviti i equals i toString metode za Computer klasu.

Zadatak 2

Napisati klasu Network, koja je abstract. Network klasa sadrži atribut imena mreže, kao i spisak raèunara koji su u toj mreži (niz raèunara). Klasa sadrži konstruktor koji inicijalizira broj raèunara niza na 0, kao i metodu addComputer(Computer c) i removeComputer(Computer c), koje su abstract.

Zadatak 3

Napisati Server klasu koja sadrži broj koji oznaèava koliko maksimalno drugih raèunara može podnijeti a da ne doživi krah. Napraviti i jednu get metodu za taj limit. Napisati dodatni konstruktor koji inicijalizira ime, MACadresu i spomenuti limit servera. Napraviti i equals i toString metode.

Zadatak 4

Napraviti interface Connectable koji sadrži metode connect(Computer), connect(Network) i disconnect(). Client klasa sadrži atribut tipa Computer koji oznaèava sa kojim je raèunarom dati klijent spojen. Pored toga, ima još jedan slièan atribut koji je tipa Network koji oznaèava sa kojom je mrežom klijent spojen. Konstruktor klijenta treba imati samo ime i MAC adresu. Klasa implementira Connectable interface. Metoda connect treba da postavi link na dati raèunar, odnosno na datu mrežu. Ukoliko link veæ postoji onda baciti exception. Metoda disconnect postavlja oba linka na null. Napisati i get metodu za te link atribute. Napraviti i equals i toString metode.

Napomena: Client se nikada ne može spojiti na drugu mrežu/raèunar ako mu oba atributa nisu null!

Zadatak 5

Napraviti demonstraciju svih klasa i metoda iz prijašnja èetiri zadatka.

Napisati javadoc za sve metode (nije potrebno za equals i toString metode).

Part 2

Zadatak 1

Napraviti interface Functionable koji ima metodu boolean isFunctioning().

Zadatak 2

Napraviti klasu ArrayManipulation koja sadrži static metodu extendArray(Computer[]) koja proširi dati niz za jedan index/element. Novi element treba biti null. Pored toga, tu se nalazi i metoda shrinkArray(Computer[], int) koja smanji dati niz za jedan tako što „obriše“ dati index.

Zadatak 3

Napraviti klasu BusNetwork koja nasljeðuje Network klasu i implementira Functionable interface. Metoda addComputer radi na principu tako što proširi prvo niz raèunara za jedan, zatim stavi dati raèunar na to mjesto i povezuje raèunar preko njegove connect metode sa ovom mrežom. Metoda removeComputer radi na principu tako što prvo pronaðe dati raèunar (ako ga nema baciti exception) i obriše ga (smanji niz). Pored toga, raèunar prekida svoju vezu sa mrežom preko svoje disconnect metode.

Metoda isFunctioning treba vratiti true ukoliko ima barem dva raèunara spojena na mreži (da nisu null). toString metoda treba imati broj raèunara u sebi, kao i dio koji govori da li mreža funkcioniše ili ne.

Zadatak 4

Napraviti klasu StarNetwork koja nasljeðuje Network klasu i implementira Functionable interface. Klasa sadrži jedan Server. Metoda addComputer radi na principu tako što proširi prvo niz raèunara za jedan, zatim stavi raèunar na to mjesto. Pored toga, dati raèunar se povezuje preko connect metode sa serverom preko svoje connect metode. Metoda removeComputer radi na principu tako što prvo pronaðe dati raèunar (ako ga nema baciti exception) i obriše ga (smanji niz). Pored toga, dati raèunar prekida link sa serverom preko svoje disconnect metode. Metoda isFunctioning treba vratiti true ukoliko server radi. Server pada ukoliko ima više povezanih raèunara nego što može podnijeti. toString metoda treba imati broj spojenih raèunara na server u sebi, kao i dio koji govori da li mreža funkcioniše ili ne.

Zadatak 5

Napisati javadoc za sve metode osim toString i equals metode. Napisati demonstraciju svih metoda!