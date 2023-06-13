package servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import modelo.CategoriaEnum;
import modelo.Cliente;

class ClienteServicioTest {

	private Cliente cliente;
	private ClienteServicio clienteServicio;

	public void ClienteServicio() {

	}

	@Test
	public void agregarCliente() {
		String runCliente = "1234567-8";
		String nombreCliente = "Juanito";
		String apellidoCliente = "Perez";
		int anioCliente = 5;
		CategoriaEnum nombreCategoria = null;

		clienteServicio.agregarClienteTest(runCliente, nombreCliente, apellidoCliente, anioCliente, nombreCategoria);
		cliente = clienteServicio.getListaClientes().get(0);
		String a = cliente.getNombreCliente();
		System.out.print(a);
		assertEquals(a, null);

	}

}
