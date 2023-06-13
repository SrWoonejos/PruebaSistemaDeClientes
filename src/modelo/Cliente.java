package modelo;

public class Cliente {

	protected String runCliente;
	protected String nombreCliente;
	protected String apellidoCliente;
	protected int anioCliente;
	private CategoriaEnum nombreCategoria;

	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, int anioCliente,
			       CategoriaEnum nombreCategoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.anioCliente = anioCliente;
		this.nombreCategoria = nombreCategoria;
	}

	public Cliente(String runCliente2, String nombreCliente2, String apellidoCliente2, String string, String string2) {
	}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public CategoriaEnum getCategoria() {
		return this.nombreCategoria;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public int getAnioCliente() {
		return anioCliente;
	}

	public void setAnioCliente(int anioCliente) {
		this.anioCliente = anioCliente;
	}

	public void setCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "Cliente [runCliente =" + this.runCliente + "\n" + "nombreCliente =" + this.nombreCliente + "\n"
				+ "apellidoCliente =" + this.apellidoCliente + "\n" + "anioCliente =" + this.anioCliente + "\n"
				+ "Categoria=" + this.nombreCategoria + "]";
	}

}