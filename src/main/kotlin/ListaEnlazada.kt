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
            agregarPrimero(valor)
        } else {
            agregarUltimo(valor)
        }
    }

    fun agregar(index: Int, valor: Int) {
        if (index == 0 && estaVacia()) {
            agregarPrimero(valor)
            return
        }

        var i = 0
        var elemento = primero
        lateinit var anterior: Nodo

        while (i <= index) {
            if (index == i) {
                val nodo = Nodo(valor, anterior.proximo)
                anterior.proximo = nodo
            } else {
                anterior = elemento
                elemento = elemento.proximo
            }
            i++
        }
    }

    fun tamaño(): Int {
        return numeroDeNodos
    }

    fun obtenerUltimo(): Int {
        return ultimo.valor
    }

    fun sacarUltimo() {
        if (estaVacia())
            throw NullPointerException()

        numeroDeNodos -= 1
    }

    fun contiene(valor: Int): Boolean {
        return true
    }

    fun obtenerPorIndice(index: Int): Int {
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

    fun obtenerPrimero(): Int {
        return primero.valor
    }


    fun agregarPrimero(valor: Int) {
        val nodo = Nodo(valor)

        if (estaVacia()) {
            ultimo = nodo
        }

        primero = nodo
        numeroDeNodos++
    }

    fun agregarUltimo(valor: Int) {
        val nodo = Nodo(valor)

        if (estaVacia()) {
            primero = nodo
        } else {
            ultimo.proximo = nodo
        }

        ultimo = nodo
        numeroDeNodos++
    }
}

