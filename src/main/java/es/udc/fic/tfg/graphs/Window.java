package es.udc.fic.tfg.graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Window extends javax.swing.JFrame {

	JFreeChart chart; // Grafica
	DefaultPieDataset data = new DefaultPieDataset(); // fuente de datos

	public Window() {

	    //Añadimos datos a la fuente
		data.setValue("C", 40);
		data.setValue("Java", 45);
		data.setValue("Python", 15);

		// Creando el Grafico
		chart = ChartFactory.createPieChart("Ejemplo Rapido de Grafico en un ChartFrame", data, true, true, false);

		// Mostrar Grafico
		ChartFrame frame = new ChartFrame("JFreeChart", chart);
		frame.pack();
		frame.setVisible(true);
	}
}
