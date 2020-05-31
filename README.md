# Qué Me Pongo - Resoluciones

## Quinta Iteración

![¡¡No se ha podido cargar la imagen!!](http://www.plantuml.com/plantuml/png/dLHTgzf047tFhrXyYaK5tqkmj58AVP1AVy2usSQ1P3UTtRLGs_z-epkQoIK9tEkBavbpvkCSs9qFG24sTQPhy5uToDWIhfcw_JQRJGgUd_ao-vzbSFA1G0ULECTOcOwcaNdSHBNtlvJw6e5A878jgAgFirIzE2mLQDC6e7mfScJq6Vu2fRclnns0u9lrXZhQTQnJbvZYxMjiq4xmUj9F7u7GCUeO26sbh6jEP0QfjWF_SLGE3Yf_HoGaSNlES4qO3A6Jjo9VajJRMqcRa4_IkrbFyXVpHhA_QOFCpWV-hTGyNohNIpmrT2LiKFuPZdZ-_cR2Fa5a2zbGLKPZqQNSq1HEVaSVFZAwK345_hEp1qCDUkS5B0bMi6AoqYzOY0tz3wFnX3Ue5B4YKy73X75lHK5IUALF-UCytdUewyNf6Un8Ns71l6syumn3UYFjNCTsNQZ5XqMwRbYhpQ-Ggdsp8OAmEjyXsmMVaucvt7pxQ3x-TDnX_mebPeoz5QF0NTStDlKB)

# Qué Me Pongo - Consignas

QuéMePongo es una empresa dedicada al armado de atuendos adecuados a las condiciones climáticas y preferencias de sus clientes. El servicio que provee se basa en tomar las prendas del guardarropas de une usuarie y generar diferentes combinaciones posibles que cubran las necesidades de les mismes en términos de distintos factores climáticos tales como temperatura, viento, sol, lluvia, etc. Asimismo, se busca que estos atuendos se adecuen de la mejor forma a las sensibilidades particulares respecto de dichos factores de cada usuarie y a sus gustos en el aspecto estético.

## Primera Iteración

Comenzaremos definiendo que un atuendo es una combinación de prendas que tiene sentido usar juntas. Algunos ejemplos de atuendos podrían ser:
tus anteojos de sol favoritos, una remera de mangas cortas azul, el pantalón que te regaló tu mamá y unas zapatillas converse.
un pañuelo verde, una remera de mangas largas rayada, un pantalón de jean y un par de botas de cuero.
una musculosa de mickey, una pollera amarilla y unas crocs.

Como primer paso para generar los atuendos, les usuaries de QuéMePongo identificaron el siguiente requerimiento como principal:

* Como usuarie de QuéMePongo, quiero poder cargar prendas válidas para generar atuendos con ellas.

Y luego, al consultar más sobre este requerimiento general, logramos descomponerlo con mayor detalle en los siguientes:

* Como usuarie de QuéMePongo, quiero especificar qué tipo de prenda estoy cargando (zapatos, camisa de mangas cortas, pantalón, etc).

* Como usuarie de QuéMePongo, quiero identificar a qué categoría pertenece una prenda (parte superior, calzado, parte inferior, accesorios).

* Como usuarie de QuéMePongo, quiero poder indicar de qué tela o material está hecha una prenda

* Como usuarie de QuéMePongo, quiero poder indicar un color principal para mis prendas

* Como usuarie de QuéMePongo, quiero poder indicar, si existe, un color secundario para mis prendas.

* Como usuarie de QuéMePongo, quiero evitar que haya prendas sin tipo, tela, categoría o color primario

* Como usuarie de QuéMePongo, quiero evitar que haya prendas cuya categoría no se condiga con su tipo. (Ej, una remera no puede ser calzado).

## Segunda Iteración

En esta iteración seguiremos trabajando sobre la carga de prendas válidas:

* Como usuarie de QuéMePongo, quiero poder cargar prendas válidas para generar atuendos con ellas.

Sin embargo, agregaremos algunos requerimiento adicionales:

* Como usuarie de QuéMePongo, quiero especificar qué trama tiene la tela de una prenda (lisa, rayada, con lunares, a cuadros o un estampado).

* Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.

* Como usuarie de QuéMePongo, quiero crear una prenda especificando en segundo lugar los aspectos relacionados a su material (colores, material, trama, etc) para evitar elegir materiales inconsistentes con el tipo de prenda.

* Como usuarie de QuéMePongo, quiero guardar un borrador de la la última prenda que empecé a cargar para continuar después.

* Como usuarie de QuéMePongo, quiero poder no indicar ninguna trama para una tela, y que por defecto ésta sea lisa.

* Como usuarie de QuéMePongo, quiero poder guardar una prenda solamente si esta es válida.

Por otro lado, el equipo de producto está analizando potenciales futuras funcionalidades para la aplicación y, a fin de tener una estimación de su complejidad, nos pidió que esbocemos una solución a los siguientes requerimientos, orientados a integrar el software con colegios e instituciones privadas:

* Como usuario QueMePongo, quiero que poder recibir sugerencias de uniformes armados.

* Como usuario QueMePongo, quiero que un uniforme siempre conste de una prenda superior, una inferior y un calzado

* Como administrador de QueMePongo, quiero poder configurar diferentes uniformes para distintas instituciones (Ej: para el colegio San Juan debe ser una chomba verde de piqué, un pantalón de acetato gris y zapatillas blancas, mientras que para el Instituto Johnson siempre será una camisa blanca, pantalón de vestir negro y zapatos negros)

## Cuarta Iteración

En esta iteración continuaremos trabajando sobre las sugerencias de atuendos:

* Como usuarie de QuéMePongo, quiero recibir sugerencias de atuendos para vestirme ajustándome a las condiciones climáticas con ropa de mi agrado

En esta oportunidad, atacaremos solamente los siguientes requerimientos específicos:

* Como usuarie de QuéMePongo, quiero poder conocer las condiciones climáticas de Buenos Aires en un momento dado para obtener sugerencias acordes.

* Como usuarie de QuéMePongo, quiero poder recibir sugerencias de atuendos que tengan una prenda para cada categoría, aunque a futuro podrán tener más (Ej.: Una remera, un pantalón, zapatos y un gorro).

* Como usuarie de QuéMePongo, quiero que al generar una sugerencia las prendas sean acordes a la temperatura actual sabiendo que para cada prenda habrá una temperatura hasta la cual es adecuada. (Ej.: “Remera de mangas largas” no es apta a más de 20°C)

* Como administradore de QuéMePongo, quiero poder configurar fácilmente diferentes servicios de obtención del clima para ajustarme a las cambiantes condiciones económicas.

* Como stakeholder de QuéMePongo, quiero poder asegurar la calidad de mi aplicación sin incurrir en costos innecesarios.

Además, tras investigar en el mercado encontramos que la conocida empresa AccuWeather provee un SDK para Java que nos entrega una lista con el clima de las próximas 12 horas en un diccionario:

"AccuWeatherAPI apiClima = new AccuWeatherAPI();
List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(“Buenos Aires, Argentina”);  condicionesClimaticas.get(0).get("PrecipitationProbability"); //Devuelve un número del 0 al 1" --> Ejemplo de integración

Nos cobra 0,05 USD por cada vez que la llamamos a partir del décimo llamado diario.

## Quinta Iteración

En esta iteración continuaremos trabajando sobre las sugerencias de atuendos:

* Como usuarie de QuéMePongo, quiero compartir mis guardarropas con otras personas.

Por ahora, comenzaremos atacando los siguientes requerimientos específicos:

* Como usuarie de QuéMePongo, quiero poder manejar varios guardarropas para separar mis prendas según diversos criterios (ropa de viaje, ropa de entrecasa, etc). 

* Como usuarie de QuéMePongo, quiero poder crear guardarropas compartidos con otros usuaries (ej, ropa que comparto con mi hermane). 

* Como usuarie de QuéMePongo, quiero que otro usuario me proponga tentativamente agregar una prenda al guardarropas.

* Como usuarie de QuéMePongo, quiero que otro usuario me proponga tentativamente quitar una prenda del guardarropas.

* Como usuarie de QuéMePongo, necesito ver todas las propuestas de modificación (agregar o quitar prendas) del guardarropas y poder aceptarlas o rechazarlas..

* Como usuarie de QuéMePongo, quiero poder deshacer las propuestas de modificación que haya aceptado.

