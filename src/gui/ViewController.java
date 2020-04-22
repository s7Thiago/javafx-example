package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;

public class ViewController {

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Label labelResult;

    @FXML
    private Button btnSum;

    @FXML
    public void onBtSumAction() {
//        Ensuring that the number output will be with a dot and not with a comma
        Locale.setDefault(Locale.US);

        try {
            //        Storing the fields values
            double number1 = Double.parseDouble(textField1.getText());
            double number2 = Double.parseDouble(textField2.getText());

//        Calculating and showing the sum labelResult
            labelResult.setText(String.format("%.2f", (number1 + number2)));

        } catch (NumberFormatException e) {
            Alerts.showAlert("Error!", "Parse Error", e.getMessage(), Alert.AlertType.ERROR);
        }

    }


}
