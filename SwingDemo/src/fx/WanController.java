package fx;

import fx.manager.PicManager;
import fx.net.NetListener;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WanController {

    private String result="";

    @FXML
    private Button beginBtn;
    @FXML
    private TextField domTF;
    @FXML
    private TextField beginTF;
    @FXML
    private TextField endTF;
    @FXML
    private TextArea ta;
    @FXML
    protected void handleButtonAction(ActionEvent event) {
       printResult();
    }

    private void printResult(){
        String str=domTF.getText();
        int b= Integer.valueOf(beginTF.getText());
        int e=Integer.valueOf(endTF.getText());
        PicManager.getInstance().init(str, b, e, new NetListener() {
            @Override
            public void onSuccess(String str) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ta.appendText(str+"\n");
                    }
                });

            }

            @Override
            public void onFailure(String str) {
                ta.appendText("error end ");
            }
        });
        ta.appendText(result);
    }

}
