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
     * Test del metodo getNombre de la clase Cliente para verificar que se obtiene
     * el nombre asignado.
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
     * Test del metodo setNombre de la clase Cliente para verificar que se agrega
     * el nombre correctamente.
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
     * Test del metodo getApellido de la clase Cliente para verificar que se obtiene
     * el apellido asignado.
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
     * Test del metodo setApellido de la clase Cliente para verificar que se agrega
     * el apellido correctamente.
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
     * Test del metodo getTelefono de la clase Cliente para verificar que se obtiene
     * el telefono asignado.
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
     * Test del metodo setTelefono de la clase Cliente para verificar que se agrega
     * el telefono correctamente.
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
     * Test del metodo getDireccion de la clase Cliente para verificar que se obtiene
     * la direccion asignada.
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
     * Test del metodo setDireccion de la clase Cliente para verificar que se agrega
     * la direccion correctamente.
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