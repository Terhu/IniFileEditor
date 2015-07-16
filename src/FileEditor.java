import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by mimmy on 15/07/15.
 */
public class FileEditor extends JPanel implements ActionListener {

    private JTextArea area = new JTextArea(20,120);
    /*
    private JFileChooser dialog = new JFileChooser(System.getProperty("user.dir"));
    private String currentFile = "Untitled";
    private boolean changed = false;
    */


    private final static String newline = "\n";

    public FileEditor() throws IOException {

        area.setFont(new Font("Monospaced",Font.PLAIN,12));
        JScrollPane scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(scroll,BorderLayout.CENTER);

        /*
        JMenuBar JMB = new JMenuBar();
        area.setJMenuBar(JMB);
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMB.add(file); JMB.add(edit);
        */

        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(area); //replace null with your
        // swing container
        File file;
        if(returnVal == JFileChooser.APPROVE_OPTION)
            file = chooser.getSelectedFile();
        else
            file = null;

        FileReader reader = null;
        try {
            reader = new FileReader(file);
            area.read(reader, file);
        } catch (IOException exception) {
            System.err.println("Load oops");
            exception.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException exception) {
                    System.err.println("Error closing reader");
                    exception.printStackTrace();
                }
            }
        }

    }



    public void actionPerformed(ActionEvent evt) {
        /*String text = textField.getText();
        textArea.append(text + newline);
        textField.selectAll();

        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
        */
    }


}
