# Backend serwera napisany w C++ instrukcja kompilacji
Żeby skorzystać z REST API należy wysłać zapytanie POST do serwera pod adresem:
- /sort_int
- /sort_double
- /sort_string
Do tego trzeba dorzucić plik json w formacie:
```
{
	"data": "ZXYVYBCA", 
	"sortType": "BUBBLE_SORT", 
	"descending": true, 
	"iterations": 10
}
```
,gdzie:
- data: tablica int lub double, lub po prostu string
- sortType: "BUBBLE_SORT", "MERGE_SORT", "QUICK_SORT", jeden z tych typów
- descending: (opcjonalne) true żeby sortowało malejąco, false w przeciwnym wypadku
- iterations: (opcjonalne) ilość iteracji po jakich algorytm ma się zatrzymać, jeśli 0 to sortuje do końca

W odpowiedzi serwer zwróci json
```
{
    "data": "ABCYVZZ"
    "iterations": 10
}
```
,gdzie
- data: posortowany zbiór
- iterations: czas w ms ile zajęło sortowanie
