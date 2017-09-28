#language: nl
@CukeWorkshop
Functionaliteit: Lening aanvraagscherm

  Abstract Scenario: Als klant wil ik informatie over lenen met betrekking tot mijn bestedingsdoel
    Gegeven de klant wil informatie over een lening
    Als de klant een lening wil voor "<leningtype>"
    Dan krijgt de klant de informatie tekst "<doelinformatie>"
    Voorbeelden:
      | leningtype         | doelinformatie                                                                                               |
      | Boodschappen       | U kunt wellicht beter geen lening nemen als deze enkel voor boodschappen bedoeld is.                         |
      | Beleggingen        | U kunt wellicht beter geen lening nemen als deze enkel voor beleggingen bedoeld is.                          |
      | Rekeningen betalen | Waarschijnlijk is een Doorlopend krediet of een Persoonlijke lening de beste keus voor u.                    |
      | Meubels            | Waarschijnlijk is een Flitskrediet of een Persoonlijke lening de beste keus voor u.                          |
      | Auto               | Voor de aankoop van een auto is de Autolening de beste keus.                                                 |
      | Verbouwing         | Bij een verbouwing aan een huis is een Persoonlijke lening, Doorlopend krediet of WOZ-krediet de beste keus. |
      | Huis               | Voor een huis is een Hypotheek de beste keus qua lening.                                                     |

  Abstract Scenario: Als klant wil ik kunnen aangeven hoeveel ik wil lenen met welk type lening
    Gegeven de klant heeft een leningkeuze gemaakt
    Als de klant kiest voor een "<leningtype>" van "<bedrag>" euro
    Dan kan de klant zijn keuze bevestigen
    Voorbeelden:
      | leningtype          | bedrag |
      | Flitskrediet        | 300    |
      | Persoonlijke lening | 1500   |
      | Doorlopend krediet  | 2500   |
      | Autolening          | 2000   |
      | WOZ-krediet         | 10000  |
      | Hypotheek           | 50000  |
