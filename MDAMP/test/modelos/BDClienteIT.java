/*
 * Prueba de Integracion aplicada al modelo 'BDCliente'
 */
package modelos;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Inzunza Kevin
 * @author De La Cruz Joel
 * @author Pacheco Cesar
 * @version 29-04-2021
 */
public class BDClienteIT {

    public BDClienteIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test del metodo agregarDatos de la clase BDCliente para verificar que se ha
     * ingresado un nuevo cliente a la base de datos.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAgregarDatos() throws Exception {
        System.out.println("agregarDatos");
        Cliente nCliente = new Cliente("Test", "Test", "433421", "MiPolloTest");
        BDCliente instance = new BDCliente();
        int tel = 433421;
        instance.agregarDatos(nCliente);
        Cliente result = instance.buscar(tel);
        assertEquals(nCliente.getNombre(), result.getNombre());
    }

    /**
     * Test del metodo buscar de la clase BDCliente para verificar que se 
     * encuentra un cliente desde la base de datos.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int tel = 1;
        BDCliente instance = new BDCliente();
        Cliente result = instance.buscar(tel);
        assertNotNull(result.getNombre());
    }

    /**
     * Test del metodo consultar de la clase BDCliente para verificar que
     * el metodo nos devuelve la lista de clientes en la base de datos.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        BDCliente instance = new BDCliente();
        ArrayList<Cliente> result = instance.consultar();
        assertTrue(!result.isEmpty());
    }
}