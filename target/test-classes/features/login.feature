Feature: Login na aplikaciju

Scenario: Pocetna strana default Login
Given Inicijalizovan je driver
And User je na pocetnoj strani "http://www.samsvojmajstor.com/portal"
And Odabran je link za logovanje
When User se loguje na aplikaciju koristeci user "amel2507" i password "ameljasari"
Then Verifikujemo da se pojavilo dugme Odjava
And Odjavljujemo se sa stranice
And Zatvaranje explorera

Scenario Outline: Pocetna strana default Login Negativni testovi
Given Inicijalizovan je driver
And User je na pocetnoj strani "http://www.samsvojmajstor.com/portal"
And Odabran je link za logovanje
When Negativni user se loguje na aplikaciju koristeci user <username> i password <password>
Then Prikazuje se poruka za neispravan login
And Zatvaranje explorera


Examples: 
| username | password    |
| amel2507 |  asdasda    |
| asdasdaa |  ameljasari |