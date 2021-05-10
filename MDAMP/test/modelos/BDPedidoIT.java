/*
 * Prueba de Integracion aplicada al modelo 'BDPedido'
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
 * @version 29-04-2021
 */
public class BDPedidoIT {
    
    public BDPedidoIT() {
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
     * Test del metodo agregarDatos de la clase BDPedido para verificar que se registro
     * un nuevo pedido en la base de datos.
     * @throws java.lang.Exception
     */
    @Test
    public void testAgregarDatos() throws Exception {
        System.out.println("agregarDatos");
        Pedido nPedido = new Pedido(1,"Paquete 2:1 orden(es)","Ensalada","2021-04-16",300);
        BDPedido instance = new BDPedido();
        instance.agregarDatos(nPedido);
    }

    /**
     * Test del metodo consultar de la clase BDPedido para verificar que se obtienem
     * los pedido desde la base de datos.
     * @throws java.lang.Exception
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        BDPedido instance = new BDPedido();
        ArrayList<Pedido> result = instance.consultar();
        assertTrue(!result.isEmpty());
    }

    /**
     * Test del metodo buscar de la clase BDPedido para verificar que se puede
     * encontrar un pedido alojado en la base de datos.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        String busqueda = "10";
        BDPedido instance = new BDPedido();
        ArrayList<Pedido> result = instance.buscar(busqueda);
        assertNotNull(result.get(0).getIdCliente());
    }

    /**
     * Test del metodo consultarPedidosPorNumTel de la clase BDPedido para verificar
     * que se obtienen todos los pedidos asociados por un cliente desde la base de 
     * datos.
     * @throws java.lang.Exception
     */
    @Test
    public void testConsultarPedidosPorNumTel() throws Exception {
        System.out.println("consultarPedidosPorNumTel");
        String busqueda = "1";
        BDPedido instance = new BDPedido();
        ArrayList<Pedido> result = instance.consultarPedidosPorNumTel(busqueda);
        assertTrue(!result.isEmpty());
    }
    
}