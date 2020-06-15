@startuml
class Prenda{
   TipoDePrenda tipo
   Material material
   Color colorPrincipal
   Color colorSecundario
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

Prenda -right-> "1" TipoDePrenda
TipoDePrenda --> "1" Categoria
Prenda -right-> "1" Material
Prenda -right-> "2" Color
@enduml