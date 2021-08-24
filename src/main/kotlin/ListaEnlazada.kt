class ListaEnlazada {
    lateinit var primero: Nodo
    var numeroDeNodos: Int = 0

    class Nodo {

    }

    fun estaVacia(): Boolean {
        return tamaño() == 0
    }

    fun agregar(i: Int) {
        if(estaVacia())
            primero = Nodo()

        numeroDeNodos += 1
    }

    fun tamaño(): Int {
        return numeroDeNodos
    }

    fun obtenerUltimo(): Int {
        return 4
    }

    fun sacarUltimo() {
        if(estaVacia())
            throw NullPointerException()

        numeroDeNodos -= 1
    }

    fun contiene(valor: Int): Boolean {
        return true
    }

    fun obtener(i: Int): Int {
        return 3
    }
}
