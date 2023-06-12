package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.CategoriaEnum.categoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;

public class Menu {

	private boolean estaAbierto = true;
	boolean esWindows = false;
	private int opcion = 0;
	private Scanner sc;

	protected ClienteServicio clienteServicio;
	protected ArchivoServicio archivoServicio;
	protected ExportadorCsv exportadorCsv;
	protected ExportadorTxt exportadorTxt;
	protected String fileName = "Cliente";
	protected String fileName1 = "DBClientes.csv";

	public Menu() {
		this.esWindows = System.getProperty("os.name").toLowerCase().contains("win");
		this.archivoServicio = new ArchivoServicio();
		this.clienteServicio = new ClienteServicio();
		this.exportadorCsv = new ExportadorCsv();
		this.exportadorTxt = new ExportadorTxt();
		this.sc = new Scanner(System.in);
	}

	public void iniciarPrograma() {
		do {
			System.out.println("-------MENÚ--------");
			System.out.println("1. Listar clientes");
			System.out.println("2. Agregar cliente");
			System.out.println("3. Editar clientes");
			System.out.println("4. Cargar datos");
			System.out.println("5. Exportar datos");
			System.out.println("6. Salir");
			System.out.println("---------------");
			System.out.print("Elija una opción: ");

			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				opcion = 0;
			}

			if (this.opcion == 0) {
				System.out.println("Ingrese un numero!");
			} else if (this.opcion == 1) {
				this.listarClientes();
			} else if (this.opcion == 2) {
				this.agregarCliente();
			} else if (this.opcion == 3) {
				this.editarCliente();
			} else if (this.opcion == 4) {
				this.importarDatos();
			} else if (this.opcion == 5) {
				this.exportarDatos();
			} else if (this.opcion == 6) {
				this.estaAbierto = false;
			} else {
				System.out.println("Ingresa una opcion válida");
			}

		} while (estaAbierto);
	}

	private void listarClientes() {
		ArrayList<Cliente> clientes = clienteServicio.getListaClientes();
		for (Cliente cliente : clientes) {
			System.out.println("-----------Datos del Cliente-----------");
			System.out.println("Run del Cliente: " + cliente.getRunCliente());
			System.out.println("Nombre del Cliente: " + cliente.getNombreCliente());
			System.out.println("Apellido del Cliente: " + cliente.getApellidoCliente());
			System.out.println("Años como Cliente en nuestra pasteleria: " + cliente.getAnioCliente());
			System.out.println("Categoría del Cliente: " + cliente.getCategoria());
			System.out.println("----------------------------------------");
		}
	}

	private void agregarCliente() {
		System.out.println("--------Crear Cliente--------");
		System.out.println("Ingrese el Rut del Cliente: ");
		String run = sc.next();
		System.out.println("Ingrese su Nombre: ");
		String nombre = sc.next();
		System.out.println("Ingrese su Apellido: ");
		String apellido = sc.next();
		System.out.println("Ingrese los años que lleva como Cliente en nuestra pasteleria: ");
		int anios = sc.nextInt();

		Cliente nuevoCliente = new Cliente(run, nombre, apellido, anios, categoriaEnum.ACTIVO);
		clienteServicio.agregarCliente(nuevoCliente);
		System.out.println("---------------------------------------");
		System.out.println("Cliente agregado con éxito.");
	}

	private void editarCliente() {
		boolean opcionNoValida = true;
		do {
			System.out.println("-------------Editar Cliente-------------");
			System.out.println("Seleccione qué desea hacer:");
			System.out.println("1.-Cambiar el estado del cliente");
			System.out.println("2.-Editar los datos ingresados del cliente");
			System.out.println("----------------------------------------");
			System.out.print("Ingrese una opción:");
			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				opcion = 0;
			}
			if (opcion == 0) {
				System.out.println("Ingrese un nro.");
			} else if (opcion == 1) {
				this.editarEstadoDeCliente();
				opcionNoValida = false;
			} else if (opcion == 2) {
				this.editarDatosDeCliente();
				opcionNoValida = false;
			} else {
				System.out.println("Ingrese una opción válida");
			}
		} while (opcionNoValida);
	}

	private void editarEstadoDeCliente() {
		ArrayList<Cliente> clientes = clienteServicio.getListaClientes();
		Cliente clienteSeleccionado = null;
		do {

			System.out.println("Ingrese RUN del cliente a editar:");
			String rutBuscar = sc.nextLine();
			for (Cliente cliente : clientes) {
				if (rutBuscar.equals(cliente.getRunCliente())) {
					clienteSeleccionado = cliente;
				}
			}

			if (clienteSeleccionado == null) {
				System.out.println("Ingrese un RUN válido");
			}
		} while (clienteSeleccionado == null);

		CategoriaEnum.categoriaEnum contrario;
		if (clienteSeleccionado.getCategoria() == categoriaEnum.ACTIVO) {
			contrario = categoriaEnum.INACTIVO;
		} else {
			contrario = categoriaEnum.ACTIVO;
		}

		boolean opcionNoValida = true;
		do {
			System.out.println("-----Actualizando estado del cliente----");
			System.out.println("El estado actual es:" + clienteSeleccionado.getCategoria());
			System.out.println("1.-Si desea cambiar el estado del cliente a " + contrario);
			System.out.println("2.-Si desea mantener el estado del cliente en " + clienteSeleccionado.getCategoria());
			System.out.println("Ingrese una opción:");
			System.out.println("----------------------------------------");
			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				opcion = 0;
			}
			if (opcion == 0) {
				System.out.println("Ingrese un número");
			} else if (opcion == 1) {
				clienteSeleccionado.setCategoria(contrario);
				opcionNoValida = false;
			} else if (opcion == 2) {
				opcionNoValida = false;
			} else {
				System.out.println("Ingrese una opción válida");
			}
		} while (opcionNoValida);
		System.out.println("Datos cambiados con éxito");
	}

	private void editarDatosDeCliente() {
		ArrayList<Cliente> clientes = clienteServicio.getListaClientes();
		Cliente clienteSeleccionado = null;
		do {

			System.out.println("Ingrese RUT del cliente a editar:");
			String rutBuscar = sc.nextLine();
			for (Cliente cliente : clientes) {
				if (rutBuscar.equals(cliente.getRunCliente())) {
					clienteSeleccionado = cliente;
				}
			}

			if (clienteSeleccionado == null) {
				System.out.println("Ingrese un RUT valido");
			}
		} while (clienteSeleccionado == null);

		@SuppressWarnings("unused")
		CategoriaEnum.categoriaEnum contrario;
		if (clienteSeleccionado.getCategoria() == categoriaEnum.ACTIVO) {
			contrario = categoriaEnum.INACTIVO;
		} else {
			contrario = categoriaEnum.ACTIVO;
		}

		boolean opcionNoValida = true;
		do {
			System.out.println("-----Actualizando datos del cliente----");
			System.out.println("1.-El RUT del cliente es: " + clienteSeleccionado.getRunCliente());
			System.out.println("2.-El Nombre del cliente es: " + clienteSeleccionado.getNombreCliente());
			System.out.println("3.-El Apellido del cliente es: " + clienteSeleccionado.getApellidoCliente());
			System.out.println("4.-Los años como cliente son: " + clienteSeleccionado.getAnioCliente() + " años");
			System.out.println("----------------------------------------");
			System.out.print("Elija una opción:");
			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				opcion = 0;
			}
			if (opcion == 0) {
				System.out.println("Ingrese un numero");
			} else if (opcion == 1) {
				System.out.println("----------------------------------------");
				System.out.println("1.-Ingrese nuevo RUT del cliente:");
				System.out.println("----------------------------------------");
				String nuevoRut = sc.nextLine();
				System.out.println("----------------------------------------");
				clienteSeleccionado.setRunCliente(nuevoRut);
				opcionNoValida = false;
			} else if (opcion == 2) {
				System.out.println("----------------------------------------");
				System.out.println("2.-Ingrese su nuevo nombre: ");
				System.out.println("----------------------------------------");
				String nuevoNombre = sc.nextLine();
				System.out.println("----------------------------------------");
				clienteSeleccionado.setNombreCliente(nuevoNombre);
				opcionNoValida = false;
			} else if (opcion == 3) {
				System.out.println("----------------------------------------");
				System.out.println("3.-Ingrese su nuevo apellido: ");
				System.out.println("----------------------------------------");
				String nuevoApellido = sc.nextLine();
				System.out.println("----------------------------------------");
				clienteSeleccionado.setApellidoCliente(nuevoApellido);
				opcionNoValida = false;
			} else if (opcion == 4) {
				System.out.println("----------------------------------------");
				System.out.println("1.-Cambie sus años como cliente: ");
				System.out.println("----------------------------------------");
				int nuevoAnio = 0;
				boolean noEsValido = true;
				do {
					try {
						nuevoAnio = Integer.parseInt(sc.nextLine());
						noEsValido = false;
					} catch (Exception e) {
						System.out.println("Ingresa un numero");
					}
				} while (noEsValido);
				System.out.println("----------------------------------------");
				clienteSeleccionado.setAnioCliente(nuevoAnio);
				opcionNoValida = false;
			} else {
				System.out.println("Ingrese una opción válida");
			}
		} while (opcionNoValida);
		System.out.println("Datos cambiados con éxito");
	}

	private void importarDatos() {
		if (esWindows) {
			System.out.println("---------Importar Datos en Windows-----------");
		} else {
			System.out.println("---------Importar Datos en Linux o Mac-----------");
		}
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		System.out.println("Ejemplo");
		if (esWindows) {
			System.out.println("C:\\\\usuario\\equipo\\Desktop");
		} else {
			System.out.println("home/usuario/Desktop");
		}
		System.out.println("-----------------------------------------------");
		System.out.print(">");
		String ruta = sc.nextLine();
		archivoServicio.cargarDatos(ruta + "\\" + fileName1);
		System.out.println("Datos cargados correctamente en la lista");
		System.out.println("-----------------------------------------------");
	}

	private void exportarDatos() {
		do {
			System.out.println("---------Exportar Datos-----------");
			System.out.println("Seleccione el formato a exportar");
			System.out.println("1.-Formato csv");
			System.out.println("2.-Formato txt");
			System.out.println();
			System.out.print("Ingrese una opción para exportar: ");
			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				opcion = 0;
				System.out.println("Ingresa un número!");
			}
			if (opcion != 1 && opcion != 2) {
				opcion = 0;
				System.out.println("Ingresa una opción válida!");
			}
			System.out.println("----------------------------------");
		} while (opcion == 0);

		if (esWindows) {
			System.out.println("---------Exportar Datos en Windows-----------");
		} else {
			System.out.println("---------Exportar Datos en Linux o Mac-----------");
		}
		if (opcion == 1) {
			System.out.println("Ingresa la ruta en donde desea exportar el archivo DBClientes.csv:");
		} else if (opcion == 2) {
			System.out.println("Ingresa la ruta en donde desea exportar el archivo DBClientes.txt:");
		}
		System.out.println("Ejemplo");
		if (esWindows) {
			System.out.println("C:\\\\usuario\\equipo\\Desktop");
		} else {
			System.out.println("home/usuario/Desktop");
		}
		System.out.println("-----------------------------------------------");
		System.out.print(">");
		String ruta = sc.nextLine();
		if (opcion == 1) {
			exportadorCsv.exportar(ruta + "\\" + fileName, clienteServicio.getListaClientes());
			System.out.println("Datos de clientes exportados correctamente en formato csv.");
		} else if (opcion == 2) {
			exportadorTxt.exportar(ruta + "\\" + fileName, clienteServicio.getListaClientes());
			System.out.println("Datos de clientes exportados correctamente en formato txt.");
		}
		System.out.println("-----------------------------------------------");
	}

}