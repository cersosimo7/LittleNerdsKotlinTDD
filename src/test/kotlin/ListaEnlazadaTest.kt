import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class ListaEnlazadaTest {
    lateinit var lista: ListaEnlazada

    @BeforeEach
    internal fun setUp() {
        lista = ListaEnlazada()
    }

    @Test
    fun crearListaVacia() {
        assertTrue(lista.estaVacia())
    }

    @Test
    fun agregarElemento() {
        lista.agregar(5)

        assertTrue(lista.tamaño() == 1)
    }

    @Test
    fun agregarPrimerElemento() {
        lista.agregarPrimero(5)

        assertTrue(lista.tamaño() == 1)
        assertEquals(5, lista.obtenerPrimero())
    }

    @Test
    fun agregarElementoEnPosicion() {
        lista.agregar(1)
        lista.agregar(4)
        lista.agregar(3)
        lista.agregar(2)

        lista.agregar(2, 5)

        val objetoEnPosicion = lista.obtenerPorIndice(2)

        assertEquals(5, objetoEnPosicion)
    }

    @Test
    fun agregarElementoEnPosicionCero() {
        lista.agregar(0, 12)

        val objetoEnPosicion = lista.obtenerPorIndice(0)

        assertEquals(12, objetoEnPosicion)
    }

    @Test
    fun agregarUltimoCuandoLaListaEstaVacia() {
        lista.agregarUltimo(5)

        assertEquals(5, lista.obtenerPrimero())
        assertEquals(1, lista.tamaño())
    }

    @Test
    fun agregarUltimoCuandoLaListaNoEstaVacia() {
        lista.agregar(3)
        lista.agregar(4)
        lista.agregar(6)

        lista.agregarUltimo(2)

        assertEquals(2, lista.obtenerPorIndice(3))
        assertEquals(2, lista.obtenerUltimo())
    }


    @Test
    fun alSacarElUltimoElementoLaListaSeReduce() {
        lista.agregar(5)
        lista.agregar(4)

        lista.sacarUltimo()

        assertEquals(1, lista.tamaño())

        assertTrue { lista.contiene(5) }
    }

    @Test
    fun eliminarDeUnaListaVacia() {

        assertThrows<NullPointerException> {
            lista.sacarUltimo()
        }
    }

    @Test
    fun contieneUnElementoDado() {
        val contiene = lista.contiene(5)

        assertTrue { contiene }
    }

    @Test
    fun obtenerPrimerElemento() {
        lista.agregar(7)
        lista.agregar(9)

        val elemento = lista.obtenerPrimero()

        assertEquals(7, elemento)
    }

    @Test
    fun obtenerPorIndice() {
        lista.agregar(3)
        lista.agregar(5)

        val elemento = lista.obtenerPorIndice(1)

        assertEquals(5, elemento)
    }

    @Test
    fun obtenerUltimo() {
        lista.agregar(5)
        lista.agregar(4)

        val elemento = lista.obtenerUltimo()

        assertEquals(4, elemento)
    }

    @Test
    fun obtenerDaUnErrorSiNoEncuentraElElemento() {
        lista.agregar(5)
        lista.agregar(4)

        assertThrows<IndexOutOfBoundsException> {
            lista.obtenerPorIndice(2)
        }
    }

    @Test
    fun obtenerDaUnErrorBuscandoEnUnaListaVacia() {
        assertThrows<IndexOutOfBoundsException> {
            lista.obtenerPorIndice(2)
        }
    }
}