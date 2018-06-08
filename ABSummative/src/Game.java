import javax.swing.*;
import java.awt.event.ActionListener;


public class Game extends SuperFrame{

    private Timer mainCharacterMove;
    private ActionListener playerControls;
    private JLabel backGround = new JLabel();
    private MainCharacter mainCharacter;
    private Boss huShawn;
    private GameThing heart1, heart2, heart3;

    Game() {
        super();
        setGame();

        makeBackground();
    }

    private void setMainCharacterControls(){
        mainCharacter.move();
        checkHP((byte) 2);
    }

    private void makeBackground(){
        setHearts();

        backGround.setIcon(Resource.background);
        backGround.setBounds(0,0,getWidth(),getHeight());
        add(backGround);

    }

    private void setHearts(){
        heart1 = new GameThing(this, 0,0 ,Resource.heartFull);
        heart2 = new GameThing(this, Resource.heartFull.getIconWidth(),0, Resource.heartFull);
        heart3 = new GameThing(this,2* Resource.heartFull.getIconWidth(),0,Resource.heartFull);
    }

    private void setGame(){
//        mainCharacter = new MainCharacter(this);
        playerControls = e -> mainCharacter.setControls(this.getRootPane());

       // mainCharacterMove = new Timer(30, e -> {setMainCharacterControls();});
        //mainCharacterMove.start();

        huShawn = new Boss(this );
    }

    private void checkHP(byte hp){ //TODO: Too much work to make efficient, try using array of JLabels to reduce amount of if-statements

        switch (hp){
            /*case 3: heart1.setIcon(Resource.heartFull); //Don't actually need this
                heart2.setIcon(Resource.heartFull);
                heart3.setIcon(Resource.heartFull);
                break;*/

            case 2: heart3.setIcon(Resource.heartEmpty);
                break;
            case 1: heart3.setIcon(Resource.heartEmpty);
                heart2.setIcon(Resource.heartEmpty);
                break;
            case 0: heart1.setIcon(Resource.heartEmpty);
                heart2.setIcon(Resource.heartEmpty);
                heart3.setIcon(Resource.heartEmpty);
                break;
        }

        /*if(hp > 3){
            hp = 3;
        }
        /*if(hp == 3){
            heart1.setIcon(Resource.heartFull);
            heart2.setIcon(Resource.heartFull);
            heart3.setIcon(Resource.heartFull);
        }
        if(hp == 2){
            heart3.setIcon(Resource.heartEmpty);
        }
        if(hp == 1){
            heart3.setIcon(Resource.heartEmpty);
            heart2.setIcon(Resource.heartEmpty);
        }
        if(hp == 0){
            heart1.setIcon(Resource.heartEmpty);
            heart2.setIcon(Resource.heartEmpty);
            heart3.setIcon(Resource.heartEmpty);
        }*/
    }

    public static void main(String[] args) {
    Game game = new Game();
}
}