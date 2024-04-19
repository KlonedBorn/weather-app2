package edu.uwi.soscai.controller;

import java.io.IOException;
import java.util.List;

import edu.uwi.soscai.api.GeoLocator;
import edu.uwi.soscai.model.GeoLocation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Popup;
import javafx.util.StringConverter;

public class SearchBarController {
    @FXML
    private Tooltip message_tt;

    @FXML
    private TextField search_tf;

    @FXML
    void clearSearchBar(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void initialize() {
        search_tf.textProperty().addListener(new SearchBoxListener());
    }

    private class SearchBoxListener implements ChangeListener<String> {

        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (newValue != null && !newValue.isEmpty()) {
                try {
                    List<GeoLocation> locations = GeoLocator.getLocationSearchResults(newValue, 5);
                    search_tf.setTooltip(new Tooltip("Locations found: " + locations.size()));
                    search_tf.setPromptText(newValue);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ResultPopupBox extends Popup {
        private ComboBox<GeoLocation> comboBox = new ComboBox<>();

        ResultPopupBox() {
            comboBox.setPrefWidth(220);
            comboBox.setConverter(new StringConverter<GeoLocation>() {
                @Override
                public String toString(GeoLocation object) {
                    return object.getName() + " - " + object.getCountry();
                }

                @Override
                public GeoLocation fromString(String string) {
                    return null;
                }
            });

            comboBox.setCellFactory(lv -> new ListCell<GeoLocation>() {
                @Override
                protected void updateItem(GeoLocation item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getName() + " - " + item.getCountry());
                    }
                }
            });

            comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    search_tf.setText(newValue.getName());
                    hide();
                    search(null);
                }
            });

            setAutoFix(true);
            setAutoHide(true);
            getContent().add(comboBox);
        }

        void show(List<GeoLocation> results) {
            comboBox.setItems(FXCollections.observableArrayList(results));
            show(search_tf, Side.BOTTOM, 0, 0);
        }
    }

}