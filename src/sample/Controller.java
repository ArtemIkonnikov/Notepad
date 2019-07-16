package sample;


import java.io.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;



public class Controller {


    @FXML
    private MenuItem newButton;

    @FXML
    private MenuItem openButton;

    @FXML
    private MenuItem closeButton;

    @FXML
    private MenuItem saveButton;

    @FXML
    private MenuItem exitButton;

    @FXML
    private TextArea textArea2;

    @FXML
    void initialize() {

        newButton.setOnAction(event -> {
            textArea2.setText("");
        });

        openButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                StringBuilder stringBuilder = new StringBuilder();
                String s;
                while ((s = reader.readLine()) != null) {
                    stringBuilder.append(s + "\n");
                    textArea2.setText(stringBuilder.toString());
                }
                reader.close();
            } catch (Exception e) {
                System.out.println("File not found");
            }
        });


        closeButton.setOnAction(event -> {
            textArea2.setText("");
        });


        saveButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialFileName("mytext.txt");
            File file = fileChooser.showSaveDialog(null);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(textArea2.getText() + "\n");


            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(stringBuilder.toString());
                fileWriter.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        });

        exitButton.setOnAction(event -> {
            Platform.exit();
        });

    }
}
