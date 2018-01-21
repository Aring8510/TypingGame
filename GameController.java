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
import javafx.scene.text.TextFlow;
import javafx.util.Duration;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.collections.ObservableList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GameController implements Initializable {
    public int index = 0;
    public TextFlow text0;
    public Label text1;
    public Label text2;
    public Label text3;
    public Label text4;
    public Label text5;
    public Label input;
    public ImageView slot0;
    public ImageView slot1;
    public ImageView slot2;
    public String[] s;
    public String t = "";
    long startTime = 0;
    long endTime = 0;
    int focus = 0;
    long result = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
    }
    public void init(){
        read();
        printType();
        start();

    }
    public void keyAction (KeyEvent event){
        KeyCode code = event.getCode();
        String key = event.getText();
        System.out.println("key"+key);
        if(code==KeyCode.ENTER&&s[index].length()==0){
           System.out.println("ENTER pressed");
           t="";
           index++;
        }else if(key.equals("")){
           return;
        } else if (s[index].indexOf(key)==0){
            t = t.concat(s[index].substring(0,1));
            s[index]=s[index].substring(1);
            stop();
            input.setText(String.valueOf(result));
            start();
        }
        printType();
    }
    public void printType(){
        Text before = new Text(t);
        System.out.println("s : "+s[index]);
        System.out.println("t ; "+t);
        before.setFill(Color.RED);
        before.setFont(new Font(20));
        Text after = new Text(s[index]);
        after.setFont(new Font(20));
        after.setFill(Color.BLUE);
        text0.getChildren().setAll(before,after);
        Label[] texts = {text1,text2,text3,text4,text5};
        for(int i=0; i <= 4; i++) {
            if(s.length > index+i+1){
                texts[i].setText(s[index+i+1]);
            } else {
                texts[i].setText("");
            }
        }
    }
    public void read(){
        try{
            List<String> l = Files.readAllLines(Paths.get("text/text0.txt"));
            s = l.toArray(new String[l.size()]);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    void start(){
        startTime = System.currentTimeMillis();
    }
    void stop(){
        endTime = System.currentTimeMillis();
        result = endTime - startTime;
        Random rnd = new Random();
        int select;
        if (result<500){
            select = 0;
        }else{
            select = rnd.nextInt(4);
        }
        
        switch(focus){
            case 0:
                switch(select){
                    case 0:
                        slot0.setImage(new Image (getClass().getResourceAsStream("pic/0.png")));
                        break;
                    case 1:
                        slot0.setImage(new Image (getClass().getResourceAsStream("pic/1.png")));
                        break;
                    case 2:
                        slot0.setImage(new Image (getClass().getResourceAsStream("pic/2.png")));
                        break;
                    case 3:
                        slot0.setImage(new Image (getClass().getResourceAsStream("pic/3.png")));
                        break;
                }
                break;
            case 1:
                switch(select){
                    case 0:
                        slot1.setImage(new Image (getClass().getResourceAsStream("pic/0.png")));
                        break;
                    case 1:
                        slot1.setImage(new Image (getClass().getResourceAsStream("pic/1.png")));
                        break;
                    case 2:
                        slot1.setImage(new Image (getClass().getResourceAsStream("pic/2.png")));
                        break;
                    case 3:
                        slot1.setImage(new Image (getClass().getResourceAsStream("pic/3.png")));
                        break;
                }
                break;
            case 2:
                switch(select){
                    case 0:
                        slot2.setImage(new Image (getClass().getResourceAsStream("pic/0.png")));
                        break;
                    case 1:
                        slot2.setImage(new Image (getClass().getResourceAsStream("pic/1.png")));
                        break;
                    case 2:
                        slot2.setImage(new Image (getClass().getResourceAsStream("pic/2.png")));
                        break;
                    case 3:
                        slot2.setImage(new Image (getClass().getResourceAsStream("pic/3.png")));
                        break;
                }
        }
        focus++;
        if (focus==3){
            focus=0;
            
        }
        if (focus==1){
            slot1.setImage(new Image (getClass().getResourceAsStream("pic/null.png")));
            slot2.setImage(new Image (getClass().getResourceAsStream("pic/null.png")));
        }
    }
}
