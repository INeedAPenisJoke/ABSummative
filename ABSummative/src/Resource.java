import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.*;

import java.io.IOException;

public class Resource {

    private static String resourcePath = "Resources/ImageFilePaths";

    static ImageIcon background = new ImageIcon(MainCharacter.class.getResource(getPic("background")));

    static ImageIcon heartFull = new ImageIcon(MainCharacter.class.getResource("heartFull"));
    static ImageIcon heartEmpty = new ImageIcon(MainCharacter.class.getResource("heartEmpty"));

    static ImageIcon mainRestingRight = new ImageIcon(MainCharacter.class.getResource(getPic("mainRestingRight")));
    static ImageIcon mainRestingLeft = new ImageIcon(MainCharacter.class.getResource(getPic("mainRestingLeft")));
    static ImageIcon mainRunningRight = new ImageIcon(MainCharacter.class.getResource(getPic("mainRunningRight")));
    static ImageIcon mainRunningLeft = new ImageIcon(MainCharacter.class.getResource(getPic("mainRunningLeft")));
    static ImageIcon mCShield = new ImageIcon(MainCharacter.class.getResource(getPic("mCShield")));

    //private static final String bossResting = "Resources/Lust/Resting/sprite_Lust_Resting0.png";

    static ImageIcon bossRest = new ImageIcon(Boss.class.getResource(getPic("bossRest"))); //TODO: FIND GIF OF SHAWN

    /**
     * Parse strings from XML entries.
     *
     *
     * @param resourceName name of the requested resource
     * @return parsed content (string)
     */
    private static String getPic(String resourceName) {

        try {
            Document XMLTree = DocumentBuilderFactory.newInstance().
                    newDocumentBuilder().parse(ParseUtils.class.getResourceAsStream(resourcePath));
            XMLTree.getDocumentElement().normalize();

            return XMLTree.getElementsByTagName(resourceName).item(0).getTextContent();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) { //Unnecessary
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return null;

    }
}