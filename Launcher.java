package pack;

public class Launcher {

	static int N = 100000; // Itterationsschritte
	static int INT_RESULT = 500; // Zwischenergebnisse
	static int INT_RESULT_STEP = N / INT_RESULT; // Zwischenergebnisse
	static double AREA = Math.PI * 0.5 * 0.5; // Kreisfläche mit r = 1/2
	static double REALRESULT = 0.4005761913304; //Konkrete Ergebnis ermittelt mit CAS-System

	public static void main(String[] args) {
		
		System.out.println("Prozess gestartet");

		double[][] cord = new double[N][3]; // N Koordinaten mit je 3 Variablen x,y,z
		double integ = 0; // Wert des Integrals, initialisiert mit 0
		double results[] = new double[INT_RESULT_STEP]; // Alle INT_RESULT Zwischenergebnise werden in dieses Array
														// geschrieben
		// Für die Ermittlung, ob die Zufallszahlen im Bereich liegen oder nicht
		double randCount = 0;
		double randNotOK = 0;

		// Zufallsgenerator für x und y mit Prüfung, ob Omega wahr ist
		System.out.println("Zufällige Koordinaten werden generiert und überprüft...");
		for (int i = 0; i < N; i++) {
			for (boolean acc = false; acc == false;) {
				cord[i][0] = Math.random();
				cord[i][1] = Math.random();
				acc = Generator.checkIfInOmega(cord[i][0], cord[i][1]);
				if (acc == false) {
					randNotOK++;
				}
				randCount++;
			}
			// z wird aus x und y berrechnet
			cord[i][2] = Generator.generateZ(cord[i][0], cord[i][1]);
		}

		// Integral wird Schrittweise nach der direkten Monte-Carlo-Methode ermittelt.
		// Aus Effizientsgründen werden nur alle INT_RESULT Ergebnisse ermittelt
		System.out.println("Integral nach Monte-Carlo wird bestimmt...\n");
		System.out.println(String.format("|%-15s|", "Durchlauf") + String.format("%-25s|", "Akt. Wert d. Integral"));
		int resultPointer = 0;
		double sumOfPillar = 0;
		for (int i = 0; i < N; i++) {
			sumOfPillar = sumOfPillar + cord[i][2];
			int ii = i + 1;
			if ((ii) % INT_RESULT == 0) {
				integ = (sumOfPillar * AREA) / (i + 1);
				results[resultPointer] = integ;
				resultPointer++;
				System.out.println(String.format("|%-15d|", ii) + String.format("%-25s|", integ));
			}
		}
		//Ausgabe auf der Konsole
		System.out.println("\nEndergebnis: " + results[INT_RESULT_STEP - 1]);
		System.out.println("Ergebnis laut CAS: " + REALRESULT);
		System.out.println("Generierte Koordinaten: " + (int) randCount);
		System.out.println("Koordinaten außerhalb des Bereiches Omega: " + (int) randNotOK);
		System.out.println("Effizienz des Algorithmus anhand der Zufallszahlen: "
				+ String.format("%f", 100 * Generator.ratioRand(randCount, randNotOK)) + "%");
		
		//Initialisierung des Fensters
		System.out.println("Fenster wird generiert...");
		Generator.saveRes(results); //Übertragung der Ergebnisse an andere Klassen
		MainFrame mf = new MainFrame();
		mf.initialise();
		System.out.println("\nProzess beendet");

	}

}
