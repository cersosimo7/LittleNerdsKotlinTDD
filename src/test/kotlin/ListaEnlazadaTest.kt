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

        assertEquals(true, lista.estaVacia())
    }

    @Test
    fun agregarElemento() {
        lista.agregar(5)

        assertEquals(true, lista.tamaño() == 1)
    }

    @Test
    fun agregarElementoEnPosicion() {
        lista.agregar(1)
        lista.agregar(4)
        lista.agregar(3)
        lista.agregar(2)

        lista.agregarElementoEnPosicion(2, 5)

        val objetoEnPosicion = lista.obtener(2)

        assertEquals(5, objetoEnPosicion)
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

        val elemento = lista.primerElemento()

        assertEquals(7, elemento)
    }

    @Test
    fun obtenerPorIndice() {
        lista.agregar(3)
        lista.agregar(5)

        val elemento = lista.obtener(1)

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
            lista.obtener(2)
        }
    }

    @Test
    fun obtenerDaUnErrorBuscandoEnUnaListaVacia() {
        assertThrows<IndexOutOfBoundsException> {
            lista.obtener(2)
        }
    }
}