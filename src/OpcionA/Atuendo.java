/** EJERCICIO - ¿QUÉ ME PONGO? - Diseño de Sistemas - Agustín Tamborini **/
package OpcionA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Clima
class Clima {	
	public static double getTemperatura() {
		//Double que retorna la temperatura actual
		return 2.0;
	}
	public static int getProbabilidadLluvia() {
		//Int que retorna las probabilidades de lluvia
		return 1;
	}
}

//Atuendos
class Atuendo {
	private List <Prenda> prendaSuperior = new ArrayList();
	private List <Prenda> prendaInferior = new ArrayList();
	private List <Prenda> calzado = new ArrayList();
	private List <Prenda> accesorio = new ArrayList();
	private int maximoPorCategoria = 1;
	
	public Atuendo(List <Prenda> prendasSuperiores, List <Prenda> prendasInferiores, List <Prenda> calzados, List <Prenda> accesorios) {
		this.prendaSuperior = prendasSuperiores;
		this.prendaInferior = prendasInferiores;
		this.calzado = calzados;
		this.accesorio = accesorios;
	}
	
	public void agregarPrendas(Prenda superior, Prenda inferior, Prenda calzado, Prenda accesorio) {
		this.validarMaximoPrendas();
		this.validarTemperaturaPrenda(superior);
		this.validarTemperaturaPrenda(inferior);
		this.validarTemperaturaPrenda(calzado);
		this.validarTemperaturaPrenda(accesorio);
		
		this.prendaSuperior.add(superior);
		this.prendaInferior.add(inferior);
		this.calzado.add(calzado);
		this.accesorio.add(accesorio);
	}
	private void validarMaximoPrendas() {
		boolean cumplePrendaSuperior = (prendaSuperior.size() < maximoPorCategoria);
		boolean cumplePrendaInferior = (prendaInferior.size() < maximoPorCategoria);
		boolean cumpleCalzado = (calzado.size() < maximoPorCategoria);
		boolean cumpleAccesorio = (accesorio.size() < maximoPorCategoria);
		
		if(!cumplePrendaSuperior || !cumplePrendaInferior || !cumpleCalzado || !cumpleAccesorio) {
			throw new RuntimeException("No puedes añadir mas de " + maximoPorCategoria + " prendas por categoría");
		}
	}
	private void validarTemperaturaPrenda(Prenda prenda) {
		if(prenda.temperaturaMaxima() <= Clima.getTemperatura()) {
			throw new RuntimeException("La prenda " + prenda + " no es apta para utilizar con la temperatura actual");
		}
	}
}

//Uniformes
class Uniforme {
	private Prenda prendaSuperior;
	private Prenda prendaInferior;
	private Prenda calzado;
	
	public Uniforme(Prenda superior, Prenda inferior, Prenda calzado) {
		this.prendaSuperior = superior;
		this.prendaInferior = inferior;
		this.calzado = calzado;
	}
}

//Sastres
abstract class Sastre {
	protected abstract Prenda fabricarParteSuperior();
	protected abstract Prenda fabricarParteInferior();
	protected abstract Prenda fabricarCalzado();
	protected abstract Prenda fabricarAccesorio();
	
	public void fabricarUniforme() {
		new Uniforme(this.fabricarParteSuperior(), this.fabricarParteInferior(), this.fabricarCalzado());
	}
	public void sugerirAtuendo(Atuendo atuendo) {
		atuendo.agregarPrendas(this.fabricarParteSuperior(), this.fabricarParteInferior(), this.fabricarCalzado(), this.fabricarAccesorio());
	}
}

//Prendas
class BorradorPrenda {
	private TipoDePrenda tipo;
	private Material material;
	private Trama trama = Trama.LISA; 
	private Color color_principal;
	private Color color_secundario;
	private double temperaturaMaxSoportada = 0;
	
	public BorradorPrenda(TipoDePrenda tipo){
		this.tipo = tipo;
	}
	
	public Prenda crearPrenda() {
		if(this.estaLista()) {
			return new Prenda(tipo, material, trama, color_principal, color_secundario, temperaturaMaxSoportada);
		}
		else {
			throw new RuntimeException("Debes validar correctamente la prenda antes de poder guardarla");
		}
	}
	private boolean estaLista() {
		return material != null && color_principal != null;
	}
	public void setMaterial(Material material){
		if(tipo.esCompatibleCon(material)){
			this.material = material;
		}
		else {
			throw new RuntimeException("El material no es compatible con el tipo de prenda creado previamente");
		}
	}
	public void setTemperaturaMaxima(double temperatura) {
		this.temperaturaMaxSoportada = temperatura;
	}
	public void setTrama(Trama trama) {
		this.trama = trama;
	}
	public void setColorPrincipal(Color color){
		this.color_principal = color;
	}
	public void setColorSecundario(Color color){
		this.color_secundario = color;
	}
}

class Prenda {
	private TipoDePrenda tipo;
	private Material material;
	private Trama trama;
	private Color color_principal;
	private Color color_secundario;
	private double temperaturaMaxSoportada;
	
	public Prenda(TipoDePrenda tipo, Material material, Trama trama, Color cp, Color cs, double temperatura){
		this.tipo = tipo;
		this.material = material;
		this.trama = trama;
		this.color_principal = cp;
		this.color_secundario = cs;
		this.temperaturaMaxSoportada = temperatura;
	}
	public Categoria categoria(){
		return this.tipo.getCategoria();
	}
	public double temperaturaMaxima() {
		return this.temperaturaMaxSoportada;
	}
}

//Tipos de prenda
class TipoDePrenda {
	private Categoria categoria;
	private Set <Material> materiales_compatibles = new HashSet<>();
	
	public TipoDePrenda(Categoria categoria){
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void nuevoMaterialCompatible(Material material){
		materiales_compatibles.add(material);
	}
	public boolean esCompatibleCon(Material material){
		return materiales_compatibles.contains(material);
	}
}

//Categorías de prenda
enum Categoria {
	ACCESORIO, CALZADO, SUPERIOR, INFERIOR
}

//Materiales
class Material {
	private Trama trama = Trama.LISA;
	
	public void setTrama(Trama trama){
		this.trama = trama;
	}
}

//Tramas de Materiales
enum Trama {
	LISA, RAYADA, CON_LUNARES, A_CUADROS, ESTAMPADO
}

//Colores
class Color {
	private int r;
	private int g;
	private int b;
	private double a;
	
	public Color(int red, int green, int blue, double alpha){
		r = red;
		g = green;
		b = blue;
		a = alpha;
	}
}

//Condiciones Climáticas