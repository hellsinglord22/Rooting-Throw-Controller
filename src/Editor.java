import javax.swing.*;
import java.awt.*;



/**
 * @Author: Scorpion
 * @Date: 3/21/2015.
 */
public class Editor extends JPanel {
    /// Attributes ///
    private JTextArea editingArea;

    public Editor() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 200));
        setBorder(BorderFactory.createEtchedBorder());
        // initialize attributes ///
        editingArea = new JTextArea();

        // add elements to panel
        add(new JScrollPane(editingArea));

    }

    public void append(String text) {
        this.editingArea.append(text);
    }

}
