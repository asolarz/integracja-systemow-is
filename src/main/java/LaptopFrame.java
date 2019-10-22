import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LaptopFrame extends Application {

    public static void main(String[] args) throws IOException {
        LaptopSpecificationCollection laptopSpecificationCollection = new LaptopSpecificationCollection();
        laptopSpecificationCollection.readFromFile("katalog.txt");
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("mainwindow.fxml"));
        Pane stackPane = loader.load();
        Scene scene = new Scene(stackPane);
        primaryStage.setTitle("Integracja systemow lab2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
