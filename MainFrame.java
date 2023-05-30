package pack;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JPanel {

	public void paint(Graphics g) {
		super.paintComponents(g);
		
		//Das Koordinatensystem wird hier aufgebaut
		
		g.drawLine(50, 950, 1050, 950); // X-Achse

		// Beschriftung X-Achse
		g.drawString("0", 50, 980);

		g.drawLine(150, 940, 150, 960);
		g.drawString("10k", 140, 980);

		g.drawLine(250, 940, 250, 960);
		g.drawString("20k", 240, 980);

		g.drawLine(350, 940, 350, 960);
		g.drawString("30k", 340, 980);

		g.drawLine(450, 940, 450, 960);
		g.drawString("40k", 440, 980);

		g.drawLine(550, 940, 550, 960);
		g.drawString("50k", 540, 980);

		g.drawLine(650, 940, 650, 960);
		g.drawString("60k", 640, 980);

		g.drawLine(750, 940, 750, 960);
		g.drawString("70k", 740, 980);

		g.drawLine(850, 940, 850, 960);
		g.drawString("80k", 840, 980);

		g.drawLine(950, 940, 950, 960);
		g.drawString("90k", 940, 980);

		g.drawLine(1050, 940, 1050, 960);
		g.drawString("100k", 1040, 980);

		
		
		
		g.drawLine(50, 50, 50, 950); // Y-Achse

		// Beschriftung Y-Achse

		g.drawString("0,399", 10, 950);

		g.drawLine(45, 875, 60, 875);
		g.drawLine(45, 800, 60, 800);
		g.drawLine(45, 725, 60, 725);

		g.drawLine(45, 650, 60, 650);
		g.drawString("0,400", 10, 655);

		g.drawLine(45, 575, 60, 575);
		g.drawLine(45, 500, 60, 500);
		g.drawLine(45, 425, 60, 425);

		g.drawLine(45, 350, 60, 350);
		g.drawString("0,401", 10, 355);

		g.drawLine(45, 275, 60, 275);
		g.drawLine(45, 200, 60, 200);
		g.drawLine(45, 125, 60, 125);

		g.drawLine(45, 50, 60, 50);
		g.drawString("0,402", 10, 55);

		// Echtes Ergebnis einzeichnen
		g.setColor(Color.blue);
		double y1 = ((1 - Launcher.REALRESULT) - 0.598) * 300000; // s. weiter unten
		double y = y1 + 50;
		g.drawLine(50, (int) y, 1050, (int) y);
		g.drawString("0.4006", 10, (int) y+5);

		// Punkte einzeichnen
		g.setColor(Color.red);

		for (int i = 1; i <= Launcher.INT_RESULT_STEP; i++) {

			double res = Generator.getRes(i);
			y1 = ((1 - res) - 0.598) * 300000; 
			y = y1 + 50;
			
			/*
			 * y1 sorgt für eine Anpassung des ermittelten Ergebnisses
			 * Der Grund dafür ist, dass das Programm die Zeichnungen in der Einheit "Pixel" vornimmt
			 * Die verwendete Formel passt diese Ergebnisse in für das Koordinatensystem nutzbare Zahlen an
			 */
			
			g.fillOval(((1000/Launcher.INT_RESULT_STEP) * i) + 50, (int) y, 3, 3);
		}

	}

	void initialise() {

		JFrame f = new JFrame();
		f.setTitle("Monte-Carlo");
		f.setSize(1100, 1100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(new MainFrame());
		f.setVisible(true);
	}

}
