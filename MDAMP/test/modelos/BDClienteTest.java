/**
 * Prueba Unitaria aplicada al modelo 'BDCliente' 
 */
package modelos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Inzunza Kevin
 * @version 17-04-2021
 */
public class BDClienteTest {
    
    public BDClienteTest() {
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
     * Test of agregarDatos method, of class BDCliente.
     */
    @Test
    public void testAgregarDatos() throws Exception {
        System.out.println("agregarDatos");
        Cliente nCliente = new Cliente("Test","Test","33123421","MiPolloTest");
        BDCliente instance = new BDCliente();
        int tel=33123421;
        instance.agregarDatos(nCliente);
        Cliente result = instance.buscar(tel);
        assertEquals(nCliente.getNombre(), result.getNombre());
    }

    /**
     * Test of buscar method, of class BDCliente.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int tel = 1;
        BDCliente instance = new BDCliente();
        Cliente expResult = new Cliente("Cliente","Cliente","1","MiPollo");
        Cliente result = instance.buscar(tel);
        assertEquals(expResult.getNombre(), result.getNombre());
    }
    
}
