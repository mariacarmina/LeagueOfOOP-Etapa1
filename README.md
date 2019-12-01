# LeagueOfOOP-Etapa1
## Copyright : Cretu Maria - Carmina, 325CA

### Implementare:
  + fiecare tip de erou are cate o clasa specifica ce mosteneste clasa abstracta Hero;
  + fiecare abilitate are o clasa proprie ce mosteneste clasa abstracta Ability;
  + logica jocului este implementata in clasa GameEngine;
  + respecta principiile S.O.L.I.D.;
  + am aplicat conceptul de double-dispatch, folosindu-ma de Visitor Pattern.
  
### Design:
    
  #### Citirea datelor :
    + se face in clasa GameInputLoader.
    
  #### Harta:
    + m-am folosit de Singleton Pattern pentru a crea o singura instanta a clasei _Map_;
    + returnez terenul hartii prin metoda _getField()_.
    
  #### HeroFactory :
    + returneaza o singura instanta, utilizand din nou Singleton Pattern, a unui tip de jucator.
    
  #### Double-Dispatch :
    + in clasa abstracta Hero se regasesc 8 metode _receive(abilitate)_ corespunzatoare 
    pentru fiecare abilitate in parte;
    
    + fiecare metoda de _receive_ are calculat : 
    
      * damage-ul fara modificatori de rasa, obtinut prin metoda _getDamage()_, 
      ce exista in fiecare abilitate (util pentru Deflect);
      
      * damage-ul modificat de _amplificatorul de rasa_ specific fiecarei victime 
      care primeste atacul;
      
      * setarea efectului de overtime al unei abilitati, unde este necesar.
      
    + aceste metode sunt suprascrise in subclasele lui Hero, specificand in fiecare 
    dintre acestea, modificatorul de rasa (_multiplier_);
    
    + declansarea vizitarii se va face printr-un apel _receive_ pe o abilitate;
    
    + in fiecare abilitate, exista metoda _cast(atacator, atacat)_ in care elementul 
    curent este vizitat, prin apelul target.receive(this), unde target este inamicul 
    asupra caruia i se aplica abilitatea.
    
+---------------------------+
| Hero                      |
+---------------------------+
| - multiplier              |
+---------------------------+                               +--------------------------------+
| + receive(Ability ability)|------------------------------>| Ability                        |
+---------------------------+                               +--------------------------------+
  ^                                                         | + cast()                       |
  |                                                         | + getDamage()                  |
  |  +-------------------+                                  +--------------------------------+
  |- | Pyromancer        |                                    ^
  |  +-------------------+                                    |
  |                                                           |
  |                                                           | +------------------+
  |                                                           |-| Fireblast        |
  |  +-------------------+                                    | +------------------+
  |- | Knight            |                                    |
  |  +-------------------+                                    | +------------------+
  |                                                           |-| Ignite           |
  |  +-------------------+                                    | +------------------+
  |- | Wizard            |                                    |
  |  +-------------------+                                    | +------------------+
  |                                                           |-| Execute          |
  |                                                           | +------------------+
  |  +-------------------+                                    |    
  |- | Rogue             |                                    | +------------------+
  |  +-------------------+                                    |-| Slam             |
                                                              | +------------------+
                                                              |
                                                              | +------------------+
                                                              |-| Drain            |
                                                              | +------------------+
                                                              |
                                                              | +------------------+
                                                              |-| Deflect          |
                                                              | +------------------+
                                                              |  
                                                              | +------------------+
                                                              |-| Backstab         |
                                                              | +------------------+
                                                              |  
                                                              | +------------------+
                                                              |-| Paralysis        |
                                                                +------------------+
                                                                
     
     
  #### Abilitati :
  
    + in fiecare subclasa, se calculeaza damage-ul de baza dat de abilitatea respectiva 
    impreuna cu modificatorul de teren prin intermediul metodei _getDamage()_, 
    care este transmis in Hero, in _receive()_;
    
    + metoda _cast()_ reprezinta atacul, identificand abilitatea corespunzatoare fiecarui tip de jucator.
    
  #### Eroi :
  
    + in clasa Hero, se regaseste mecanismul de level-up descris in metodele _needToLevel_, _levelUp_ 
    si gainXP_;
    
    + in plus fata de cele 8 metode de _receive()_, explicate mai sus in Double-Dispatch, 
    fiecare clasa de erou dispune de metoda _getLandModifier()_ care atribuie bonusul de 
    teren cand este cazul;
    
    + metoda _print()_ care afiseaza stats-urile jucatorilor.
    
  #### Organizarea jocului :
  
    + in clasa GameEngine, se realizeaza logica acestui joc conform cerintei, jucatorii 
    miscandu-se pe harta conform input-ului primit si luptandu-se cand se intalnesc in 
    acelasi loc, prin intermediul unei metode, numita _battle_ care pune in aplicare 
    lupta dintre doi jucatori, ce isi folosesc reciproc abilitatile specifice;
    
   
    
    
