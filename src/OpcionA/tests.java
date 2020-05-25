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
		assertEquals(2, camisa_verde.getCantidadMaterialesCompatibles());
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

class SastreTest extends Instancias {
	@Test
	void sastre_crea_uniforme() {
		
	}
	@Test
	void sastre_crea_atuendo() {
		
	}
	@Test 
	void sastre_no_crea_atuendo_porque_la_categoria_supera_al_maximo_por_atuendo() {
	
	}
	@Test
	void sastre_no_crea_atuendo_porque_alguna_prenda_no_se_adecua_a_la_temperatura() {
		
	}
}

class ClimaTest extends Instancias {
	//Testeo la funcionalidad de clima en Buenos Aires, para que la API no genere costos adicionales utilizaremos un MOCK
	@Test
	void obtengo_temperatura_bsas() {
		
	}
	@Test
	void obtengo_precipitaciones_bsas() {
		
	}
	//Acá los gastos no serán reales, solo se verificará a través del MOCK que la funcionalidad sea correcta
	@Test
	void uso_la_app_10_veces_y_no_hay_costo_adicional() {
		
	}
	@Test
	void uso_la_app_10_veces_y_hay_costo_adicional() {
		
	}
}