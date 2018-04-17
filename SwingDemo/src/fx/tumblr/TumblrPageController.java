package fx.tumblr;

import fx.manager.TumblrPageManager;
import fx.net.NetListener;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class TumblrPageController {
    @FXML
    Button beginBtn;
    @FXML
    Button stopBtn;
    @FXML
    TextArea curlTa;
    @FXML
    TextArea resultTa;
    @FXML
    TextField domTf;
    @FXML
    TextField nameTf;
    @FXML
    TextField beginPageTf;
    @FXML
    TextField endPageTf;

    @FXML
    protected void handleButtonAction(ActionEvent event) {
        printResult();
    }
    @FXML
    protected void stopAction(ActionEvent event) {
        TumblrPageManager.getInstance().stopTask();
    }

    private void printResult(){
        String curl=curlTa.getText();
        String d=domTf.getText();
        String n=nameTf.getText();
        int b=Integer.valueOf(beginPageTf.getText());
        int e=Integer.valueOf(endPageTf.getText());
        TumblrPageManager.getInstance().init(curl,d,n,b,e,new NetListener(){

            @Override
            public void onSuccess(String str) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        resultTa.appendText(str+"\n");
                    }
                });
            }

            @Override
            public void onFailure(String str) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        resultTa.appendText(str+"\n");
                    }
                });
            }
        });
        System.out.println(curl);
    }

}
