package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.List;
import modelo.Cliente;

public class ExportadorCsv extends Exportador {

	// guardar archivo y guardar un submenu para que lo exporte en ambos formatos

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName + ".csv"))) {
			for (Cliente cliente : listaClientes) {
				writer.println(cliente.getNombreCliente() + "," + cliente.getApellidoCliente() + ","
						+ cliente.getRunCliente() + "," + cliente.getAnioCliente());
			}

			System.out.println("Archivo CSV exportado.");
		} catch (IOException e) {
			System.out.println("Error al exportar el archivo CSV: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
