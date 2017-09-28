#language: nl
@CukeWorkshop
Functionaliteit: Toelichting leningen

  Abstract Scenario: Als klant wil ik kunnen verifieren dat de ingevulde gegevens juist zijn
    Gegeven de klant kiest voor een "<leningtype>" van "<bedrag>" euro
    Als de klant zijn keuze bevestigd
    Dan kan de klant de informatie over de lening verifieren
    Voorbeelden:
      | leningtype   | bedrag |
      | Flitskrediet | 300    |
      | Persoonlijk  | 1500   |
      | Doorlopend   | 2500   |
      | Autolening   | 2000   |
      | WOZ-krediet  | 10000  |
      | Hypotheek    | 50000  |

  Scenario: Als onervaren lener wil ik informatie over lenen
    Gegeven de klant heeft gekozen voor een lening
    Als de klant aangeeft geen ervaring te hebben met lenen
    Dan wordt de wettelijke informatie over lenen wel getoond

  Scenario: Als ervaren lener hoef ik geen informatie over lenen
    Gegeven de klant heeft gekozen voor een lening
    Als de klant aangeeft wel ervaring te hebben met lenen
    Dan wordt de wettelijke informatie over lenen niet getoond

