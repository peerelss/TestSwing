package fx.tumblr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TumblrPage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // 这里的root从FXML文件中加载进行初始化，这里FXMLLoader类用于加载FXML文件
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("tumblr_page.fxml"));
            Scene scene = new Scene(root, 900, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hello World");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
