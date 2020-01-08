# LeagueOfOOP
## Copyright : Cretu Maria - Carmina, 325CA

### Implementare :

+ fiecare tip de erou are cate o clasa specifica ce mosteneste clasa abstracta Hero;

+ fiecare abilitate are o clasa proprie ce mosteneste clasa abstracta Ability;

+ logica jocului este implementata in clasa GameEngine;

+ am aplicat conceptul de double-dispatch pentru lupta dintre eroi;

+ fiecare tip de inger are cate o clasa specifica ce mosteneste clasa abstracta Angel;

#### Ce este nou?

+ am folosit urmatoarele design pattern-uri : _Visitor Pattern_, _Strategy Pattern_ si
 _Observer Pattern_;

### Design :

#### Ce este nou?

##### AngelFactory :

+ returneaza o singura instanta, utilizand din nou _Singleton Pattern_, a unui tip de inger;

+ este utilizat, de asemenea, _Factory Pattern_.

##### Ingeri :

+ fiecare clasa contine 4 metode de _visit_ particularizate;

+ se retin urmatoarele: coordonatele ingerului si tipul acetuia.

##### Visitor Pattern :

+ am implementat in fiecare clasa ce apartine unui tip de inger metodele de _visit_ cu implementarea 
specifica din enunt, avand ca parametru, tipul de erou pe care urmeaza sa il viziteze;

+ in fiecare clasa de erou, apare o metoda de _accept_, care modifica pentru eroul respectiv,
_modificatorii de damage_/_XP_/_HP_.

##### Strategy Pattern :

+ in pachetul _heroes_, am adaugat clasa abstracta _HeroStrategy_, ce contine cele doua startegii 
ale fiecarui erou : _attack_ si respectiv,_defense_ si o metoda _choose_ care activeaza o anumita 
strategie in functie de _HP-ul curent_ al jucatorului.

+ observand faptul ca startegiile eroilor au un comportament asemantor, am decis sa trasmit ca 
parametrii in constructor, datele care variaza precum :

- _limita inferioara_(_minLimit_) pentru intervalul strategiei _attack_;

- _limita superioara_(_maxLimit_) pentru intervalul strategiei _attack_;

- _modificarea coeficientilor de damage pentru strategia de attack_(_attackBoost_);

- _modificarea coeficientilor de damage pentru strategia de defense_(_defenseBoost_);

- _pierderea de HP_(_lossHP_) specifica strategiei de _attack_;

- _castigarea de HP_(_winHP_) specifica strategiei de _defense_;

+ am creat pentru fiecare tip de erou, 4 clase(_KnightStrategy_, _PyromancerStrategy_,
 _RogueStrategy_ si _WizardStrategy_) pentru a particulariza strategiile in functie de 
 parametrii descrisi mai sus;

##### Observer Pattern :

+ pentru realizarea acestui pattern, am creat pachetul _observer_, ce dispune de doua interfete: 
_Observer_ si _Subject_;

+ _Observer_ reprezinta observatorul ce trebuie notificat, care este implementat de catre 
_TheGreatestMagician_;

+ in clasa specifica _Marelui Magician_ am utilizat _Singleton Pattern_ pentru a crea o singura 
instanta a acestuia;

+ interfata _Subject_ reprezinta obiectul observabil si este implementata de catre clasa _Angel_, 
implicit de clasele care o mostenesc si de catre _Hero_, implicit de tipurile de eroi;

+ in plus fata de _observer_, exista pachetul _events_, care are la baza interfata _Event_ si clasele ce o 
implementeaza;

+ am tratat situatiile precum : comportamentul ingerilor in joc si lupta jucatorilor ca pe niste evenimente:

- _Spawn_ notifica aparitia unui inger pe harta;

- _Helped/Hit_ verifica daca un erou a fost ajutat, respectiv incurcat de catre un inger;

- _LevelUp_ verifica cand un jucator a avansat la urmatorul sau urmatoarele nivel/e;

- _Kill_ anunta faptul ca un erou si-a omorat victima;

- _KilledByAngel_ ii permite Marelui Magician sa afle ce erou a fost omorat de catre un inger;

- _BackToLife_ notifica invierea unui jucator de catre un inger.

+ _Observer_ are metoda de _update_ avand ca parametru evenimentul de tip _Event_, ce este implementata
in _TheGreatestMagician_ si scrie in fisier evenimentele ce au avut loc in timpul jocului;

+ _Subject_ contine doua metode:

- _registerObserver()_, ce stabileste cine poarta rolul de _observer_;

- _updateObserver()_, ce instiinteaza adminul cu privire la ce se intampla in joc.
 
#### Citirea datelor :
+ se face in clasa GameInputLoader.

#### Harta :
+ m-am folosit de Singleton Pattern pentru a crea o singura instanta a clasei _Map_;

+ returnez terenul hartii prin metoda _getField()_.

#### HeroFactory :
+ returneaza o singura instanta, utilizand din nou _Singleton Pattern_, a unui tip de jucator.

#### Double-Dispatch :
+ in clasa abstracta Hero se regasesc 8 metode _receive(abilitate)_ corespunzatoare 
pentru fiecare abilitate in parte;

+ fiecare metoda de _receive_ executa urmatoarele actiuni: 

* calculeaza damage-ul fara modificatori de rasa, obtinut prin metoda _getDamage()_, 
ce exista in fiecare abilitate (util pentru Deflect);

* calculeaza damage-ul modificat de _amplificatorul de rasa_ specific fiecarei victime 
care primeste atacul;

* seteaza efectul de overtime al unei abilitati, unde este necesar.

+ aceste metode sunt suprascrise in subclasele lui Hero, specificand in fiecare 
dintre acestea, modificatorul de rasa (_multiplier_);

+ in fiecare abilitate, exista metoda _cast(atacator, atacat)_ in care elementul 
curent este vizitat, prin apelul target.receive(this), unde target este inamicul 
asupra caruia i se aplica abilitatea.

#### Abilitati :

+ in fiecare subclasa, se calculeaza damage-ul de baza dat de abilitatea respectiva 
impreuna cu modificatorul de teren prin intermediul metodei _getDamage()_, 
care este transmis in _Hero_, in _receive()_;

+ metoda _cast()_ reprezinta atacul, identificand abilitatea corespunzatoare fiecarui tip de jucator.

#### Eroi :

+ in clasa Hero, se regaseste mecanismul de level-up descris in metodele _needToLevel_, _levelUp_ 
si _gainXP_;

+ in plus fata de cele 8 metode de _receive()_, explicate mai sus in Double-Dispatch, 
fiecare clasa de erou dispune de metoda _getLandModifier()_ care atribuie bonusul de 
teren cand este cazul;

+ am adaugat campurile _angelMultiplier_ si _strategyMultiplier_ ce actualizeaza modificatorii 
primiti de la ingeri, respectiv strategie;

+ metoda _print()_ care afiseaza stats-urile jucatorilor.

#### Constante :

+ clasa _Constants_ este publica si statica, continand "numerele magice".

#### Organizarea jocului :

+ in clasa _GameEngine_, se realizeaza logica acestui joc conform cerintei, jucatorii 
miscandu-se pe harta conform input-ului primit si luptandu-se cand se intalnesc in 
acelasi loc, prin intermediul unei metode, numita _battle_ care pune in aplicare 
lupta dintre doi jucatori, ce isi folosesc reciproc abilitatile specifice;

#### Afisarea datelor :

+ in clasa _FileLogger_, returneaza o singura instanta ce poate fi accesata prin metoda _getLogger_,
utilizand din nou _Singleton Pattern_ cu scopul de a fi vizibila ;

+ cu ajutorul metodei _write_, se scrie output-ul in fisier;

+ prin intermediul metodei _close_, se incheie activitatea _Writer-ului out_.




