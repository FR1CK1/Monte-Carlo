# Beschreibung

Dieses Programm wurde als Prüfungsleistund für den Studiengank Computer Science angefertigt.

# Aufgabe

Die Funktion

$f(x,y) = sin(\sqrt{log(x+y+1)}$

soll im Integral

$I[f]=\iint_\Omega f(x,y)dxdy$

bestimmt werden. $\Omega$ soll folgendermaßen definiert werden.

$
\Omega = \lbrace (x,y) : x \left(x-\frac{1}{2}\right)^2 + x \left(y-\frac{1}{2}\right)^2 <= \frac{1}{4}\rbrace
$

Das konkrete Ergebniss kann mit 

$
I_1[f]=\int^{2\pi}_0\int_{0}^{r_0}sin\left(\sqrt{log(x_m+y_m+r \cos(\phi) + r sin(\phi)+1)}\right)rdrd\phi
$

ermittelt werden, wobei $(x_n,y_m)$ und $r_0$ der Mittelpunkt und Radius der Kreisfläche von $\Omega$ sind.

# Programm

Das Programm wurde nur für diese Funktion entworfen und kann das Ergebniss des Algorithmus auf Konsole und graphisch ausgeben. Andere dreidimensionalen Funktionen sind möglich wenn die Koordinatengeneration, `checkIfInOmega()` und `generateZ()` ensprechend angepasst werden