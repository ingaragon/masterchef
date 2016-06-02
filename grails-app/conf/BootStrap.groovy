
import cocina.TipoIngrediente

class BootStrap {

    def init = { servletContext ->
        
        def t01 = new TipoIngrediente(nombre : "Alcachofa(s) grande(s)").save(flush : true, failOnError : true)
        def t02 = new TipoIngrediente(nombre : "Yogurt griego sin azucar").save(flush : true, failOnError : true)
        def t03 = new TipoIngrediente(nombre : "Ajo picado").save(flush : true, failOnError : true)
        def t04 = new TipoIngrediente(nombre : "Cúrcuma").save(flush : true, failOnError : true)
        def t05 = new TipoIngrediente(nombre : "Aceite de oliva").save(flush : true, failOnError : true)
        def t06 = new TipoIngrediente(nombre : "Jugo de limón amarillo").save(flush : true, failOnError : true)
        def t07 = new TipoIngrediente(nombre : "Ralladura de limón amarillo").save(flush : true, failOnError : true)
        def t08 = new TipoIngrediente(nombre : "Limón").save(flush : true, failOnError : true)
        
    }
    def destroy = {
    }
}
