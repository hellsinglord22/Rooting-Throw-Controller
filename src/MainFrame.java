import javax.swing.*;
import java.awt.*;

/**
 * @Author: Scorpion
 * @Date: 3/21/2015.
 */
public class MainFrame extends JFrame {

    /// Attributes ///
    private Form mainFrameForm;
    private Editor mainFrameEditor;
    private Container mainFrameContainer;

    public MainFrame(String text) {
        super(text);

        // Initialize attributes ///
        mainFrameEditor = new Editor();
        mainFrameForm = new Form();
        mainFrameContainer = getContentPane();

        // set properties ///
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /// add elements to the frame (Windows)
        mainFrameContainer.add(mainFrameEditor, BorderLayout.CENTER);
        mainFrameContainer.add(mainFrameForm, BorderLayout.WEST);

        /// add behaviour
        mainFrameForm.addFormListener(new FormListener(){
            public void formEventOccurred(FormEvent event){
                String name , occupation ;
                name = event.getName();
                occupation = event.getOccupation();
                mainFrameEditor.append(name + " | " + occupation + "\n");

            }
        });



    }


}
