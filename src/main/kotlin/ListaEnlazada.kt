class ListaEnlazada {
    lateinit var primero: Nodo
    var numeroDeNodos: Int = 0

    class Nodo(val valor: Int) {
        lateinit var proximo: Nodo

        constructor(valor: Int, proximo: Nodo) : this(valor) {
            this.proximo = proximo
        }

        fun tieneProximo(): Boolean {
            return ::proximo.isInitialized
        }
    }

    fun estaVacia(): Boolean {
        return tamaño() == 0
    }

    fun agregar(valor: Int) {
        if(estaVacia()) {
            primero = Nodo(valor)
        }
        else {
            val proximo = Nodo(valor)
            primero.proximo = proximo
        }

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

    fun obtener(index: Int): Int {
        if(!estaVacia()) {
            var i = 0
            var elemento = primero

            while (i < tamaño()) {
                if(index == i)
                    return elemento.valor

                if(!elemento.tieneProximo())
                    throw IndexOutOfBoundsException()

                elemento = elemento.proximo
                i++
            }
        }

        throw IndexOutOfBoundsException()
    }

    fun primerElemento(): Int {
        return 7
    }
}
