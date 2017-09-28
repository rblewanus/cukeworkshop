#language: nl
Functionaliteit: Voorbeeldstappen

  Scenario: voorbeeld met variabele en keuze
    Als iets met wel lenen
    Als iets met niet lenen
    Gegeven een vrije variabele

  Abstract Scenario: voorbeeld van abstract scenario
    Gegeven er wordt een browser geopend met een oefenwebsite
    Als er geklikt wordt op de knop met id <knopId>
    Dan is de tekst <tekst> zichtbaar
    Voorbeelden:
      | knopId | tekst                          |
      | knop2  | Scherm 2 is gevonden!          |
      | knop3  | Het derde scherm is gevondenø! |

  Scenario: voorbeelden met datatables onder de stappen
    Gegeven datatable met lening naar een list omzetten
      | leningtype   | bedrag |
      | Flitskrediet | 350    |
    Gegeven datatable met lening direct in een leninglijst
      | leningtype | bedrag |
      | Hypotheek  | 320000 |
      | Autolening | 2001   |

