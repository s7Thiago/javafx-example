package gui;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        Setting up fields to accept numbers only
        Constraints.setTextFieldDouble(textField1);
        Constraints.setTextFieldDouble(textField2);

//        Setting up max length to fields
        Constraints.setTextFieldMaxLength(textField1, 12);
        Constraints.setTextFieldMaxLength(textField2, 12);
    }
}
