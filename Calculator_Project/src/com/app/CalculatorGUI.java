package com.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField displayField;
    private JButton[] digitButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton;
    private JButton clearButton;

    private double num1, num2;
    private char operator;

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Display Field
        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.PLAIN, 48));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(displayField, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 10, 10));

        digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].setFont(new Font("Arial", Font.PLAIN, 32));
            digitButtons[i].addActionListener(this);
            buttonPanel.add(digitButtons[i]);
        }

        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (JButton button : operatorButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 32));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 32));
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        digitButtons[0].setPreferredSize(new Dimension(0, 0)); // Making "0" button wider

        equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 32));
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        mainPanel.add(buttonPanel, gbc);

        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton button = (JButton) source;
            String buttonText = button.getText();

            if (buttonText.matches("[0-9]")) { // If digit button is clicked
                displayField.setText(displayField.getText() + buttonText);
            } else if (buttonText.matches("[+\\-*/]")) { // If operator button is clicked
                num1 = Double.parseDouble(displayField.getText());
                operator = buttonText.charAt(0);
                displayField.setText("");
            } else if (buttonText.equals("=")) { // If equals button is clicked
                num2 = Double.parseDouble(displayField.getText());
                double result = calculate(num1, num2, operator);
                displayField.setText(String.valueOf(result));
            } else if (buttonText.equals("C")) { // If clear button is clicked
                displayField.setText("");
            }
        }
    }

    private double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0)
                    return num1 / num2;
                else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}
