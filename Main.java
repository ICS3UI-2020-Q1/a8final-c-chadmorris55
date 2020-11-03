import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JLabel increaseLabel;
  JLabel countLabel;

  JTextField inputNumber;
  JTextField countNumber;

  JButton increaseButton;
  JButton resetButton;

  JPanel mainPanel;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(500,400);
    // shows the window
    frame.setVisible(true);
    //initialize the mainPanel and set format to none
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    // initilize and locate the labels
    increaseLabel = new JLabel("Increase By:");
    countLabel = new JLabel("Counter:");
    increaseLabel.setBounds(50,150,200,25);
    countLabel.setBounds(50,250,200,25);

    //initialize and locate the text fields and disable typing the in second field 
    inputNumber = new JTextField();
    countNumber = new JTextField("0");
    inputNumber.setBounds(275,135,200,60);
    countNumber.setBounds(275,235,200,60);
    countNumber.setEnabled(false);

    //initialize and locate buttons
    increaseButton = new JButton("Increase");
    resetButton = new JButton("Reset");
    increaseButton.setBounds(50,60,200,50);
    resetButton.setBounds(275,60,200,50);
    //sets action command and adds action listener to know which button was press and when a button is pressed 
    increaseButton.setActionCommand("increase");
    resetButton.setActionCommand("reset");
    increaseButton.addActionListener(this);
    resetButton.addActionListener(this);

    //adds everything to the main Panel
    mainPanel.add(increaseLabel);
    mainPanel.add(countLabel);
    mainPanel.add(inputNumber);
    mainPanel.add(countNumber);
    mainPanel.add(increaseButton);
    mainPanel.add(resetButton);

    //adds main panel top the screen
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    //checks which button was pressed
    //if the reset button was pressed then set the counter text field to "0" as specicfied
    if(command.equals("reset")){
      countNumber.setText("0");
    } else if(command.equals("increase")){
      //makes sure that whatever is in the counter box is less or equal to 10 (or whatever the threshold is) and if so, proceeds normally if its bigger then the threshold, do nothing
      //gets the number of the count so it can make sure its below or equal to 10
      String makeSure = countNumber.getText();
      int makeSureNumber = Integer.parseInt(makeSure);
      //gets the number from the input box so it can be subtracted from the threshold because without it, it would go over one more time that its supposed to
      String subtractString = inputNumber.getText();
      int subtractNumber = Integer.parseInt(subtractString);
      int stopNumber = 10 - subtractNumber;
      if(makeSureNumber <= stopNumber){
      //if the increase button was pressed then convert the nstring ion the increase box into an integer
      String increaseText = inputNumber.getText();
      int increaseNumber = Integer.parseInt(increaseText);
      //then get the text from the counter box (0 to start but will change after the increase button is hit) and convert it into an integer
      String totalOne = countNumber.getText();
      int totalEnd = Integer.parseInt(totalOne);
      // sets the text of the count number to whatever it is plus the number in the increase box
      int countOne = totalEnd + increaseNumber;
      //converts it to string so it can be put in the count box
      String countEnd = String.valueOf(countOne);
      countNumber.setText(countEnd);
      } else {}
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
