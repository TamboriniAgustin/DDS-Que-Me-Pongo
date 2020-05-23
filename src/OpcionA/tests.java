package OpcionA;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Realizo los tests
class Instancias{
	//Instancio los tipos de prenda a testear
	TipoDePrenda zapato = new TipoDePrenda(Categoria.CALZADO);
	TipoDePrenda pantalon = new TipoDePrenda(Categoria.INFERIOR);
	TipoDePrenda camisa_verde = new TipoDePrenda(Categoria.SUPERIOR);
	TipoDePrenda camisa_blanca = new TipoDePrenda(Categoria.SUPERIOR);
	TipoDePrenda anteojos = new TipoDePrenda(Categoria.ACCESORIO);
	//Instancio los materiales a testear
	Material cuero = new Material();
	Material plastico = new Material();
	Material tela = new Material();
	//Instancio los colores a testear
	Color verde = new Color(0, 100, 0, 1);
	Color rojo = new Color(100, 0, 0, 1);
	Color azul = new Color(0, 0, 100, 1);
	Color blanco = new Color(100, 100, 100, 1);
	Color negro = new Color(0, 0, 0, 1);
}

class TipoDePrendaTest extends Instancias{
	@Test
	void agrego_2_materiales_correctamente() {
		camisa_verde.nuevoMaterialCompatible(tela);
		camisa_verde.nuevoMaterialCompatible(plastico);
		assertEquals(2, camisa_verde.materiales_compatibles.size());
	}
	@Test
	void material_no_agregado_no_es_compatible() {
		camisa_verde.nuevoMaterialCompatible(tela);
		camisa_verde.nuevoMaterialCompatible(plastico);
		assertFalse(camisa_verde.esCompatibleCon(cuero));
	}
	@Test
	void material_agregado_es_compatible() {
		camisa_verde.nuevoMaterialCompatible(tela);
		camisa_verde.nuevoMaterialCompatible(plastico);
		assertTrue(camisa_verde.esCompatibleCon(tela) && camisa_verde.esCompatibleCon(plastico));
	}
}

class PrendaTest extends Instancias{
	@Test
	void prenda_incompleta_no_se_genera() throws Exception {
		zapato.nuevoMaterialCompatible(cuero);
		BorradorPrenda prenda = new BorradorPrenda(zapato);
		prenda.setMaterial(cuero);
		Assertions.assertThrows(RuntimeException.class, () -> {
			prenda.crearPrenda();
		});
	}
	@Test
	void prenda_valida_sin_color_secundario() {
		BorradorPrenda prenda = new BorradorPrenda(zapato);
		zapato.nuevoMaterialCompatible(cuero);
		prenda.setMaterial(cuero);
		prenda.setColorPrincipal(rojo);
		prenda.crearPrenda();
	}
	@Test
	void prenda_valida_con_color_secundario() {
		BorradorPrenda prenda = new BorradorPrenda(zapato);
		zapato.nuevoMaterialCompatible(cuero);
		prenda.setMaterial(cuero);
		prenda.setColorPrincipal(rojo);
		prenda.setColorSecundario(azul);
		prenda.crearPrenda();
	}
}

class AtuendoTest extends Instancias {
	@Test
	void insertar_prenda() {
		BorradorPrenda prenda = new BorradorPrenda(zapato);
		zapato.nuevoMaterialCompatible(cuero);
		prenda.setMaterial(cuero);
		prenda.setColorPrincipal(rojo);
		prenda.setColorSecundario(azul);
		Prenda prendaGenerada = prenda.crearPrenda();
		//Intento insertarla en el atuendo
		Atuendo atuendo = new Atuendo();
		atuendo.agregarPrenda(prendaGenerada);
		//Valido
		assertEquals(1, atuendo.prendas.size());
	}
	@Test
	void remover_una_prenda() {
		//Genero las prendas válidas
		BorradorPrenda prenda = new BorradorPrenda(zapato);
		zapato.nuevoMaterialCompatible(cuero);
		prenda.setMaterial(cuero);
		prenda.setColorPrincipal(rojo);
		prenda.setColorSecundario(azul);
		Prenda prendaGenerada1 = prenda.crearPrenda();
		
		BorradorPrenda prenda2 = new BorradorPrenda(camisa_blanca);
		camisa_blanca.nuevoMaterialCompatible(tela);
		prenda2.setMaterial(tela);
		prenda2.setColorPrincipal(blanco);
		Prenda prendaGenerada2 = prenda2.crearPrenda();

		
		//Intentos insertarla en el atuendo y elimino una de ellas
		Atuendo atuendo = new Atuendo();
		atuendo.agregarPrenda(prendaGenerada1);
		atuendo.agregarPrenda(prendaGenerada2);
		
		atuendo.removerPrenda(prendaGenerada2);
		
		//Valido
		assertEquals(1, atuendo.prendas.size());
	}
}

class UniformeTest extends Instancias {
	@Test
	void prenda_no_repetida_es_valida() {
		//Genero la prenda válida
		BorradorPrenda prenda = new BorradorPrenda(camisa_blanca);
		camisa_blanca.nuevoMaterialCompatible(tela);
		prenda.setMaterial(tela);
		prenda.setColorPrincipal(blanco);
		Prenda prendaGenerada = prenda.crearPrenda();
		//Intento insertarla en el atuendo
		Atuendo atuendo = new Uniforme();
		atuendo.agregarPrenda(prendaGenerada);
		//Valido
		assertEquals(1, atuendo.prendas.size());
	}
	@Test
	void inserto_uniforme_completo_correctamente() {
		//Genero la prenda válida
		BorradorPrenda prendaS = new BorradorPrenda(camisa_blanca);
		camisa_blanca.nuevoMaterialCompatible(tela);
		prendaS.setMaterial(tela);
		prendaS.setColorPrincipal(blanco);
		Prenda prendaSuperior = prendaS.crearPrenda();
		
		BorradorPrenda prendaP = new BorradorPrenda(pantalon);
		pantalon.nuevoMaterialCompatible(cuero);
		prendaP.setMaterial(cuero);
		prendaP.setColorPrincipal(negro);
		Prenda prendaInferior = prendaP.crearPrenda();
		
		BorradorPrenda prendaC = new BorradorPrenda(zapato);
		zapato.nuevoMaterialCompatible(cuero);
		prendaC.setMaterial(cuero);
		prendaC.setColorPrincipal(negro);
		prendaC.setColorSecundario(blanco);
		Prenda prendaCalzado = prendaC.crearPrenda();
		
		//Intento insertarlas en el atuendo
		Atuendo atuendo = new Uniforme();
		atuendo.agregarPrenda(prendaSuperior);
		atuendo.agregarPrenda(prendaInferior);
		atuendo.agregarPrenda(prendaCalzado);
		
		//Valido
		assertEquals(3, atuendo.prendas.size());
	}
	@Test
	void categoria_repetida_es_invalida_y_lanza_error() {
		//Genero la prenda válida
		BorradorPrenda prendaS = new BorradorPrenda(camisa_blanca);
		camisa_blanca.nuevoMaterialCompatible(tela);
		prendaS.setMaterial(tela);
		prendaS.setColorPrincipal(blanco);
		Prenda prendaSuperior = prendaS.crearPrenda();
		//Intento insertarla en el atuendo
		Atuendo atuendo = new Uniforme();
		atuendo.agregarPrenda(prendaSuperior);
		//Valido
		Assertions.assertThrows(RuntimeException.class, () -> {
			atuendo.agregarPrenda(prendaSuperior);
		});
	}
	@Test
	void inserto_categoria_no_permitida_y_lanza_error() {
		//Genero la prenda válida
		BorradorPrenda prenda = new BorradorPrenda(anteojos);
		anteojos.nuevoMaterialCompatible(plastico);
		prenda.setMaterial(plastico);
		prenda.setColorPrincipal(negro);
		Prenda prendaGenerada = prenda.crearPrenda();
		//Intento insertarla en el atuendo
		Atuendo atuendo = new Uniforme();
		//Valido
		Assertions.assertThrows(RuntimeException.class, () -> {
			atuendo.agregarPrenda(prendaGenerada);
		});
	}
}