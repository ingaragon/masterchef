package cocina

class Receta {

    Long id
    String nombre
    TipoComida tipoComida
    
    static hasMany = [ingredientes: Ingrediente, pasos: Paso]
    
    static constraints = {
    }
    
    static mapping = {
        version false
    }
}
