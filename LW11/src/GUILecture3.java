import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILecture3{


    public static JPanel getPanel(){
        // Q1 (2 point): return a panel with combo box of Strings containing the
        //               options "upper case", "lower case", and "delete" in that order
        //
        // Q2 (1 point): add a text area to the panel with 10 rows and 30 columns. Add the text area
        //               without a scroll pane
        //
        // Q3 (2 point): add a button (with any text) that when pressed will change the text in the
        //               text area based on the item selected from the combo box.
        //               if "upper case" is selected, change the text to all upper case letters
        //               if "lower case" is selected, change the text to all lower case letters
        //               if "delete" is selected, remove all text from the text area

    	JPanel panel = new JPanel();
    	
    	JComboBox<String> jcb = new JComboBox<String>();
    	jcb.addItem("upper case");
    	jcb.addItem("lower case");
    	jcb.addItem("delete");
    	
    	JTextArea jta = new JTextArea(10, 30);
    	
    	JButton button = new JButton("do work");
    	
    	button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(jcb.getSelectedItem().toString()){
				case "upper case":
					jta.setText(jta.getText().toUpperCase());
					break;
				case "lower case":
					jta.setText(jta.getText().toLowerCase());
					break;
				case "delete":
					jta.setText("");
					break;
				}
				
			}
		});
    	
    	panel.add(jcb);
    	panel.add(jta);
    	panel.add(button);


        return panel;
    }



    /*** You do not need to change any code below this line ***/

    public static void startGUI(){

        // create a new window
        JFrame frame = new JFrame("Text Converter");

        // set the size of the window
        frame.setSize(600,200);

        // add your frame to the left side of the window
        frame.getContentPane().add(GUILecture3.getPanel(), BorderLayout.CENTER);

        // ends the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // displays the window
        frame.setVisible(true);
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                startGUI();
            }
        });
    }


}