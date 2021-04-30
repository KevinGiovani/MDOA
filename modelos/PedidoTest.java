/**
 * Prueba Unitaria aplicada al modelo 'Pedido' 
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
public class PedidoTest {
    
    public PedidoTest() {
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
     * Test of getIdPedido method, of class Pedido.
     */
    @Test
    public void testGetIdPedido() {
        System.out.println("getIdPedido");
        Pedido instance = new Pedido();
        instance.setIdPedido(1);
        int expResult = 1;
        int result = instance.getIdPedido();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdPedido method, of class Pedido.
     */
    @Test
    public void testSetIdPedido() {
        System.out.println("setIdPedido");
        int idPedido = 2;
        Pedido instance = new Pedido();
        instance.setIdPedido(idPedido);
        assertEquals(2, instance.getIdPedido());
    }

    /**
     * Test of getIdCliente method, of class Pedido.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Pedido instance = new Pedido();
        int expResult = 345;
        instance.setIdCliente(345);
        int result = (int) instance.getIdCliente();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdCliente method, of class Pedido.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        int idCliente = 346;
        Pedido instance = new Pedido();
        instance.setIdCliente(idCliente);
        assertEquals(346, instance.getIdCliente());
    }

    /**
     * Test of getPaquete method, of class Pedido.
     */
    @Test
    public void testGetPaquete() {
        System.out.println("getPaquete");
        Pedido instance = new Pedido();
        String expResult = "Paquete 1: 5";
        instance.setPaquete("Paquete 1: 5");
        String result = instance.getPaquete();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPaquete method, of class Pedido.
     */
    @Test
    public void testSetPaquete() {
        System.out.println("setPaquete");
        String paquete = "Paquete 2: 3";
        Pedido instance = new Pedido();
        instance.setPaquete(paquete);
        assertEquals("Paquete 2: 3",instance.getPaquete());
    }

    /**
     * Test of getExtra method, of class Pedido.
     */
    @Test
    public void testGetExtra() {
        System.out.println("getExtra");
        Pedido instance = new Pedido();
        String expResult = "Tortillas de Maiz";
        instance.setExtra(expResult);
        String result = instance.getExtra();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExtra method, of class Pedido.
     */
    @Test
    public void testSetExtra() {
        System.out.println("setExtra");
        String extra = "Tortillas de Harina";
        Pedido instance = new Pedido();
        instance.setExtra(extra);
        assertEquals("Tortillas de Harina",instance.getExtra());
    }

    /**
     * Test of getFecha method, of class Pedido.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Pedido instance = new Pedido();
        String expResult = "2021-04-15";
        instance.setFecha(expResult);
        String result = instance.getFecha();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFecha method, of class Pedido.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        String fecha = "2021-04-17";
        Pedido instance = new Pedido();
        instance.setFecha(fecha); 
        assertEquals("2021-04-17",instance.getFecha());
    }

    /**
     * Test of getTotal method, of class Pedido.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Pedido instance = new Pedido();
        int expResult = 1025;
        instance.setTotal(expResult);
        int result = instance.getTotal();
        assertEquals(1025, result);
    }

    /**
     * Test of setTotal method, of class Pedido.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        int total = 2050;
        Pedido instance = new Pedido();
        instance.setTotal(total);
        assertEquals(2050,instance.getTotal());
    }

    /**
     * Test of calcular method, of class Pedido.
     */
    @Test
    public void testCalcular() {
        System.out.println("calcular");
        int pos = 1;
        int valor = 2;
        Pedido instance = new Pedido();
        int expResult =1050;
        int result = instance.calcular(pos, valor);
        pos = 2;
        valor=3;
        result= instance.calcular(pos, valor);
        assertEquals(expResult, result);
        
    }
    
}
