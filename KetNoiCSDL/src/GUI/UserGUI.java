package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import BLL.UserBLL;
import DTO.UsersDTO;
import UTILS.DBUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UserGUI extends JFrame {
	public static void main(String[] args) {
		UserGUI gui = new UserGUI("DATABASE CONNECT");
		DBUtils db = new DBUtils();
		db.getConnection();
		
	}
	
	public UserGUI(String title) {
		this.setTitle(title);
		this.setSize(new Dimension(500,500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		addControl();
		this.setVisible(true);
	}
	
	private void addControl() {
		JPanel panel = new JPanel (new BorderLayout());
		
	}
}
