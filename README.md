# Middleware Engineering "Document Oriented Middleware using MongoDB"

## Aufgabenstellung
Die detaillierte [Aufgabenstellung](TASK.md) beschreibt die notwendigen Schritte zur Realisierung.

## Implementierung

### Konzept
Mein Zentralrechner fragt all ~5 Sekunden alle Parkrechner ab und speichert sie in der DB.

## Fragen

#### Vorteile
* Kein unötiges speichern von null werten
* Daten müssen nicht immer im selben Format gespeichert werden.
* Besserer objektorientierter Ansatz

#### Nachteile
* Keine zwingende gleichbleibende Struktur
* Mann muss selber darauf achten das die Daten in der richten Form gespeichert werden und abgerufen.
* Besser um zu "joinen"


#### Schwirigkeiten
Die Daten so zu speichern das man es eindeutig einem Windpark und einer Windengine zuordnen kann.
Dabei habe ich in meinem Design einen Fehler gemacht, indem ich die Daten in Sub-Documents speicher.
Auf diese kann man nicht einfach algemeine Queries schreiben.

#### Windgeschwindigkeit auf 0 Setzen
Kann ich nicht :( 

## Quellen
* [Nested Documents](https://lankydanblog.com/2017/05/29/embedded-documents-with-spring-data-and-mongodb/)
* [Map in Documents](https://stackoverflow.com/questions/46466562/how-to-save-and-query-dynamic-fields-in-spring-data-mongodb)
* [Rest abfragen](https://spring.io/guides/gs/consuming-rest/)