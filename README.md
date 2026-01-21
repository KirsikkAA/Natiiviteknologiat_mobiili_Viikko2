## Viikotehtävä 2 -  ViewModel

<h>Sovelluksessa käytetään Task-data classia. Datamalliin kuuluu: 
- id
- title
- description
- priority
- dueDate
- done </h>

<h>Sovelluksessa on viisi eri funktiota: 
- addTask: Lisää uuden taskin default tekstillä
- toggleDone - Muuttaa listan ensimmäisen taskin done tilan (true/false)
- filterByDone - Näyttää ainoastaan listan taskit, joiden done-tila on true
- filterDueDate - Järjestää listan dueDaten mukaisesti
- Reset - Palauttaa koko listan alkuperäiseen tilaan </h>

<h>Sovelluksen voi ajaa:
- Android studiossa emulaattorilla tai fyysisellä laitteella
- Asentamalla debug APK Android-laitteeseen</h>

#### Compose tilanhallinta
<h>Compose tilanhallinta tarkoittaa dataa, joka muuttuu ja siten vaikuttaa UI:in. Esimerkiksi käyttäjä syöttää uutta tietoa tai refresh sovelluksen, compose automaattisesti päivittää sovelluksen (recompose)

#### viewModel
<h>ViewModel on parempi parempi säilyttämään tilan konfiguraatio muutosten (esimerkiksi näytön kääntämisen) yli, kuin pelkkä remember. ViewModel erottaa toimintalogiikan käyttöliittymästä ja se helpottaa ohjelmiston testaamista. Se myös integroituu hyvin muiden Architecture Components -komponenttien kanssa. Remember on parempi hetkittäisille UI-tiloihin, esimerkiksi animaatiotiloihin. </h>

<h>Linkki videoon</h>
