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
     * Test of agregarDatos method, of class BDPedido.
     */
    @Test
    public void testAgregarDatos() throws Exception {
        System.out.println("agregarDatos");
        Pedido nPedido = new Pedido(1,"Paquete 2:1 orden(es)","Ensalada","2021-04-16",300);
        BDPedido instance = new BDPedido();
        instance.agregarDatos(nPedido);
    }

    /**
     * Test of consultar method, of class BDPedido.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        BDPedido instance = new BDPedido();
        ArrayList<Pedido> result = instance.consultar();
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of buscar method, of class BDPedido.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        String busqueda = "10";
        BDPedido instance = new BDPedido();
        Pedido result = instance.buscar(busqueda);
        assertNotNull(result.getIdCliente());
    }

    /**
     * Test of consultarPedidosPorNumTel method, of class BDPedido.
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
