package com.example.seminarjavafxsql;

import com.example.domain.Artist;
import com.example.repository.RepositoryException;
import com.example.repository.SQLArtistRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class HelloController {
    public ListView<Artist> listViewArtists;
    public TextField textFieldArtistId;
    public TextField textFieldArtistName;
    public TextField textFieldArtistGenre;
    public Button buttonAdd;

    private SQLArtistRepository repository;

    ObservableList<Artist> artistsList;

    public void initialize(SQLArtistRepository repository) {
        this.repository = repository;
        artistsList = FXCollections.observableList(new ArrayList<Artist>(repository.getAll()));
        listViewArtists.setItems(artistsList);
    }

    @FXML
    protected void onHelloButtonClick() {

    }

    public void onAddButtonClicked(ActionEvent actionEvent) {
        try {
            int artistId = Integer.parseInt(textFieldArtistId.getText());
            String artistName = textFieldArtistName.getText();
            String artistGenre = textFieldArtistGenre.getText();

            var artist = new Artist(artistId, artistName, artistGenre);
            // daca la adaugarea in repository apare o exceptie, artistul nu trebuie
            // sa apara in interfata grafica
            repository.add(artist);
            artistsList.add(artist);
        } catch (NumberFormatException e) {
            Alert hopa = new Alert(Alert.AlertType.ERROR, "Id-ul artistului trebuie sa fie numar intreg pozitiv!", ButtonType.OK);
            hopa.show();
        } catch (RepositoryException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        } finally {
            textFieldArtistId.clear();
            textFieldArtistName.clear();
            textFieldArtistGenre.clear();
        }
    }

    public void onUpdateButtonClicked(ActionEvent actionEvent) {
        try {
            int artistId = Integer.parseInt(textFieldArtistId.getText());
            String artistName = textFieldArtistName.getText();
            String artistGenre = textFieldArtistGenre.getText();
            var artist = new Artist(artistId, artistName, artistGenre);

            // sterg artistul existent cu id-ul dat
            repository.remove(artistId);
            artistsList.remove(repository.findById(artistId));

            repository.add(artist);
            artistsList.add(artist);
        } catch (RepositoryException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }
}