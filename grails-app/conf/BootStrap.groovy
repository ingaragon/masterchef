
import cocina.Ingrediente
import cocina.Paso
import cocina.Receta
import cocina.TipoComida
import cocina.TipoIngrediente
import cocina.TipoMedida
import cocina.sec.Role
import cocina.sec.Usuario
import cocina.sec.UsuarioRole

class BootStrap {

    def init = { servletContext ->
        
        if(!Usuario.findByUsername("admin")){
            def usuario = new Usuario(username : "admin", password : "admin123.!", accountExpired : false, accountLocked : false, passwordExpired : false).save(flush : true, failOnError : true)
            def rol01 = new Role(authority : "ROLE_ADMIN").save(flush : true, failOnError : true)
            def rol02 = new Role(authority : "ROLE_USER").save(flush : true, failOnError : true)
            def usRol01 = new UsuarioRole(usuario : usuario, role : rol01).save(flush : true, failOnError : true)
            def usRol02 = new UsuarioRole(usuario : usuario, role : rol02).save(flush : true, failOnError : true)
        }
        
        def t01, t02, t03, t04, t05, t06, t07, t08, pa01, pa02, pa03, ca01, ca02, ca03, ca04, ca05, ca06, ca07, tc01 
        def ing01, ing02, ing03, ing04, ing05, ing06, ing07, ing08, receta 
        
        if(!TipoIngrediente.get(1)){
            t01 = new TipoIngrediente(nombre : "Alcachofa(s) grande(s)").save(flush : true, failOnError : true)
        }
        if(!TipoIngrediente.get(2)){
            t02 = new TipoIngrediente(nombre : "Yogurt griego sin azucar").save(flush : true, failOnError : true)
        }
        if(!TipoIngrediente.get(3)){
            t03 = new TipoIngrediente(nombre : "Ajo picado").save(flush : true, failOnError : true)
        }
        if(!TipoIngrediente.get(4)){
            t04 = new TipoIngrediente(nombre : "Cúrcuma").save(flush : true, failOnError : true)
        }
        if(!TipoIngrediente.get(5)){
            t05 = new TipoIngrediente(nombre : "Aceite de oliva").save(flush : true, failOnError : true)
        }
        if(!TipoIngrediente.get(6)){
            t06 = new TipoIngrediente(nombre : "Jugo de limón amarillo").save(flush : true, failOnError : true)
        }
        if(!TipoIngrediente.get(7)){
            t07 = new TipoIngrediente(nombre : "Ralladura de limón amarillo").save(flush : true, failOnError : true)
        }
        if(!TipoIngrediente.get(8)){
            t08 = new TipoIngrediente(nombre : "Limón").save(flush : true, failOnError : true)
        }
        if(!Paso.get(1)){
            pa01 = new Paso(numeroPaso:1, descripcion:"Cuece la alcachofa en agua con sal. Parte el limón verde por la mitad, exprímelo en el agua y agrega la cáscara. Cuece aproximadamente por 1 hora o hasta que las hojas se desprendan fácilmente.").save(flush : true, failOnError : true)
        }
        if(!Paso.get(2)){
            pa02 = new Paso(numeroPaso:2, descripcion:"Mezcla el yogur con la cúrcuma, el ajo, el aceite de oliva y el jugo de limón; salpimienta.").save(flush : true, failOnError : true)
        }
        if(!Paso.get(3)){
            pa03 = new Paso(numeroPaso:3, descripcion:"Sirve la alcachofa con el dip y espolvorea sobre ella la ralladura de limón para llevar a la mesa.").save(flush : true, failOnError : true)
        }
        if(!TipoMedida.get(1)){
            ca01 = new TipoMedida(nombre:"Taza").save(flush : true, failOnError : true)
        }
        if(!TipoMedida.get(2)){
            ca02 = new TipoMedida(nombre:"Gramos").save(flush : true, failOnError : true)
        }
        if(!TipoMedida.get(3)){
            ca03 = new TipoMedida(nombre:"Pizca").save(flush : true, failOnError : true)
        }
        if(!TipoMedida.get(4)){
            ca04 = new TipoMedida(nombre:"Cucharada").save(flush : true, failOnError : true)
        }
        if(!TipoMedida.get(5)){
            ca05 = new TipoMedida(nombre:"Producto").save(flush : true, failOnError : true)
        }
        if(!TipoMedida.get(6)){
            ca06 = new TipoMedida(nombre:"Rama").save(flush : true, failOnError : true)
        }
        if(!TipoMedida.get(7)){
            ca07 = new TipoMedida(nombre:"Diente").save(flush : true, failOnError : true)
        }
        if(!TipoComida.get(1)){
            tc01 = new TipoComida(nombre: "Entrada").save(flush : true, failOnError : true)
        }
        if(!Ingrediente.get(1)){
            ing01 = new Ingrediente(tipoIngrediente : t01, tipoMedida : ca05, cantidad : 4.0).save(flush : true, failOnError : true)
        }
        if(!Ingrediente.get(1)){
            ing02 = new Ingrediente(tipoIngrediente : t02, tipoMedida : ca01, cantidad : 1.0).save(flush : true, failOnError : true)
        }
        if(!Ingrediente.get(1)){
            ing03 = new Ingrediente(tipoIngrediente : t03, tipoMedida : ca07, cantidad : 1.0).save(flush : true, failOnError : true)
        }
        if(!Ingrediente.get(1)){
            ing04 = new Ingrediente(tipoIngrediente : t04, tipoMedida : ca04, cantidad : 1.0).save(flush : true, failOnError : true)
        }
        if(!Ingrediente.get(1)){
            ing05 = new Ingrediente(tipoIngrediente : t05, tipoMedida : ca04, cantidad : 2.0).save(flush : true, failOnError : true)
        }
        if(!Ingrediente.get(1)){
            ing06 = new Ingrediente(tipoIngrediente : t06, tipoMedida : ca04, cantidad : 2.0).save(flush : true, failOnError : true)
        }
        if(!Ingrediente.get(1)){
            ing07 = new Ingrediente(tipoIngrediente : t07, tipoMedida : ca04, cantidad : 2.0).save(flush : true, failOnError : true)
        }
        if(!Ingrediente.get(1)){
            ing08 = new Ingrediente(tipoIngrediente : t08, tipoMedida : ca05, cantidad : 1.0).save(flush : true, failOnError : true)
        }
        if(!Receta.get(1)){
            receta = new Receta(nombre : "ALCACHOFA CON DIP DE YOGUR Y CÚRCUMA", tipoComida : tc01).save(flush : true, failOnError : true)
            receta.addToIngredientes(ing01)
            receta.addToIngredientes(ing02)
            receta.addToIngredientes(ing03)
            receta.addToIngredientes(ing04)
            receta.addToIngredientes(ing05)
            receta.addToIngredientes(ing06)
            receta.addToIngredientes(ing07)
            receta.addToIngredientes(ing08)
            
            receta.addToPasos(pa01)
            receta.addToPasos(pa02)
            receta.addToPasos(pa03)
            
            receta.save(flush : true, failOnError : true)
        }
    }
    def destroy = {
    }
}
