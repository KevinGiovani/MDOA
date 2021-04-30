/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author kevin
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
     * Test of agregarDatos method, of class BDCliente.
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
     * Test of buscar method, of class BDCliente.
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
     * Test of consultar method, of class BDCliente.
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
