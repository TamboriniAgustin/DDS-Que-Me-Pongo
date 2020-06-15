@startuml
class BorradorPrenda{
   TipoDePrenda tipo
   Material material
   Trama trama
   Color colorPrincipal
   Color colorSecundario

   establecerTipo(TipoDePrenda tipo)
   establecerMaterial(Material material)
   establecerColorPrincipal(Color color)
   establecerColorSecundario(Color color)
   establecerTrama(Trama trama)
   generarPrenda()
}
class Prenda{
   TipoDePrenda tipo
   Material material
   Trama trama
   Color colorPrincipal
   Color colorSecundario

   getCategoria()
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
   fabricarParteSuperior()
   fabricarParteInferior()
   fabricarCalzado()
   fabricarUniforme()
}

BorradorPrenda .down.> Prenda
Prenda -right-> "1" TipoDePrenda
TipoDePrenda --> "1" Categoria
Prenda -right-> "1" Material
Prenda -right-> "2" Color
Prenda -right-> "1" Trama
Uniforme -right-> "*" Prenda
Sastre .up.> Uniforme
@enduml