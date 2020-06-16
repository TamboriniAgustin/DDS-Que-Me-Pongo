@startuml
class BorradorPrenda{
   TipoDePrenda tipo
   Material material
   Trama trama
   Color colorPrincipal
   Color colorSecundario

   void establecerTipo(TipoDePrenda tipo)
   void establecerMaterial(Material material)
   void establecerColorPrincipal(Color color)
   void establecerColorSecundario(Color color)
   void establecerTrama(Trama trama)
   void generarPrenda()
}
class Prenda{
   TipoDePrenda tipo
   Material material
   Trama trama
   Color colorPrincipal
   Color colorSecundario

   Categoria getCategoria()
}
class TipoDePrenda{
   Categoria categoria
}
enum Categoria{
   SUPERIOR, INFERIOR, CALZADO, ACCESORIO
}
enum Material{
   TELA, LANA, ...
}
class Color{
   int r
   int g
   int b
   int a
}
enum Trama{
   LISA, RAYADA, LUNARES, ...
}
class Uniforme{
   Prenda prendaSuperior
   Prenda prendaInferior
   Prenda calzado
}
abstract class Sastre {
   void fabricarParteSuperior()
   void fabricarParteInferior()
   void fabricarCalzado()
   void fabricarUniforme()
}
class SastreMock{
   void fabricarParteSuperior()
   void fabricarParteInferior()
   void fabricarCalzado()
   void fabricarUniforme()
}
class Clima{
   int temperatura
   float humedad
}
interface ServicioMeteorologico{
   Clima obtenerCondicionesClimaticas(String ciudad)
}
class ServicioMeteorologicoAccuWeather{
   Clima obtenerCondicionesClimaticas(String ciudad)
}
class AccuWeatherAPI{
   Map getWeather()
}
class ServicioMeteorologicoMock{
   Clima obtenerCondicionesClimaticas(String ciudad)
}
class AsesorDeImagen{
   
}
class Guardarropa{
   Usuario duenio
   String criterio
   List<Prenda> prendas
   List<Propuesta> propuestas

   void agregarPrenda(Prenda prenda)
   void eliminarPrenda(Prenda prenda)
   void compartirCon(Usuario usuario)
   void aceptarPropuesta(Propuesta propuesta)
   void rechazarPropuesta(Propuesta propuesta)
}
class Usuario{
   List<Guardarropa> guardarropas

   void agregarGuardarropa(Guardarropa guardarropa)
   void eliminarGuardarropa(Guardarropa guardarropa)
   void compartirGuardarropaCon(Usuario usuario)
   void aceptarPropuestaDe(Guardarropa guardarropa, Propuesta propuesta)
   void rechazarPropuestaDe(Guardarropa guardarropa, Propuesta propuesta)
   void getPrendas()
}
abstract class Propuesta{
   TipoDePropuesta tipo
   Prenda prenda

   void aceptarEn(Guardarropa guardarropa)
}
class PropuestaEliminarPrenda{
   TipoDePropuesta tipo
   Prenda prenda

   void aceptarEn(Guardarropa guardarropa)
}
class PropuestaAgregarPrenda{
   TipoDePropuesta tipo
   Prenda prenda

   void aceptarEn(Guardarropa guardarropa)
}

BorradorPrenda .up.> Prenda
Prenda -right-> "1" TipoDePrenda
TipoDePrenda --> "1" Categoria
Prenda -right-> "1" Material
Prenda -right-> "2" Color
Prenda -right-> "1" Trama
Uniforme -up-> "*" Prenda
Sastre .up.> Uniforme
SastreMock -up-|> Sastre
ServicioMeteorologico .up.> Clima
ServicioMeteorologicoAccuWeather .up.|> ServicioMeteorologico
ServicioMeteorologicoAccuWeather -down-> AccuWeatherAPI
ServicioMeteorologicoMock .up.|> ServicioMeteorologico
AsesorDeImagen -right-> "*" Prenda
AsesorDeImagen .left.> ServicioMeteorologico
Propuesta -down-> "1" Prenda
Guardarropa -down-> "*" Prenda
Guardarropa -right-> Propuesta
Usuario "1" <-down-> "*" Guardarropa
PropuestaEliminarPrenda -down-|> Propuesta
PropuestaAgregarPrenda -down-|> Propuesta
@enduml