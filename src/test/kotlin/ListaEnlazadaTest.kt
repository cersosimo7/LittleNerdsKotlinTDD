import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class ListaEnlazadaTest{
    lateinit var lista : ListaEnlazada

    @BeforeEach
    internal fun setUp() {

        lista = ListaEnlazada()
    }

    @Test
    fun crearListaVacia(){

        assertEquals(true, lista.estaVacia())
    }

    @Test
    fun agregarElemento(){

        lista.agregar(5)

        assertEquals(true, lista.tamaño() == 1)
    }

    @Test
    fun obtenerUltimo(){

        lista.agregar(5)
        lista.agregar(4)

        assertEquals(4, lista.obtenerUltimo())
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
    fun obtenerPorIndice() {
        lista.agregar(3)
        val elemento = lista.obtener(0)

        assertEquals(3, elemento)
    }
}