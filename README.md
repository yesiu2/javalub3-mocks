# javalub3-mocks

**Motywacja**

Poprowadzimy blok praktyczny w formie projektu, który w pewnym stopniu będzie symulował rzeczywiste warunki i wymagania, z którymi spotkacie się w pracy jako programiści.

Celem warsztatów niekoniecznie jest ukończenie całego zadania, ale zdobycie doświadczenia w pracy nad otwartym problemem i dyskusji w grupie.

**Aparat**

Waszym zadaniem jest napisanie kodu dla komponentu prostego aparatu cyfrowego. Aparat ma dwa zewnętrzne przyciski: przycisk zasilania i przycisk migawki.

Głównym komponent Camera jest odpowiedzialny za reagowanie na działania użytkownika na przełączniki aparatu i koordynowanie transferu danych z sensora do karty pamięci, kiedy jest robione zdjęcie. Powinieneś zaimplementować klasę Camera w stylu TDD dodając pojedynczo testy do wymaganych zachowań.

**Klasa Camera**

*Camera* musi posiadać następujące zachowania: 
1. Włączenie kamery włącza zasilanie sensora.
2. Wyłączenie kamery odcina zasilanie sensora.
3. Naciśnięcie migawki jeśli zasilanie jest odcięte nie robi nic.
4. Naciśnięcie migawki z włączonym zasilaniem, kopiuje dane z sensora do karty pamięci. Zapisywanie danych do karty pamięci może zająć kilka sekund.
5. Jeśli dane są obecnie zapisywane, wyłączenie kamery nie odcina zasilania sensora
6. Kiedy zapis danych się zakończy, aparat odcina zasilanie sensora.

**Wskazówki**

Pracujcie w grupach 2-3 osobowych. Częścią zadania jest przemyślenie decyzji i koncepcji oraz dyskusja na ich temat. Rozmawiajcie jak najwięcej!

Cały czas będę do Waszej dyspozycji - będę podpowiadał, wyjaśniał i odpowiadał na pytania, ale to Wy jesteście programistami i to Wy musicie rozwiązać problem.

Zapisujcie i wypychajcie na serwer postępy (git add, commit i push), żeby ich nie stracić.

Otrzymaliście interfejsy Sensor oraz MemoryCard (które będą napisane przez inne zespoły). Nie powinniście ich zmieniać!

Aby być powiadomionym kiedy zapisywanie danych się kończy, Camera powinien implementować interfejs WriteListener. Jeśli kamera go implementuje, wtedy inne komponenty mogą go wywołać i powiadomić o statusie zapisywania danych.

**Pytania do przemyślenia**

Kiedy jest domyślny stan zasilania nowego aparatu (włączony, wyłączony)?
Czy są jakieś powtórzenia kodu w Waszych testach? Czy można je zrefaktoryzować?
Czy Wasze testy są rzeczowe i ściśle ukierunkowane?
W jakim stopniu testy inspirują Wasz projekt kodu (implementację)?
Czy TDD z obiektami mock prowadzi do kodu, który jest łatwiej utrzymywać?
W jakim stopniu TDD z obiektami mock pozwala nam lepiej testować oprogramowanie?
Co uważasz za dobre i złe praktyki przy używaniu obiektów mock?

**Pobieranie kodu**

Należy założyć konto na GitHub oraz utworzyć fork repozytorium. 
https://help.github.com/articles/fork-a-repo/ 

Następnie repozytorium można sklonować za pomocą komendy:
git clone https://github.com/<TWOJ_LOGIN>/javalub3-mocks.git

**Struktura kodu**

W projekcie znajdują się 2 foldery src/main/java oraz src/test/java. W każdym z nich znajduje się pakiet com.demo. Piszcie swój kod w tym pakiecie (testy w src/test/java i kod aplikacji w src/main/java). W folderze main znajdują się już jakieś klasy, m.in. Camera.java, którą będziecie w pełni implementowali. W folderze test znajduje się plik CameraSpec.groovy, gdzie powinniście zamieszczać swoje testy.

**Importowanie kodu do IntelliJ**

Wybieracie opcję Import Project, przechodzicie do sklonowanego folderu (WAŻNE: mocks, nie src), Import from external model, wybieracie Maven i klikacie Next aż do końca. Jeśli JDK nie jest ustawione, wybieracie 1.8.

**Materiały dodatkowe**
Przydatny artykuł do dyskusji:
https://martinfowler.com/articles/mocksArentStubs.html 
Informacje o interaction based testing
http://spockframework.org/spock/docs/1.0/interaction_based_testing.html 


