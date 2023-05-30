package pack;

public class Generator {

	public static double[] pd = new double[Launcher.INT_RESULT_STEP];

	public static double generateZ(double x, double y) {
		/*
		 * Funktion wird in drei teile zerteilt um die Fehleranfälligkeit zu minimieren
		 * log = log(x+y+1) srt = sqrt(log) = sqrt(log(x+y+1)) z = sin(srt) =
		 * sin(sqrt(log)) = sin(sqrt(log(x+y+1)))
		 */

		double log = Math.log10(x + y + 1);
		double srt = Math.sqrt(log);
		double z = Math.sin(srt);

		return z;
	}

	public static boolean checkIfInOmega(double x, double y) {
		// Diese Funktion überprüft, ob sich die Koordinaten im Bereich von Omega
		// befinden
		boolean acc = false;
		double check = ((x - 0.5) * (x - 0.5)) + ((y - 0.5) * (y - 0.5));
		if (check <= 0.25) {
			acc = true;
		}
		return acc;
	}

	public static double ratioRand(double randCount, double randNotOK) {
		// Diese FUnktion überprüft die Effizienz nach Zufallszahlen
		double errorRatio = randNotOK / randCount;
		double ratio = 1 - errorRatio;
		return ratio;
	}

	//Die beiden folgenden Funktionen dienen zur Übertragung der Ergebnisse an die MainFrame Klasse
	public static void saveRes(double[] results) {
		pd = results;
	}

	public static double getRes(int i) {

		double d = pd[i - 1];

		return d;
	}

}
