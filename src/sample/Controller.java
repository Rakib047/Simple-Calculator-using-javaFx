package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import  javafx.scene.control.Label;
import  javafx.scene.control.Button;
import java.awt.*;

public class Controller {
    @FXML
    private Label result;
    private long number1=0;
    private String operator="";
    private boolean start=true;
    private Model model=new Model();
    @FXML
    public void processNumbers(ActionEvent event){
      if(start){
          result.setText("");
          start=false;
      }
      String value=((Button)event.getSource()).getText();
        System.out.println(value);
      result.setText(result.getText()+value);
    }

    @FXML
    public void processOperators(ActionEvent event){
        String value=((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty())
                return;

               operator=value;
               number1=Long.parseLong(result.getText());
               result.setText("");
        }
        else{
            System.out.println("fuck");
            if(operator.isEmpty())
                return;
            long number2=Long.parseLong(result.getText());
            float output= model.Calculate(number1,number2,operator);
            result.setText(String.valueOf(output));
            operator="";
            start=true;
        }
    }
}
