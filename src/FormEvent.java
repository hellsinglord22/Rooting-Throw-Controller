import java.awt.event.ActionEvent;
import java.util.EventObject;
import java.util.Objects;

/**
 * @Author: Scorpion
 * @Date: 3/21/2015.
 */
public class FormEvent extends EventObject{
    /// Attributes ///
    private String name , occupation;

    // Constructors ///
    public FormEvent(Object source , String name , String occupation) {
        super(source);
        this.name = name;
        this.occupation = occupation;
    }

    public FormEvent(Objects source) {
        super(source);
    }




    /// Gets and sets ///
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
