/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Inzunza Kevin
 * @author De La Cruz Joel
 * @author Pacheco Cesar
 * @author Avendaño Antonio
 */
import java.sql.SQLException;
import org.assertj.swing.core.MouseButton;
import vistas.PrincipalFrame;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.core.matcher.JButtonMatcher.withName;
import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRegistrarPedido {

    private FrameFixture window;
    
    /**
     * Fuerza a una prueba a fallar si el acceso a los componentes de la GUI no
     * se realiza en el EDT (Event Dispatch Thread)
     */
    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    /**
     * Inicializa los dispositivos de prueba, se ejecuta cada vez que se ejecute
     * un método de prueba
     *
     * @throws java.sql.SQLException
     */
    @Before
    public void setUp() throws SQLException {
        PrincipalFrame frame = GuiActionRunner.execute(() -> new PrincipalFrame());
        window = new FrameFixture(frame);
        window.show();
    }

    /**
     * Limpia los recursos utilizados después de ejecutar cada método de prueba
     * y libera el bloqueo de teclado y moyse para la siguiente prueba
     */
    @After
    public void tearDown() {
        window.cleanUp();
    }

    /**
     * Metodo en el que se simula el registro de algún pedido para lo cual es
     * necesario hacer click en el boton de registroDePedido y hacer un par
     * de selecciones de paquetes, extras e incrementando su contador para hacer
     * referencia a la cantidad de articulos de ese tipo que se registraran
     * en el pedido para despues realizar la busqueda del cliente ingresando su
     * numero de telefono y dando click en el boton de buscar con ello tendremos
     * listo nuestro pedido y procedemos a solicitar el total a pagar del
     * cliente dando click al boton de pagar y confirmar con el boton "Yes"
     * del dialogo que emerge.
     */
//    @Test
//    public void registrarPedido() {
//        window.button("registroPedidoBoton").focus().click();
//        window.checkBox("paq1").focus().check();
//        window.spinner("cantPaq1").focus().increment();
//        window.checkBox("paq5").focus().check();
//        window.textBox("numTelefono").focus().setText("6861234567");
//        window.button("buscarBoton").focus().click();
//        window.textBox("totalCliente").focus().setText("540");
//        window.button("pagarBoton").focus().click();
//        window.dialog().focus().button(withText("Yes")).click();
//    }
//    

    /**
     * En este metodo hacemos una pequeña prueba a la accion de buscar un 
     * cliente dentro de donde registramos un pedido para agregarlo al mismo,
     * para ello debemos hacer click en el boton de registro de pedido para
     * entrar al menu donde haremos la prueba y despues en el campo de texto en 
     * donde debemos poner el numero de telefono le insertamo un numero y
     * posteriormente le damos click al boton de buscar para confirmar que 
     * exista un cliente con el numero de telefono que se ingresó
     */
//    
//    @Test
//    public void buscarClienteEnPedido(){
//        window.button("registroPedidoBoton").focus().click();
//        window.textBox("numTelefono").focus().setText("1234567890");
//        window.button("buscarBoton").focus().click();
//    }

    /**
     * Metodo en donde realizamos una pequeña prueba a la herramienta que nos 
     * ayuda a determinar el total a pagar de un cliente cunado realizamos
     * el registro de su pedido, primero que nada tenemos que entrar al menú
     * correcto simulando el click en la seccion de resgitro de pedido y ya
     * dentro hacemos seleccion de algun paquete e incrementando su contador 
     * para determinar la cantidad de articulos que va a llevar del mismo tipo
     * y finalmente obtenemos el texto del campo en donde se va actualizando
     * el total a pagar del cliente y lo comparamos con el total que ya hemos
     * calculado posteriormente del precio de los articulos que seleccionamos
     */
//    @Test
//    public void obtenerTotal() {
//        window.button("registroPedidoBoton").focus().click();
//        window.checkBox("paq1").focus().check();
//        window.spinner("cantPaq1").focus().increment();
//        window.checkBox("paq5").focus().check();
//        System.out.println(window.textBox("totalPagar").text());
//        assertThat(window.textBox("totalPagar").text()).isEqualTo("540");
//    }
}
