
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class Boss extends GameThing{

    Boss(JFrame home) {
        super(home, home.getWidth()- Resource.bossRest.getIconWidth(),home.getHeight()- Resource.bossRest.getIconHeight()-56, Resource.bossRest);
    }
}