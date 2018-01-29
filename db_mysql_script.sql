Drop Database if exists quizgame;
Create Database quizgame;
Use quizgame;

CREATE TABLE quizcontent (
  Id int primary key auto_increment,
	Frage varchar(255),
	RichtigeAntwort varchar(255),
	Antwort2 varchar(255),
	Antwort3 varchar(255),
	Antwort4 varchar(255),
	Thema varchar(255),
	S_Stufe int(11)
);

INSERT INTO quizcontent (Frage, RichtigeAntwort, Antwort2, Antwort3, Antwort4, Thema, S_Stufe) VALUES
("Wie heißt ein Linux Bootmanager?", "LILO (Linux Loader)", "LIBO (Linux Booter)", "BOLI (Boot Linux)", "LIST (Linux Starter)", "Betriebssysteme", 4),
("Mit welchem der folgenden Programme kopiert man in Windows am einfachsten Dateien und Ordner?", "Windows Explorer", "Eingabeaufforderung", "Internet Explorer", "Notepad", "Betriebssysteme", 2),
("Wie heißt das Standard Dateisystem der derzeitigen Mac Betriebssysteme?", "HFS+", "NTFS", "FAT", "ext2", "Betriebssysteme", 4),
("Wie wird ein Programm bezeichnet, dass z.B. Musikdateien im Webbrowser abspielt?", "Plugin", "Plug and Play", "Peer to Peer", "Proxy", "Betriebssysteme", 2),
("Wofür steht die Dateinamenserweiterung .exe?", "Ausführbare Datei", "Systemdatei", "Verknüpfung", "Batchdatei", "Betriebssysteme", 1),
("Welches der folgenden Zeichen darf ein Windows Dateiname nicht enthalten?", "?", "ä", "$", "%", "Betriebssysteme", 3),
("Wofür steht ME in Microsoft Windows ME?", "Millennium Edition", "Maxi Edition", "Multi Edition", "Mega Edition", "Betriebssysteme", 2),
("Wofür steht die Dateinamenserweiterung .sys?", "Systemdatei", "Source", "Shell", "Sicherungskopie", "Betriebssysteme", 2),
("Wie heißt der Begründer von Linux?", "Linus Torvalds", "Louis Torvalds", "Linus Johnson", "Louis Johnson", "Betriebssysteme", 2),
("Was ist das Maskottchen von Linux?", "Ein Pinguin", "Ein Bär", "Ein Apfel", "Ein Fenster", "Betriebssysteme", 1),
("Mit welcher Tastenkombination wechselt man in Windows zwischen verschiedenen Fenstern?", "Alt + Tabulator", "Strg + Alt + Entf", "Strg + Tabulator", "Alt + Shift", "Betriebssysteme", 1),
("Wann wurde Mac OS X 10.5 (Leopard) veröffentlicht?", "2007", "2005", "2006", "2008", "Betriebssysteme", 5),
("Wie heißt das Menü welches man in Windows über die rechte Maustaste aufruft?", "Kontextmenü", "Startmenü", "Seitenmenü", "Programmmenü", "Betriebssysteme", 1),
("Wie lautet die Versionsnummer von Microsoft Windows Vista?", "NT 6.0", "NT 5.0", "NT 5.1", "NT 7.0", "Betriebssysteme", 5),
("Was bedeutet die Abkürzung DOS?", "Disk Operating System", "Digital Operating System", "Digital Office System", "Disk Office System", "Betriebssysteme", 2),


("Wenn ein Datensatz auf mehrere andere Datensätze verweist liegt welche Beziehung vor?", "1:n Beziehung", "1:1 Beziehung", "n:m Beziehung", "Dies ist nicht möglich", "Datenbanken", 1),
("Was ist ein Tupel?", "Ein kompletter Datensatz", "Ein einziges Datenfeld", "Eine Spalte der Tabelle", "Eine gesamte Tabelle", "Datenbanken", 3),
("Was bedeutet Datenredundanz?", "Mehrfachnennungen eines Wertes in der Datenbank", "Mehrere Nutzer können gleichzeitig auf die Datenbank zugreifen", "Wenn jeder Wert nur einmal in der Datenbank vorkommt", "Unsinnige Daten sollen erkannt werden z.B. 31 Feb.", "Datenbanken", 1),
("Was ist ein Attribut?", "Eine Spalte der Tabelle", "Ein kompletter Datensatz", "Ein einziges Datenfeld", "Eine gesamte Tabelle", "Datenbanken", 2),
("Was ist der Vorname in einer Kundentabelle?", "Ein Attribut", "Der Primärschlüssel", "Eine Relation", "Ein Attributwert", "Datenbanken", 2),
("Wann liegt eine Inkonsistenz vor?", "ein Fremdschlüssel den Wert Null besitzt", "Attributwert kommt mehrfach in der Datenbank vor", "mehrere Benutzer greifen gleichzeitig auf die Datebank zu", "ein Attributwert den Wert Null besitzt", "Datenbanken", 2),
("Was ist mit der SQL Anweisung UPDATE möglich?", "Man kann einen oder mehrere Datensätze aktualisieren", "Man kann genau einen Datensatz aktualisieren", "Man kann genau einen Datensatz löschen", "Man kann einen oder mehrere Datensätze löschen", "Datenbanken", 2),
("Wie wird eines der gängigsten Datenbank-Systeme bezeichnet?", "Relationale Datenbanksysteme", "Rationale Datenbanksysteme", "Rudimentäre Datenbanksysteme", "Robuste Datenbanksysteme", "Datenbanken", 2),


("Wie hoch ist die Kapazität einer DVD-5?", "4,7 GB ", "8,5 GB", "9,4 GB", "13,2 GB", "Datensicherheit", 4),
("Wie viele Medien benötigt man bei einem Backup nach dem Großvater - Vater - Sohn - Prinzip (Vorhaltezeit 3 Monate)?", "10 Medien", "6 Medien", "7 Medien", "3 Medien", "Datensicherheit", 3),
("Was bedeutet das RAID Level 1?", "Zwei Festplatten mit demselben Inhalt", "Zwei Festplatten werden zu einer großen zusammengefasst", "Eine Kombination aus den ersten beiden", "Eine zusätzliche Festplatte wird als Backup genutzt", "Datensicherheit", 1),
("Welches der folgenden Medien ist für ein Backup nach dem Großvater - Vater - Sohn - Prinzip am besten geeignet?", "DLT", "DVD - R", "ZIP Diskette", "CD - R", "Datensicherheit", 4),
("Wie wird die Kombination aus Raid Level 0 und Raid Level 1 genannt?", "Raid Level 10", "Raid Level 5", "Raid Level 4", "Raid Level 11", "Datensicherheit", 3),
("Welches der folgenden Bandlaufwerke hat die größte Kapazität?", "Advanced Intelligent Tape (AIT)", "Digital Data Storage (DDS)", "Digital Linear Tape (DLT)", "Quarter-Inch Cartridge (QIC)", "Datensicherheit", 4),
("Wie viele Festplatten werden für ein Raid System Level 5 mindestens benötigt?", "3 Festplatten", "2 Festplatten", "4 Festplatten", "5 Festplatten", "Datensicherheit", 2),
("Welchen Vorteil hat eine Magneto Optical Disk?", "Höhere Datensicherheit gegenüber einer DVD-RAM", "Sehr günstig im Vergleich zu einem DDS Band", "Schnellere Datenübertragung als ein AIT Band", "Etwas günstiger als eine DVD-RAM", "Datensicherheit", 4),
("Was bedeutet das RAID Level 5?", "Intelligente Verteilung der Daten auf mehrere Festplatten", "Zwei Festplatten werden zu einer großen zusammengefasst", "Eine zusätzliche Festplatte wird als Backup genutzt", "Zwei Festplatten mit demselben Inhalt", "Datensicherheit", 2),
("Wie hoch ist die Kapazität einer DVD-9?", "8,5 GB", "4,7 GB", "9,4 GB", "13,2 GB", "Datensicherheit", 4),
("Wie viele Festplatten werden für ein Raid System Level 10 mindestens benötigt?", "4 Festplatten", "3 Festplatten", "2 Festplatten", "5 Festplatten", "Datensicherheit", 3),
("Was bedeutet das RAID Level 0?", "Die Daten werden gleichmäßig auf zwei Festplatten verteilt", "Eine zusätzliche Festplatte wird als Backup genutzt", "Intelligente Verteilung der Daten auf mehrere Festplatten", "Zwei Festplatten mit demselben Inhalt", "Datensicherheit", 2),
("Wie lautet das DVD Format einer einseitigen und zweischichtigen DVD?", "DVD-5", "DVD-9", "DVD-10", "DVD-14", "Datensicherheit", 4),
("Welches der folgenden Speichermedien hat die voraussichtlich längste Lebensdauer?", "Magneto Optical Disk", "DVD-RAM", "Digital Audio Tape", "Magnetische Festplatte", "Datensicherheit", 4),
("Datenschutz ist ein wichtiges Thema in der IT-Branche. Wo ist er in Deutschland rechtlich geregelt?", "Im Bundesdatenschutzgesetz", "Im Internetgesetz", "Im Grundgesetz", "Gar nicht", "Datensicherheit", 2),


("Welche Aussage trifft auf das ohmsche Gesetz zu?", "Je kleiner die Spannung, umso kleiner ist die Stromstärke", "Je kleiner die Spannung, umso größer ist die Stromstärke", "Je kleiner der Widerstand, umso kleiner ist die Stromstärke.", "Je kleiner der Strom, umso kleiner ist der Widerstand", "Elektrotechnik", 2),
("Wie lautet die Formel für die Berechnung des elektrischen Widerstands?", "R = U * I", "R = P / I", "R = U / I", "R = W / t", "Elektrotechnik", 2),
("In welcher Einheit wird die elektrische Spannung angegeben?", "Volt", "Watt", "Ohm", "Ampere", "Elektrotechnik", 2),
("Was passiert, wenn Widerstände in Reihe geschaltet werden?", "Der Gesamtwiderstand vergrößert sich", "Der Leitungsquerschnitt vergrößert sich", "Der Gesamtwiderstand verringert sich", "Der Leitungsquerschnitt verringert sich", "Elektrotechnik", 3),
("Was besagt die 2. Regel von Kirchhoff (Maschenregel)? Die Summe aller Teilspannungen...", "entspricht der Spannung der Quelle", "ist kleiner als die Spannung der Quelle", "ist ungleich der Spannung der Quelle", "ist größer als die Spannung der Quelle", "Elektrotechnik", 3),
("In welcher Einheit wird der elektrische Widerstand gemessen?", "Ohm", "Watt", "Volt", "Ampere", "Elektrotechnik", 2),
("Welche Aussage trifft auf eine Parallelschaltung von unterschiedlich großen Widerständen zu?", "An jedem Widerstand liegt die selbe Spannung", "Durch jeden Widerstand fließt der selbe Strom", "Am größten Widerstand liegt die größte Spannung", "Durch den größten Widerstand fließt der größte Strom", "Elektrotechnik", 2),
("Wie lautet die Formel für die Berechnung der Elektrischen Leistung?", "P = U * I", "P = R * I", "P = U / I", "P = U / R", "Elektrotechnik", 2),
("Womit beschäftigt sich die Hochfrequenzelektronik?", "Erzeugung, Senden und Empfang von Funksignalen", "Messung von hohen Tonlagen", "Messung von hohen Temperaturen", "Kommunikation über kabellose Netzwerke", "Elektrotechnik", 2),


("Was bedeutet Modem?", "Abkürzung für Modulator Demodulator", "Keine weitere Bedeutung", "Abkürzung für Moderne Kommunikation", "Abkürzung für Moderner Demodulator", "Internet", 3),
("Welche Aussage über TCP/IP ist richtig?", "TCP/IP ist eine Familie von Netzwerkprotokollen", "TCP/IP wird ausschließlich im Internet benutzt", "TCP/IP arbeitet nur auf Windows Rechnern", "TCP/IP ist für Routing ungeeignet", "Internet", 2),
("Was bedeutet die Abkürzung ADSL?", "Asymmetric Digital Subscriber Line", "Asynchronous Digital Service Line", "Advanced Digital Subscriber Line", "Asymmetric Digital Service Line", "Internet", 2),
("Welche Daten werden vom Provider bei der Verbindung zum Internet in der Regel überprüft?", "Benutzername und Passwort", "Telefonnummer und Benutzername", "E-Mail Adresse und Benutzername", "Telefonnummer und Passwort", "Internet", 2),
("In welchem Format sind Webseiten üblicherweise verfasst?", "(X)HTML", "WWW", "HTTP", "JavaScript", "Internet", 1),
("Was bedeutet die Abkürzung BBAE?", "Breitband Anschlusseinheit", "Breitband Abschlusseinheit", "Breitband Anschlussgerät", "Breitband Abschlussgerät", "Internet", 2),
("Welche der hier aufgeführten Abkürzungen ist keine DSL Variante?", "SADSL", "ADSL Plus", "HDSL", "SDSL", "Internet", 3),
("Wann wurde das World Wide Web zur allgemeinen Benutzung freigegeben?", "1991", "1989", "1990", "1992", "Internet", 3),
("Mit welchem Protokoll werden Webseiten übertragen?", "HTTP", "FTP", "POP", "IMAP", "Internet", 2),
("Wofür steht die Endung ‚it‘ bei Internetseiten?", "Italien", "Informationstechnologie", "International", "Internet", "Internet", 2),


("Aus wie vielen Bytes besteht ein Kilobyte (Dezimalpräfix)?", "1000", "768", "1012", "1024", "IT Grundlagen", 3),
("Was bedeutet CD-ROM?", "Compact Disk Read Only Memory", "Compact Disk Randomize Memory", "Compact Disk Read Ones Memory", "Compact Disk Read Often Memory", "IT Grundlagen", 1),
("Wann gab es den ersten PC von IBM?", "1981", "1978", "1980", "1985", "IT Grundlagen", 3),
("Wie lauten die Grundfarben eines Farbtintendruckers?", "Cyan, Magenta, Gelb", "Rot, Grün, Blau", "Rot, Gelb, Blau", "Rot, Magenta, Gelb", "IT Grundlagen", 1),
("Wobei handelt es sich beim CMOS Speicher?", "Speichert grundlegende Systemeinstellungen wie Datum, Uhrzeit...", "Es handelt sich um einen freien Speicher einer Diskette", "Dateizuordnungstabelle einer Festplatte", "Es ist der Arbeitsspeicher einer Grafikkarte", "IT Grundlagen", 2),
("Welche Art von Computerviren gibt es nicht?", "Monitorviren", "Bootsektor Viren", "Makroviren", "Dateiviren", "IT Grundlagen", 1),
("Womit beschäftig sich die Datenschutzrichtlinie der EU?", "Schutz vor Missbrauch persönlicher Daten", "Maßnahmen gegen Datenverlust auf dem eigenen Rechner", "Schutz vor illegalen Downloads aus dem Internet", "Maßnahmen gegen Datenverlust bei der Internetverbindung", "IT Grundlagen", 1),
("Wozu dient ein Streamer?", "Ein Streamer speichert große Datenmengen", "Ein Streamer druckt Konstruktionszeichnungen", "Ein Streamer verschlüsselt wichtige Daten", "Ein Streamer komprimiert Daten auf der Festplatte", "IT Grundlagen", 2),
("Wozu werden RAM und ROM benötigt?", "Speichern und Lesen von Daten", "Rechenoperationen in Tabellenkalkulationen", "Systematisieren von Datenbanken", "Hoch- und Herunterfahren von Computern", "IT Grundlagen", 2),
("Was ist Wikipedia?", "Online-Enzyklopädie", "Online-Wörterbuch", "Internet-Suchmaschine", "Internet-Portal", "IT Grundlagen", 1),
("Was kann man mit VoIP tun?", "Telefonieren", "Surfen", "Mailen", "Onlinebanking", "IT Grundlagen", 2),
("Wofür ist der Begriff Kaspersky bekannt?", "Sicherheitssoftware", "Internet-Browser", "Programmiersprache", "Schachprogramm", "IT Grundlagen", 1),
("Wer war Steve Jobs?", "Mitgründer und Geschäftsführer von Apple", "Chefprogrammierer bei Microsoft", "Geschäftsführer von Dell", "Erfinder des Betriebssystems Linux", "IT Grundlagen", 1),
("In welcher Einheit wird die Übertragungsgeschwindigkeit von Daten angegeben?", "Bitrate", "Baudrate", "Baurate", "Byterate", "IT Grundlagen", 2),
("Wie viele Bits hat ein Byte?", 8, 10, 12, 15, "IT Grundlagen", 1),


("Wie lange ist bei 10BaseT die maximal zulässige Entfernung zwischen 2 Hubs?", "100 m", "50 m", "150 m", "200 m", "Netzwerke", 2),
("Wie wird 10Base2 auch genannt?", "Thin Ethernet", "Fast Ethernet", "Slow Ethernet", "Thick Ethernet", "Netzwerke", 2),
("Bei welcher Netzwerktopologie ist die Fehlersuche am einfachsten?", "Stern Topologie", "Bus Topologie", "Ring Topologie", "Baum Topologie", "Netzwerke", 2),
("Welcher Dienst vergibt die Netzwerkkonfiguration an Geräte?", "DHCP", "DNS", "WINS", "TCP", "Netzwerke", 2),
("Welcher IP Bereich ist für private Class B Netzwerke reserviert?", "172.16.0.0 - 172.31.255.255", "10.0.0.0 - 10.255.255.255", "192.168.0.0 - 192.168.255.255", "127.0.0.1 - 127.255.255.255", "Netzwerke", 2),
("Bei welchen Zugriffsverfahren werden Kollisionen erkannt anstatt diese zu verhindern?", "CSMA/CD", "Token Ring", "CSMA/CA", "AppleTalk", "Netzwerke", 3),
("Wie hoch ist der Endwiderstand bei einem Thin Ethernet?", "50 Ohm", "25 Ohm", "100 Ohm", "150 Ohm", "Netzwerke", 5),
("Wie lang ist eine IP Adresse (IPV4)?", "32 Bit", "16 Bit", "64 Bit", "128 Bit", "Netzwerke", 2),
("Wie lang darf ein Glasfaserkabel bei 100BaseFX maximal sein?", "2000 m", "500 m", "1000 m", "3000 m", "Netzwerke", 3),
("Wie wird 10BaseT häufig bezeichnet?", "Twisted-Pair", "Fast Ethernet", "Cross Over", "Thick Ethernet", "Netzwerke", 3),
("Mit welchem Befehl kann man die Kommunikation eines Webservers überprüfen?", "PING", "NETSTAT", "IPCONFIG", "NET VIEW", "Netzwerke", 1),
("Wie nennt man ein kleineres, räumlich begrenztes Netzwerk?", "LAN", "WAN", "MAN", "GAN", "Netzwerke", 2),
("Wie wird ein Gerät mit einer logischen IP Adresse genannt?", "Host", "Client", "Server", "Router", "Netzwerke", 3),
("In welcher Einheit wird die Dämpfung eines Netzwerkkabels gemessen?", "Dezibel", "Meter", "Watt", "Volt", "Netzwerke", 2),


("Mit welcher Funktion erhält man in EXCEL das aktuelle Datum?", "=heute()", "=datum()", "=zeit()", "=time()", "Office Programme", 2),
("Welcher Diagrammtyp liegt vor, wenn Sie senkrechte Balken sehen?", "Säulendiagramm", "Liniendiagramm", "Stabdiagramm", "Balkendiagramm", "Office Programme", 3),
("Wie lautet die Dateinamenerweiterung einer EXCEL Arbeitsmappe?", ".xlsx", ".xxlx", ".xltx", ".xlcx", "Office Programme", 1),
("Welches Produkt ist seit Microsoft Office 2007 nicht mehr Bestandteil der Suite?", "Project", "Outlook", "Excel", "Access", "Office Programme", 2),
("Wie viel verschiedene Arten von Tabulatoren gibt es in Microsoft Word?", "Vier", "Zwei", "Drei", "Fünf", "Office Programme", 3),
("Wie heißt die OpenOffice Alternative zu Microsoft PowerPoint?", "Impress", "Math", "Base", "Draw", "Office Programme", 3),
("In welchem Jahr erschien die erste Microsoft Office Version für Windows?", "1990", "1989", "1991", "1992", "Office Programme", 5),
("Welche der folgenden Firmen hat und hatte kein eigenes Office Paket?", "SAP", "IBM", "Sun", "Corel", "Office Programme", 2),
("Wie heißt die OpenOffice Alternative zu Microsoft Excel?", "Calc", "Math", "Base", "Impress", "Office Programme", 3),
("Mit welcher Tastenkombination kann man seine Eingabe rückgängig machen?", "Strg + Z", "Strg + Y", "Alt + Z", "Alt + Y", "Office Programme", 1),
("Sie sollen für die Vertriebsabteilung ein Tabellenkalkulationsprogramm auswählen. Welches Programm kommt dafür in Frage?", "Excel", "Access", "Power Point", "Word", "Office Programme", 2),


("Das TCP Protokoll ist welcher OSI - Schicht zuzuordnen?", "Transport Layer (Transportschicht)", "Session Layer (Sitzungsschicht)", "Network Layer (Vermittlungsschicht)", "Presentation Layer (Darstellungsschicht)", "OSI Modell", 3),
("Welchen Namen hat die 3. OSI - Schicht?", "Network Layer (Vermittlungsschicht)", "Application Layer (Anwendungsschicht)", "Transport Layer (Transportschicht)", "Session Layer (Sitzungsschicht)", "OSI Modell", 3),
("In welcher OSI - Schicht sind Kabel und Stecker einzuordnen?", "1. OSI - Schicht", "2. OSI - Schicht", "3. OSI - Schicht", "4. OSI - Schicht", "OSI Modell", 2),
("In welcher OSI - Schicht erfolgen Komprimierung und Verschlüsselung?", "6. OSI - Schicht", "4. OSI - Schicht", "5. OSI - Schicht", "7. OSI - Schicht", "OSI Modell", 4),
("Welchen Namen hat die 5. OSI - Schicht?", "Session Layer (Sitzungsschicht)", "Application Layer (Anwendungsschicht)", "Transport Layer (Transportschicht)", "Data Link Layer (Sicherungsschicht)", "OSI Modell", 3),
("In welcher OSI - Schicht sind Router einzuordnen?", "Network Layer (Vermittlungsschicht)", "Data Link Layer (Sicherungsschicht)", "Session Layer (Sitzungsschicht)", "Application Layer (Anwendungsschicht)", "OSI Modell", 3),
("Was passiert in der 5. OSI - Schicht?", "Steuerung logischer Verbindungen im Netzwerk", "Ver- und Entschlüsselung von Datenpaketen sowie Komprimierung und Zeichenumwandlung", "Dies ist die oberste Softwareebene. Die Schnittstelle zwischen Benutzer und Rechner.", "Die physische Datenübertragung", "OSI Modell", 3),
("Welche ist die einzige OSI - Schicht, die Informationen direkt an ihr Gegenstück senden kann?", "1. OSI - Schicht", "2. OSI - Schicht", "3. OSI - Schicht", "4. OSI - Schicht", "OSI Modell", 2),
("Welche OSI - Schicht befindet sich zwischen der Transportschicht und der Sicherungsschicht?", "Network Layer (Vermittlungsschicht)", "Application Layer (Anwendungsschicht)", "Session Layer (Sitzungsschicht)", "Physical Layer (Physikalische Schicht)", "OSI Modell", 2),
("Wie werden die Leistungen einer OSI - Schicht genannt, welche eine direkt darüberliegende OSI - Schicht nutzen kann?", "Dienste", "Instanzen", "Leistungen", "Protokolle", "OSI Modell", 3),
("Welche OSI - Schicht befindet sich zwischen der Darstellungsschicht und der Transportschicht?", "Sitzungsschicht", "Anwendungsschicht", "Sicherungsschicht", "Vermittlungsschicht", "OSI Modell", 4),


("Wo muss eine KG eingetragen werden?", "Amtsgericht", "Hausbank", "Finanzamt", "Gewerbeaufsichtsbehörde", "WISO", 3),
("Wo müssen Sie einen Unfallbericht einreichen?", "Berufsgenossenschaft", "Landesversicherungsanstalt", "Krankenkasse", "Industrie- und Handelskammer", "WISO", 2),



("Was versteht man unter DTP Software?", "Programme zur Erstellung satzreifer Druckvorlagen", "Bildbearbeitungsprogramme zur Nachbearbeitung von Bild Dateien", "Dynamische Tabellenkalkulationsprogramme", "Datenübertragungsprogramme für einen Desktop PC", "Sonstiges", 4),
("Welche Auswirkung hat der Einsatz der strukturierten Programmierung?", "Die Programme sind besser lesbar und damit leichter wartbar", "Die Programme sind schneller", "Die Kompatibilität der Programme wird erhöht", "Die Datendefinitionen werden vereinheitlicht", "Sonstiges", 2),
("Welches Qualitätskriterium wird durch das Prüfsiegel TCO 06 u.a. abgedeckt?", "Energieverbrauch", "Lärmemission", "Betriebssicherheit", "Arbeitssicherheit", "Sonstiges", 5),
("Welches der hier genannten Anwenderprogramme ist branchenneutral?", "Warenwirtschaftssystem", "Werkzeugmaschinensteuerung", "Pfandrückgabeverwaltung", "Produktionsplanungssystem", "Sonstiges", 3);


Create Table ImageLinks (
id int auto_increment primary key,
name varchar(25),
link varchar(100));

Insert into ImageLinks(name, link) values
("backgroundMainMenu", "/Resources/Images/MainMenu/background.jpg"),
("newGame", "/Resources/Images/MainMenu/newGame.png"),
("newGameOverlay", "/Resources/Images/MainMenu/newGameOverlay.png"),
("highscore", "/Resources/Images/MainMenu/highscore.png"),
("highscoreOverlay", "/Resources/Images/MainMenu/highscoreOverlay.png"),
("exit", "/Resources/Images/MainMenu/exit.png"),
("exitOverlay", "/Resources/Images/MainMenu/exitOverlay.png"),
("backgroundQuestion", "/Resources/Images/Question/background.jpg"),
("questionBorder", "/Resources/Images/Question/questionBorder.png"),
("timerBorder", "/Resources/Images/Question/timerBorder.png"),
("transBorder", "/Resources/Images/Question/transBorder.png"),
("answerBorder", "/Resources/Images/Question/answerBorder.png"),
("answerBorderRight", "/Resources/Images/Question/answerBorderRight.png"),
("answerBorderFalse", "/Resources/Images/Question/answerBorderFalse.png"),
("answerBorderChoosen", "/Resources/Images/Question/answerBorderChoosen.png"),
("backgroundStatistic", "/Resources/Images/Statistic/background.jpg"),
("backgroundHighscore", "/Resources/Images/Highscore/background.jpg"),
("mute", "/Resources/Images/Mute/mute.png"),
("unmute", "/Resources/Images/Mute/unmute.png");

Create Table AudioLinks (
id int auto_increment primary key,
name varchar(25),
link varchar(100));

Insert into AudioLinks(name, link) values
("mainTheme", "/Resources/Audio/mainTheme.wav"),
("right", "/Resources/Audio/right.wav"),
("false", "/Resources/Audio/false.wav");

Create Table Highscore (
id int primary key,
name varchar(25),
punkte int);

Insert into Highscore values
(1, "Michael Mudrick", 10000),
(2, "Helene Deutsch", 9000),
(3, "Nils Grüger", 8000),
(4, "Tim Hanke", 7000),
(5, "Ulf Treue", 6000),
(6, "Alwin Dettling", 5000),
(7, "Patrick Zawicki", 4000),
(8, "Hr. Lange", 3000),
(9, "Bernd Müller", 2000),
(10, "Harald Wild", 1000);