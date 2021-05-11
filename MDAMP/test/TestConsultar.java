
import java.awt.event.KeyEvent;
import java.io.File;
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

public class TestConsultar {

    private FrameFixture window;

    /**
     * Constructor de clase
     */
    public TestConsultar() {
    }

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
//    public void consultarCliente() throws InterruptedException {
//        window.button("consultarBoton").focus().click();
//        window.panel("izquierdaJPanel").focus().click();
//        ingresarNumero("1234");
//        window.table("tablaConsultas").focus().selectRows(0, 0);
//        System.out.println(window.table("tablaConsultas").selectionValue());
//        assertThat(window.table("tablaConsultas").selectionValue()).isEqualTo("Joel");
//    }

//    @Test
//    public void consultarPedidoPorTelefono() throws InterruptedException {
//        window.button("consultarBoton").focus().click();
//        window.panel("derechaJPanel").focus().click();
//        window.radioButton("nTelefono").focus().click();
//        window.textBox("telefono").focus().click();
//        ingresarNumero("6869876543");
//        window.table("tablaConsultas").focus().selectRows(0,0);
//        System.out.println(window.table("tablaConsultas").selectionValue());
//        assertThat(window.table("tablaConsultas").selectionValue()).isEqualTo("31");
//    }
    
//    @Test
//    public void consultarPedidoPorNumero(){
//        window.button("consultarBoton").focus().click();
//        window.panel("derechaJPanel").focus().click();
//        window.radioButton("nPedido").focus().click();
//        window.textBox("telefono").focus().click();
//        ingresarNumero("32");
//        window.table("tablaConsultas").focus().selectRows(0,0);
//        System.out.println(window.table("tablaConsultas").selectionValue());
//        assertThat(window.table("tablaConsultas").selectionValue()).isEqualTo("32");
//    }
//    
 
    private void ingresarNumero(String numero) {
        int tecla;
        for (int i = 0; i < numero.length(); i++) {
            tecla = Character.getNumericValue(numero.charAt(i));
            System.out.println(tecla);
            switch (tecla) {
                case 0: window.robot().pressAndReleaseKey(KeyEvent.VK_0);
                    break;
                case 1: window.robot().pressAndReleaseKey(KeyEvent.VK_1);
                    break;
                case 2: window.robot().pressAndReleaseKey(KeyEvent.VK_2);
                    break;
                case 3: window.robot().pressAndReleaseKey(KeyEvent.VK_3);
                    break;
                case 4: window.robot().pressAndReleaseKey(KeyEvent.VK_4);
                    break;
                case 5: window.robot().pressAndReleaseKey(KeyEvent.VK_5);
                    break;
                case 6: window.robot().pressAndReleaseKey(KeyEvent.VK_6);
                    break;
                case 7: window.robot().pressAndReleaseKey(KeyEvent.VK_7);
                    break;
                case 8: window.robot().pressAndReleaseKey(KeyEvent.VK_8);
                    break;
                case 9: window.robot().pressAndReleaseKey(KeyEvent.VK_9);
                    break;

            }

            
        }
    }

}
