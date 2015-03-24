import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.FormatFlagsConversionMismatchException;

/**
 * @Author: Scorpion
 * @Date: 3/21/2015.
 */
public class Form extends JPanel {

    /// Attributes //
    private JButton okButton ,closeButton;
    private JTextField nameTextField , occupationTextField;
    private JLabel nameLabel , occupationLabel;
    private Border innerBorder , outerBorder;
    private GridBagConstraints formConstraints;
    private FormListener formListener;
    private FormEvent event;

    // Constructor ///
    public Form() {

        // todo initialize attributes
        okButton = new JButton("OK");
        closeButton = new JButton("Close");
        nameTextField = new JTextField(15);
        occupationTextField = new JTextField(15);
        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        innerBorder = BorderFactory.createTitledBorder("revision");
        outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        formConstraints = new GridBagConstraints();

        /// setting properties //
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300, 150));
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        positionElement();


        /// add behaviour to the buttons ///
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formListener != null) {
                    String name = nameTextField.getText();
                    String occupation = occupationTextField.getText();
                    event = new FormEvent(this,name,occupation);
                    formListener.formEventOccurred(event);
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);


            }
        });

    }

    private void positionElement() {
        /// Row one //
        formConstraints.weighty = 0.1; /// this should be the weight of the all the lines but the last

        formConstraints.insets = new Insets(0, 5, 0, 0);
        formConstraints.anchor = GridBagConstraints.LINE_END;
        formConstraints.gridy = 0;
        formConstraints.gridx = 0;
        add(nameLabel, formConstraints);


        formConstraints.anchor = GridBagConstraints.LINE_START;
        formConstraints.gridy = 0;
        formConstraints.gridx = 1;
        add(nameTextField, formConstraints);

        /// Row two ///
        formConstraints.anchor = GridBagConstraints.LINE_END;
        formConstraints.gridy = 1;
        formConstraints.gridx = 0;
        add(occupationLabel, formConstraints);

        formConstraints.anchor = GridBagConstraints.LINE_START;
        formConstraints.gridy = 1;
        formConstraints.gridx = 1;
        add(occupationTextField, formConstraints);

        /// Row three ///
        formConstraints.weighty = 2;
        formConstraints.anchor = GridBagConstraints.LINE_END;
        formConstraints.gridy = 2;
        formConstraints.gridx = 0;
        add(okButton, formConstraints);

        formConstraints.gridy = 2;
        formConstraints.gridx = 1;
        add(closeButton, formConstraints);

    }

    public void addFormListener(FormListener formListener) {
        this.formListener = formListener;
    }



}
