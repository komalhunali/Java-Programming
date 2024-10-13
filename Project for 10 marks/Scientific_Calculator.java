import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel buttonPanel;
    private String[] buttons = {
            "7", "8", "9", "/", "sqrt",
            "4", "5", "6", "*", "sin",
            "1", "2", "3", "-", "cos",
            "0", ".", "=", "+", "tan",
            "C", "^", "(", ")", "log"
    };

    private Stack<Double> numbers = new Stack<>();
    private Stack<String> operations = new Stack<>();

    public ScientificCalculator() {
        
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));

        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5, 10, 10));
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        
        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("0123456789.".contains(command)) {
            display.setText(display.getText() + command);
        } else if ("+-*/".contains(command)) {
            if (!display.getText().isEmpty()) {
                numbers.push(Double.parseDouble(display.getText()));
                display.setText("");
            }
            operations.push(command);
        } else if (command.equals("=")) {
            if (!display.getText().isEmpty()) {
                numbers.push(Double.parseDouble(display.getText()));
                display.setText("");
            }
            evaluateExpression();
        } else if (command.equals("sqrt")) {
            if (!display.getText().isEmpty()) {
                double value = Math.sqrt(Double.parseDouble(display.getText()));
                display.setText(Double.toString(value));
            }
        } else if (command.equals("sin")) {
            if (!display.getText().isEmpty()) {
                double value = Math.sin(Math.toRadians(Double.parseDouble(display.getText())));
                display.setText(Double.toString(value));
            }
        } else if (command.equals("cos")) {
            if (!display.getText().isEmpty()) {
                double value = Math.cos(Math.toRadians(Double.parseDouble(display.getText())));
                display.setText(Double.toString(value));
            }
        } else if (command.equals("tan")) {
            if (!display.getText().isEmpty()) {
                double value = Math.tan(Math.toRadians(Double.parseDouble(display.getText())));
                display.setText(Double.toString(value));
            }
        } else if (command.equals("log")) {
            if (!display.getText().isEmpty()) {
                double value = Math.log10(Double.parseDouble(display.getText()));
                display.setText(Double.toString(value));
            }
        } else if (command.equals("^")) {
            if (!display.getText().isEmpty()) {
                numbers.push(Double.parseDouble(display.getText()));
                operations.push("^");
                display.setText("");
            }
        } else if (command.equals("C")) {
            display.setText("");
            numbers.clear();
            operations.clear();
        }
    }

    private void evaluateExpression() {
        while (!operations.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            String operation = operations.pop();
            double result = 0;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b != 0) {
                        result = a / b;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
                case "^":
                    result = Math.pow(a, b);
                    break;
            }
            numbers.push(result);
        }
        display.setText(Double.toString(numbers.pop()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScientificCalculator calculator = new ScientificCalculator();
            calculator.setVisible(true);
        });
    }
}
