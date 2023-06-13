package servicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador{
	
	
	private ClienteServicio cs = new ClienteServicio();

	@Override
	public void exportar(String fileName,List<Cliente> listaCliente) {
		
	}
	
	public void cargarDatos(String fileName) {
		List<Cliente> clientes = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] data = linea.split(",");
				CategoriaEnum cat = CategoriaEnum.ACTIVO;
				if(data[4].equals("Inactivo")) cat = CategoriaEnum.INACTIVO;
				Cliente cliente = new Cliente(data[0],data[1],data[2],Integer.parseInt(data[3]), cat);
				clientes.add(cliente);
			}
		} catch (IOException e) {
			System.out.println("¡Error! no se cargaron correctamente los datos desde el archivo: ");
		}
		cs.setListaClientes(clientes);
	}
}
