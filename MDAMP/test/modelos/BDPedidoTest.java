/**
 * Prueba Unitaria aplicada al modelo 'BDPedido' 
 */
package modelos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Inzunza Kevin
 * @version 17-04-2021
 */
public class BDPedidoTest {
    
    public BDPedidoTest() {
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
     * Test of agregarDatos method, of class BDPedido.
     */
    @Test
    public void testAgregarDatos() throws Exception {
        System.out.println("agregarDatos");
        Pedido nPedido = new Pedido(1,"Paquete 2:1","Ensalada","2021-04-16",300);
        BDPedido instance = new BDPedido();
        instance.agregarDatos(nPedido);
    }
    
}
