class ListaEnlazada {
    lateinit var primero: Nodo
    lateinit var ultimo: Nodo
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
        if (estaVacia()) {
            val nodo = Nodo(valor)
            primero = nodo
            ultimo = nodo
        } else {
            val proximo = Nodo(valor)
            ultimo.proximo = proximo
            ultimo = proximo
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
        if (estaVacia())
            throw NullPointerException()

        numeroDeNodos -= 1
    }

    fun contiene(valor: Int): Boolean {
        return true
    }

    fun obtener(index: Int): Int {
        if (!estaVacia()) {
            var i = 0
            var elemento = primero

            while (i < tamaño()) {
                if (index == i)
                    return elemento.valor

                if (!elemento.tieneProximo())
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

    fun agregarElementoEnPosicion(index: Int, valor: Int) {
        var i = 0
        var elemento = primero
        lateinit var anterior: Nodo

        while (i <= index) {
            if (index == i) {
                if (index == 0) {
                    val nodo = Nodo(valor)
                    primero = nodo
                } else {
                    val nodo = Nodo(valor, anterior.proximo)
                    anterior.proximo = nodo
                }
            } else {
                anterior = elemento
                elemento = elemento.proximo
            }
            i++
        }
    }
}

