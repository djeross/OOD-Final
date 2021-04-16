package presentation;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class PopUpWindowDisplay {
	private JFrame invframe=new JFrame();
	private JTable inventorytable;
	
	
	public PopUpWindowDisplay(ArrayList<Object[]> resourcelist){
		invframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		invframe.setTitle("Inventory");
		invframe.setBounds(450, 150, 600, 350);
		invframe.setResizable(false);
		invframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 594, 312);
		invframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(5, 0, 579, 311);
		panel.add(scrollPane);
		
		inventorytable = new JTable();
		inventorytable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inventorytable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		inventorytable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipment ID", "Equipment Name", "Total Quantity", "Remaining Quantity"
			}
		));
		scrollPane.setViewportView(inventorytable);
		DefaultTableModel model= (DefaultTableModel)inventorytable.getModel();
		model.setRowCount(0);
		for(Object[]record:resourcelist){
			model.addRow(new Object[]{record[0].toString(),record[1].toString(),record[2].toString(),record[3].toString()});
		}
		invframe.setVisible(true);
	}
}
