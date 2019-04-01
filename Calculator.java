import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.Pos; // setting alignment of textfields

public class Calculator extends Application {

  public void start(Stage primaryStage) {

    Pane hbox = new HBox();
    Pane vbox = new VBox();


    vbox.getChildren().add(new Label("operand1: "));

    TextField textField1 = new TextField("");
    textField1.setAlignment(Pos.CENTER_RIGHT);
    vbox.getChildren().add(textField1);


    vbox.getChildren().add(new Label("operand2: "));
    TextField textField2 = new TextField("");
    textField2.setAlignment(Pos.CENTER_RIGHT);

    vbox.getChildren().add(textField2);
    vbox.getChildren().add(new Label("result: "));

    TextField textField3 = new TextField("");
    textField3.setEditable(false);
    textField3.setAlignment(Pos.CENTER_RIGHT);
    vbox.getChildren().add(textField3);

    // defining buttons
    Button button1 = new Button("+");// use a Pane
    hbox.getChildren().add(button1);
    button1.setOnAction(e -> {
      System.out.println("Button 1 was pressed");
      int x = Integer.parseInt(textField1.getText());
      int y = Integer.parseInt(textField2.getText());
      int temp = x + y;
      textField3.setText(Integer.toString(temp));
    });

    Button button2 = new Button("-");
    hbox.getChildren().add(button2);
    button2.setOnAction(e -> {
      System.out.println("Button 2 was pressed");
      int x = Integer.parseInt(textField1.getText());
      int y = Integer.parseInt(textField2.getText());
      int temp = x - y;
      textField3.setText(Integer.toString(temp));
    });

    Button button3 = new Button("*");
    hbox.getChildren().add(button3);
    button3.setOnAction(e -> {
      System.out.println("Button 3 was pressed");
      int x = Integer.parseInt(textField1.getText());
      int y = Integer.parseInt(textField2.getText());
      int temp = x * y;
      textField3.setText(Integer.toString(temp));
    });

    Button button4 = new Button("/");
    hbox.getChildren().add(button4);
    button4.setOnAction(e -> {
      System.out.println("Button 4 was pressed");
      int x = Integer.parseInt(textField1.getText());
      int y = Integer.parseInt(textField2.getText());
      int temp = x / y;
      textField3.setText(Integer.toString(temp));
    });

    vbox.getChildren().add(hbox);

    Scene scene = new Scene(vbox);
    primaryStage.setTitle("Sanjida(:");
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
