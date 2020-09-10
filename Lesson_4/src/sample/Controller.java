package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLOutput;

public class Controller {

    @FXML
    TextArea mainTextArea;

    @FXML
    TextField mainTextField;

    public void btnOneClickAction() {


        mainTextArea.appendText(mainTextField.getText());
        //mainTextArea.appendText("1\nHello\n");

    }
}
