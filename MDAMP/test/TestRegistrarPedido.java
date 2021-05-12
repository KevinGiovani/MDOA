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
//    
//    
//    @Test
//    public void buscarClienteEnPedido(){
//        window.button("registroPedidoBoton").focus().click();
//        window.textBox("numTelefono").focus().setText("1234567890");
//        window.button("buscarBoton").focus().click();
//    }
//    
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
