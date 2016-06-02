package cocina

class Ingrediente {

    Long id
    TipoIngrediente tipoIngrediente
    TipoMedida tipoMedida
    Double cantidad
    
    static constraints = {
    }
    
    static mapping = {
        version false
    }
}
