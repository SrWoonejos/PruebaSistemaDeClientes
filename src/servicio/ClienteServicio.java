package servicio;

import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {

	private static List<Cliente> clientes = new ArrayList<>();

	public ArrayList<Cliente> getListaClientes() {
		return new ArrayList<>(ClienteServicio.clientes);
	}
	
	public void setListaClientes(List<Cliente> clientes) {
		ClienteServicio.clientes = clientes;
	}

	public String agregarCliente(Cliente cliente) {
		if (cliente != null) {
			clientes.add(cliente);
			return "Agregad@";
		} else {
			return "¡Error!, cliente nulo.";
		}

	}
}
