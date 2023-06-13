package servicio;

import modelo.CategoriaEnum;
import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {

	static List<Cliente> listaCliente;
	private static Cliente cliente;

	public ClienteServicio() {
		listaCliente = new ArrayList<>();
	}
	
	public ArrayList<Cliente> getListaClientes() {
		return new ArrayList<>(ClienteServicio.listaCliente);
		
	}

	public void setListaClientes(List<Cliente> clientes) {
		ClienteServicio.listaCliente = clientes;
	}
	
	 public String agregarClienteTest(String runCliente, String nombreCliente,
	 String apellidoCliente, int anioCliente, CategoriaEnum nombreCategoria) {
	 
	 setCliente(new Cliente (runCliente, nombreCliente, apellidoCliente,
	 anioCliente, CategoriaEnum.ACTIVO)); 
	 if (listaCliente != null) {
			listaCliente.addAll(listaCliente);
		} else {
			return "¡Error!, cliente nulo.";
		}
	return null;

	}

	public static void agregarCliente(Cliente nuevoCliente) {
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		ClienteServicio.cliente = cliente;
	}
}
