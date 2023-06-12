package modelo;

public class Cliente {

	protected String runCliente;
	protected String nombreCliente;
	protected String apellidoCliente;
	protected int anioCliente;
	CategoriaEnum.categoriaEnum nombreCategoria;

	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, int anioCliente, CategoriaEnum.categoriaEnum nombreCategoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.anioCliente = anioCliente;
		this.nombreCategoria = nombreCategoria;
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

	public CategoriaEnum.categoriaEnum getCategoria() {
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

	public void setCategoria(CategoriaEnum.categoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "Cliente [runCliente=" + this.runCliente + ", nombreCliente=" + this.nombreCliente + ", apellidoCliente="
				+ this.apellidoCliente + ", anioCliente=" + this.anioCliente + ", Categoria=" + this.nombreCategoria + "]";
	}

}