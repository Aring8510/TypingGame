import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameController implements Initializable {
    public int index = 0;
    public Label text0;
    public Label text1;
    public Label text2;
    public Label text3;
    public Label text4;
    public Label text5;
    public Label input;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        printType();
    }
    public void keyAction(KeyEvent event){
        //KeyCode key = event.getCode();
        String keyInput = event.getText();
        System.out.println(keyInput);
        input.setText(keyInput);
    }
    public String[] printType(){
        String[] s = new String[5];
        String[] t = new String[5];
        try{
            File file = new File ("text/text0.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            for(int i = 0;i<5;i++){
                s[i] = br.readLine();
            }
            text0.setText(s[0]);
            text1.setText(s[1]);
            text2.setText(s[2]);
            text3.setText(s[3]);
            text4.setText(s[4]);
        }catch(Exception e){
            System.out.println(e);
        }
        return s;
    }
}
