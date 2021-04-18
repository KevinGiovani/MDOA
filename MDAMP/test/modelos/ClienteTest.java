/**
 * Prueba Unitaria aplicada al modelo 'Cliente' 
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
public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of getNombre method, of class Cliente.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Cliente instance = new Cliente();
        String expResult = "Mauricio";
        instance.setNombre(expResult);        
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Cliente.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Alma";
        Cliente instance = new Cliente();
        instance.setNombre(nombre);
         assertEquals("Alma", instance.getNombre());
    }

    /**
     * Test of getApellido method, of class Cliente.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Cliente instance = new Cliente();
        String expResult = "Guerrero";
        instance.setApellido(expResult);
        String result = instance.getApellido();
        assertEquals(expResult, result);
    }

    /**
     * Test of setApellido method, of class Cliente.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "Villa";
        Cliente instance = new Cliente();
        instance.setApellido(apellido);
         assertEquals("Villa", instance.getApellido());
    }

    /**
     * Test of getTelefono method, of class Cliente.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Cliente instance = new Cliente();
        String expResult = "6864234312";
        instance.setTelefono(expResult);
        String result = instance.getTelefono();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelefono method, of class Cliente.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "6863243111";
        Cliente instance = new Cliente();
        instance.setTelefono(telefono);
        assertEquals("6863243111", instance.getTelefono());
        
    }

    /**
     * Test of getDireccion method, of class Cliente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Cliente instance = new Cliente();
        String expResult = "CALLE RIVEROLL 1532,CENTRO";
        instance.setDireccion(expResult);
        String result = instance.getDireccion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDireccion method, of class Cliente.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String ubicacion = "DE LAS AMERICAS 657,CUAUHTEMOC NORTE";
        Cliente instance = new Cliente();
        instance.setDireccion(ubicacion);
        assertEquals("DE LAS AMERICAS 657,CUAUHTEMOC NORTE", instance.getDireccion());
    }
    
}
