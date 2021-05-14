/**
 *
 * @author Inzunza Kevin
 * @author De La Cruz Joel
 * @author Pacheco Cesar
 * @author Avendaño Antonio
 */

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

public class TestCorte {

    private FrameFixture window;

    /**
     * Constructor de clase
     */
    public TestCorte() {
    }

    /**
     * Forza a una prueba a fallar si el acceso a los componentes de la GUI no
     * se realiza en el EDT (Event Dispatch Thread)
     */
    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    /**
     * Inicializa los dispositivos de prueba que se ejecutan cada vez que se
     * realiza un método de prueba
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
     * y libera el bloqueo de teclado y mouse para la siguiente prueba.
     */
    @After
    public void tearDown() {
        window.cleanUp();
    }

    /**
     * Metodo en donnde se simula el darle clic al botón de corte y despues
     * al botón de generar para despues iniciar un corte de caja y asignarle la 
     * direccion dada "user.dir" al fileChosser para que ahí guarde el
     * documento de corte.
     * @throws InterruptedException 
     */
    @Test
    public void realizarCorte() throws InterruptedException{
        window.button("corteBoton").focus().click();
        window.button("generar").focus().click();
        File direccion=new File(System.getProperty("user.dir"));
        window.fileChooser().focus().setCurrentDirectory(direccion).approve();
    }

}
