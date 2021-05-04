/*
 * Prueba Unitara aplicada al modelo 'Conexion'
 */
package modelos;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Inzunza Kevin
 * @version 29-04-2021
 */
public class ConexionTest {
    
    public ConexionTest() {
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
     * Test del metodo getConnection de la clase Conexion para verificar que se
     * establece la conexion a la base de datos correctamente.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection result = Conexion.getConnection();
        assertNotNull(result);

    }

    /**
     * Test del metodo desconectar de la clase Conexion para verificar que se
     * finalizo la conexion a la base de datos correctamente.
     * @throws java.lang.Exception
     */
    @Test
    public void testDesconectar() throws Exception {
        System.out.println("desconectar");
        Connection result = Conexion.desconectar();
        assertNotNull(result);
    }
    
}