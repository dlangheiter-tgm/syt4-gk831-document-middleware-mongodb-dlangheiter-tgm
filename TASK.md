# Middleware Engineering "Document Oriented Middleware using MongoDB" - Taskdescription

## Einführung

Diese Übung soll helfen die Funktionsweise und Einsatzmöglichkeiten eines dokumentenorientierten dezentralen Systems mit Hilfe des Frameworks Spring Data MongoDB zu demonstrieren. Die Daten werden in dieser Übung in einem NoSQL Repository gespeichert und verarbeitet.

Es handelt sich um die Fortsetzung von Beispiel zu Windkraftanlagen, GK7.3.3 Middleware Engineering "Message Oriented Middleware". Mit Hilfe einer REST Schnittstelle auf den Parkrechnern sollen die Daten an die Zentrale weitergegeben und hier mit Hilfe eines dokumentenorientiertem dezentralen Systems gespeichert werden. Von diesem System können die Daten für verschiedene Anwendungsfälle weiterverarbeitet werden.


## Ziele

Das Ziel dieser Übung ist die Implementierung einer dokumentenorientierten Middleware, die die Daten der Windparks zentral in einer entsprechenden Format ablegt.


## Voraussetzungen

* Grundlagen zu XML & JSON & REST
* Grundlagen Architektur von verteilten Systemen
* Grundlagen Spring Framework [Link] und Spring Boot [Link]
* Grundlagen NoSQL
* Installation MongoDB
* Implementierung der Aufgabenstellungen bis GK7.3.3 Middleware Engineering "Message Oriented Middleware"
* Umsetzung eines einfachen Web-Userinterfaces zur Anzeige von Daten


## Aufgabenstellung

Implementieren Sie eine dokumentenorientierte Middleware mit Hilfe von Spring Data MongoDB und holen Sie die aktuellen Daten der REST Schnittstelle der Parkrechner ab. Es sollen dabei keine Daten verloren gehen, sondern stets mit einem Zeitstempel und einem entsprechenden Format in der Zentrale abgespeichert werden. Bedenken Sie, dass die Daten aller Windparks und somit aller Windkraftanlagen zusammentreffen. Entwerfen Sie eine geeignet Datenstruktur, um eine kontinuierliche Speicherung der Daten zu gewährleisten.


![Windpark - Zentrale - Document Oriented Middleware](resources/windpark_dom.png)

Die Daten liegen im JSON- bzw. XML-Format am Parkrechner vor und sollen als JSON-Struktur in MongoDB gespeichert werden. In welchem Format und in welchen Zeitabständen die Daten eintreffen wird von Ihnen, als System Architekt, spezifiziert und implementiert. 

Die Daten werden in der Zentrale in einem MongoDB Repository gespeichert und können hier zu Kontrollzwecken abgerufen werden (mongo Shell). 

Ebenso soll ein einfaches Webinterface für die Zentrale implementiert werden, die die Daten anhand einer von Ihnen gewählten Fragestellung auswertet und diese im Browser darstellt. Dabei soll die einfache Verarbeitung der Daten, die im JSON Format vorliegen, aufgezeigt werden.


## Bewertung
Gruppengrösse: 1 Person
### Grundanforderungen **überwiegend erfüllt**
- [ ] Installation und Konfiguration einer dokumentenorientierten Middleware mit Hilfe von Spring Data MongoDB
- [ ] Entwurf und Umsetzung einer entsprechenden JSON Datenstruktur
- [ ] Speicherung der Daten in einem MongoDB Repository in der Zentrale
- [ ] Formulierung einer sinnvollen Fragestellung für einen Anwendungsfall in der Zentrale und deren Abfrage in einer Mongo Shell
- [ ] Umsetzung von einem Parkrechner
### Grundanforderungen **zur Gänze erfüllt**
- [ ] Konzeption und Implementierung der kontinuierlichen Speicherung der Daten (Cronjob, Scheduler, Trigger, etc.)
- [ ] Implementieren eines Webinterfaces zur Darstellung der Daten (siehe Fragestellung zu "überwiegend erfüllt")
- [ ] Umsetzung von mehreren Parkrechnern


## Fragestellung für Protokoll

+ Nennen Sie 4 Vorteile eines NoSQL Repository im Gegensatz zu einem relationalen DBMS
+ Nennen Sie 4 Nachteile eines NoSQL Repository im Gegensatz zu einem relationalen DBMS
+ Welche Schwierigkeiten ergeben sich bei der Zusammenführung der Daten?
+ Mit welchem Befehl koennen Sie die Windgeschwindigkeit von Windkraftanalage 1 vom Windpark 1 in der Shell auf 0 setzen?

## Links und Dokumente
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [MongoDB Installation](https://docs.mongodb.com/manual/administration/install-community/)
* [mongo Shell Quick Reference](https://docs.mongodb.com/manual/reference/mongo-shell/)
* [Grundlagen Spring Framework](https://spring.io/)
* [Spring Boot](https://spring.io/guides/gs/spring-boot/)
* [Spring Data MongoDB](https://projects.spring.io/spring-data-mongodb/#quick-start)
* [Spring RESTful Web Service](https://spring.io/guides/gs/rest-service/#use-maven)
