import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

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
    fun sacarUltimo() {

        lista.agregar(5)
        lista.agregar(4)
        lista.sacarUltimo()

        assertEquals(1, lista.tamaño())
    }
}