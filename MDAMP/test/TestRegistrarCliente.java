
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

public class TestRegistrarCliente {

    private FrameFixture window;

    /**
     * Constructor de clase
     */
    public TestRegistrarCliente() {
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
//    public void registrarCliente() {
//        window.button("registroClienteBoton").focus().click();
//        window.textBox("nombre").focus().setText("Kevin");
//        window.textBox("apellido").focus().setText("Inzunza");
//        window.textBox("numTelefono").focus().setText("6861234567");
//        window.textBox("direccion").focus().setText("Benito Juarez, Mexicali");
//        window.button("aceptarBoton").focus().click();
//        window.dialog().focus().button(withText("Yes")).click();
//    }
//    

}
