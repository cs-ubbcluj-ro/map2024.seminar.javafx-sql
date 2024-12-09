package com.example.seminarjavafxsql;

import com.example.domain.Artist;
import com.example.repository.RepositoryException;
import com.example.repository.SQLArtistRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        SQLArtistRepository repository = new SQLArtistRepository("artists.bin");
//        try {
//            repository.add(new Artist(100, "Picasso", "modernist"));
//            repository.add(new Artist(101, "Da Vinci", "rennaissance"));
//            repository.add(new Artist(102, "Iulia Hasdeu", "post-modernist"));
//        } catch (RepositoryException e) {
//            throw new RuntimeException(e);
//        }


        HelloController controller = fxmlLoader.getController();
        controller.initialize(repository);


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}