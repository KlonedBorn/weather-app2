package edu.uwi.soscai.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class SearchBarController {
    @FXML
    private Tooltip message_tt;

    @FXML
    private TextField search_tf;

    @FXML
    void clearSearchBar(ActionEvent event) {
        System.out.println("Clearing search bar");
    }

    @FXML
    void search(ActionEvent event) {
        System.out.println("Searching for " + search_tf.getText());
    }

    @FXML
    void initialize() {
        search_tf.textProperty().addListener(new SearchBoxListener());
    }

    private class SearchBoxListener implements ChangeListener<String> {

        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

        }
    }

}