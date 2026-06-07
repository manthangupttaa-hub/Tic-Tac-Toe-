import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args){

        // Use array to bypass lambda restriction
        final double[] num1 = {0};
        final double[] num2 = {0};
        final char[] operator = {' '};

        JFrame frame = new JFrame("Calculator");
        frame.setSize(300,400);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial",Font.BOLD,20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        frame.add(textField,BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,4,5,5));

        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+",
            "C"
        };

        for(String text : buttons){
            JButton btn = new JButton(text);

            btn.addActionListener(e -> {
                String command = e.getActionCommand();

                if(command.matches("[0-9.]")){
                    textField.setText(textField.getText() + command);
                }
                else if(command.matches("[+\\-*/]")){
                    num1[0] = Double.parseDouble(textField.getText());
                    operator[0] = command.charAt(0);
                    textField.setText("");
                }
                else if(command.equals("=")){
                    num2[0] = Double.parseDouble(textField.getText());
                    double result = 0;

                    switch(operator[0]){
                        case '+': result = num1[0] + num2[0]; break;
                        case '-': result = num1[0] - num2[0]; break;
                        case '*': result = num1[0] * num2[0]; break;
                        case '/': result = num1[0] / num2[0]; break;
                    }

                    textField.setText(String.valueOf(result));
                }
                else if(command.equals("C")){
                    textField.setText("");
                    num1[0] = 0;
                    num2[0] = 0;
                }
            });

            panel.add(btn);
        }

        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}