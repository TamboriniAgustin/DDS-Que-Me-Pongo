/** EJERCICIO - �QU� ME PONGO? - Dise�o de Sistemas - Agust�n Tamborini **/
package OpcionA;
import java.util.ArrayList;

class CorrerPrograma {
	public static void main(String[] args) {
		  //Iniciar comportamiento
	}
}

//Atuendos
class Atuendo {
	ArrayList <Prenda> prendas = new ArrayList<>();
	
	void agregarPrenda(Prenda prenda) {
		prendas.add(prenda);
	}
	void removerPrenda (Prenda prenda) {
		prendas.remove(prenda);
	}
}


//Prendas
abstract class Prenda {
	Categoria categoria;
	String tela;
	String colorPrincipal;
	String colorSecundario;
	
	Prenda(String tela_atuendo, String color_principal){
		tela = tela_atuendo;
		colorPrincipal = color_principal;
	}
	
	abstract void setCategoria();
	void setColorSecundario(String color) {
		colorSecundario = color;
	}
}

class Zapato extends Prenda {
	Zapato(String tela_atuendo, String color_principal) {
		super(tela_atuendo, color_principal);
	}
	
	void setCategoria(){
		categoria = new Calzado();
	}
}

class RemeraMangaCorta extends Prenda {
	RemeraMangaCorta(String tela_atuendo, String color_principal) {
		super(tela_atuendo, color_principal);
	}
	
	void setCategoria(){
		categoria = new Superior();
	}
}

class Pantalon extends Prenda {
	Pantalon(String tela_atuendo, String color_principal) {
		super(tela_atuendo, color_principal);
	}
	
	void setCategoria(){
		categoria = new Inferior();
	}
}


//Categorias de prendas
interface Categoria {
	
}

class Superior implements Categoria {
	
}

class Inferior implements Categoria {
	
}

class Calzado implements Categoria {
	
}

class Accesorio implements Categoria {
	
}


/** ALTERNATIVAS **/
//Podr�a utilizarse herencia en las categor�as al igual que en las prendas, dependiendo el comportamiento que se le otorgen en las siguientes iteraciones.
//Los colores podr�an representarse con herencia o interfaces, dependiendo el comportamiento que tengan en las siguientes iteraciones.
//IDEM colores para los materiales o telas.
//Podr�amos tratar con excepciones e ifs el tema de las categor�as, pero no es lo m�s ideal.