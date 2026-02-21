package ticTAK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener 
{
    JFrame window = new JFrame("Tic Tac Toe");
    JButton[] buttons = new JButton[9];
    boolean suyanshTurn = true; // Pehle 'X' ki turn hogi

    public TicTacToe() 
    {
        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3, 3)); // 3x3 ka grid banane ke liye

        for (int i = 0; i < 9; i++) 
        {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].addActionListener(this);
            window.add(buttons[i]);
        }

        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    
    {
        JButton clickedButton = (JButton) e.getSource();
        
        
        if (clickedButton.getText().equals("")) 
        {
            if (suyanshTurn) 
            {
                clickedButton.setText("suryansh");
                clickedButton.setForeground(Color.RED);
            } 
            else 
            {
                clickedButton.setText("shivsnshu");
                clickedButton.setForeground(Color.BLUE);
            }
            suyanshTurn = !suyanshTurn; // Turn badalne ke liye
            checkWinner();
        }
    }

    public void checkWinner()
    {
        // Winning patterns (Rows, Columns, Diagonals)
        int[][] winPatterns =
        	{
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] pattern : winPatterns)
        {
            if (!buttons[pattern[0]].getText().equals("") &&
                buttons[pattern[0]].getText().equals(buttons[pattern[1]].getText()) &&
                buttons[pattern[1]].getText().equals(buttons[pattern[2]].getText()))
            {
                
                JOptionPane.showMessageDialog(window, "Player " + buttons[pattern[0]].getText() + " Wins!");
                resetBoard();
            }
        }
    }

    public void resetBoard() 
    {
        for (JButton b : buttons) b.setText("");
        suyanshTurn = true;
    }

    public static void main(String[] args)
    {
        new TicTacToe();
    }
}


	
	
	
	
	
	
	
	