package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	private ArrayList<String> tasks;
	private final String FILENAME = "tasks.txt";
	
	private JFrame frame;
	private JPanel panel;
	private JButton addTask;
    private JButton viewTasks;
    private JButton removeTask;
    private JButton saveList;
    private JButton loadList;
    
    public ToDoList() {
    	tasks = new ArrayList<>();
      
    	frame = new JFrame();
    	panel = new JPanel();
    	addTask = new JButton("Add Task");
        viewTasks = new JButton("viewTasks");
        removeTask = new JButton("Remove Tasks");
        saveList = new JButton("Save List");
        loadList = new JButton("Load List");
        
        addTask.addActionListener(this);
        viewTasks.addActionListener(this);
        removeTask.addActionListener(this);
        saveList.addActionListener(this);
        loadList.addActionListener(this);
        
        panel.add(addTask);
        panel.add(viewTasks);
        panel.add(removeTask);
        panel.add(saveList);
        panel.add(loadList);
        frame.add(panel);
        frame.pack();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addTask) {
            String task = JOptionPane.showInputDialog("Enter a task:");
            tasks.add(task.trim());
	}
		else if (e.getSource() == viewTasks) {
			StringBuilder allTasks = new StringBuilder("Tasks:\n");
            for(int i = 0; i< tasks.size(); i++) {
            	allTasks.append(tasks.get(i)+ "\n");
            }
            JOptionPane.showMessageDialog(null, allTasks.toString());
		}
		else if (e.getSource() == removeTask) {
			 String taskToRemove = JOptionPane.showInputDialog("Enter the name of the task to remove:");

	                if (tasks.remove(taskToRemove)) {
	                    JOptionPane.showMessageDialog(null, "Task removed");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Task not found.");
	                }
	            
		}
		
		else if (e.getSource() == saveList) {
			for (int i = 0; i < tasks.size(); i++) {
				try {
					FileWriter fr = new FileWriter("src/_03_To_Do_List/List.txt");
					
					fr.write(tasks.get(i));
					fr.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        }
		
		else if (e.getSource() == loadList) {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
			}
		}
}
	
	
}
