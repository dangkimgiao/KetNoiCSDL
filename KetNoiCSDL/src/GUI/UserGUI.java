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
public class UserGUI {
	private JFrame frame;
	 private JTextField txtUserId;
	 private JTextField txtUsername;
	 private JTextField txtUserpass;
	 private JComboBox<String> cmbRole;
	 private JTable tblUser;

	 /**
	  * Launch the application.
	  */
	 public static void main(String[] args) {
	 EventQueue.invokeLater(new Runnable() {
	 public void run() {
	 try {
	 UserGUI window = new UserGUI();
	 window.frame.setVisible(true);
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 }
	 });
	 }

	 /**
	  * Create the application.
	 * @return 
	  */
	 public void UserGUI() {
	 initialize();
	 loadAllUsers();
	 }

	 /**
	  * Initialize the contents of the frame.
	  */
	 private void initialize() {
	 frame = new JFrame();
	 frame.setBounds(100, 100, 513, 427);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.getContentPane().setLayout(null);

	 JPanel pnlInforUser = new JPanel();
	 pnlInforUser.setBorder(new TitledBorder(UIManager
	 .getBorder("TitledBorder.border"),
	 "Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING,
	 TitledBorder.TOP, null, Color.BLUE));
	 pnlInforUser.setBounds(0, 11, 497, 194);
	 frame.getContentPane().add(pnlInforUser);
	 pnlInforUser.setLayout(null);

	 JLabel lblUserId = new JLabel("UserId");
	 lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 lblUserId.setBounds(10, 33, 52, 14);
	 pnlInforUser.add(lblUserId);

	 txtUserId = new JTextField();
	 txtUserId.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 txtUserId.setBounds(91, 30, 163, 20);
	 pnlInforUser.add(txtUserId);
	 txtUserId.setColumns(10);
	 txtUserId.setEditable(false);

	 JLabel lblUsername = new JLabel("Username");
	 lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 lblUsername.setBounds(10, 61, 71, 14);
	 pnlInforUser.add(lblUsername);

	 txtUsername = new JTextField();
	 txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 txtUsername.setColumns(10);
	 txtUsername.setBounds(91, 58, 235, 20);
	 pnlInforUser.add(txtUsername);

	 JLabel lblUserpass = new JLabel("Userpass");
	 lblUserpass.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 lblUserpass.setBounds(10, 89, 52, 14);
	 pnlInforUser.add(lblUserpass);

	 txtUserpass = new JTextField();
	 txtUserpass.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 txtUserpass.setColumns(10);
	 txtUserpass.setBounds(91, 86, 235, 20);
	 pnlInforUser.add(txtUserpass);

	 JLabel lblUserrole = new JLabel("Userrole");
	 lblUserrole.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 lblUserrole.setBounds(10, 123, 52, 14);
	 pnlInforUser.add(lblUserrole);

	 JButton btnAdd = new JButton("Thêm mới");
	 btnAdd.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent arg0) {
	 UsersDTO usersDTO = new UsersDTO();
	 usersDTO.setUsername(txtUsername.getText());
	 usersDTO.setUserpass(txtUserpass.getText());
	 usersDTO.setUserrole(cmbRole.getSelectedItem().toString());
	 UserBLL userBLL = new UserBLL();
	 try {
	 int result = userBLL.insertUser(usersDTO);
	 if (result != 0) {
	 JOptionPane.showMessageDialog(frame,
	 "Thêm dữ liệu thành công!", "Thông báo",
	 JOptionPane.INFORMATION_MESSAGE);
	 }
	 loadAllUsers();
	 } catch (Exception ex) {
	                                     ex.printStackTrace();
	 }
	 }
	 });
	 btnAdd.setIcon(new ImageIcon(
	 "C:\\Users\\Administrator\\workspace\\eProjects\\src\\images\\Actions-list-add-user-icon.png"));
	 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 btnAdd.setBounds(90, 152, 115, 31);
	 pnlInforUser.add(btnAdd);

	 JButton btnUpdate = new JButton("Cập nhật");
	 btnUpdate.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent arg0) {
	 UsersDTO usersDTO = new UsersDTO();
	 usersDTO.setUsername(txtUsername.getText());
	 usersDTO.setUserpass(txtUserpass.getText());
	 usersDTO.setUserrole(cmbRole.getSelectedItem().toString());
	 usersDTO.setIduser(Integer.parseInt(txtUserId.getText()));
	 UserBLL userBLL = new UserBLL();
	 
	 int result = userBLL.updateUser(usersDTO);
	 if (result != 0) {
	 JOptionPane.showMessageDialog(frame,
	 "Cập nhật dữ liệu thành công!", "Thông báo",
	 JOptionPane.INFORMATION_MESSAGE);
	 loadAllUsers();
	 }
	 
	 }
	 });
	 btnUpdate
	 .setIcon(new ImageIcon(
	 "C:\\Users\\Administrator\\workspace\\eProjects\\src\\images\\Add-Male-User-icon.png"));
	 btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 btnUpdate.setBounds(208, 152, 107, 31);
	 pnlInforUser.add(btnUpdate);

	 JButton btnDelete = new JButton("Xóa");
	 btnDelete.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent arg0) {
	 UsersDTO usersDTO = new UsersDTO();
	 usersDTO.setIduser(Integer.parseInt(txtUserId.getText()));
	 UserBLL userBLL = new UserBLL();
	 int choice = JOptionPane.showConfirmDialog(frame,
	 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
	 JOptionPane.YES_NO_OPTION);
	 if (choice == JOptionPane.YES_OPTION) {
	 try {
	 @SuppressWarnings("unused")
	 int result = userBLL.deleteUser(usersDTO);
	 loadAllUsers();
	 } catch (Exception ex) {
	                                            ex.printStackTrace();
	 }
	 }
	 }
	 });
	 btnDelete
	 .setIcon(new ImageIcon(
	 "C:\\Users\\Administrator\\workspace\\eProjects\\src\\images\\Remove-Male-User-icon.png"));
	 btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 btnDelete.setBounds(317, 152, 99, 31);
	 pnlInforUser.add(btnDelete);

	 cmbRole = new JComboBox<String>();
	 cmbRole.setModel(new DefaultComboBoxModel<String>(new String[] {
	 "Quản trị", "Lập trình viên", "Kiểm thử phần mêm", "Giám đốc"}));
	 cmbRole.setFont(new Font("Tahoma", Font.PLAIN, 12));
	 cmbRole.setBounds(91, 118, 235, 20);
	 pnlInforUser.add(cmbRole);

	 JPanel pnlDataUser = new JPanel();
	 pnlDataUser.setBorder(new TitledBorder(UIManager
	 .getBorder("TitledBorder.border"),
	 "D\u1EEF li\u1EC7u ng\u01B0\u1EDDi d\u00F9ng",
	 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
	 pnlDataUser.setBounds(0, 212, 497, 179);
	 frame.getContentPane().add(pnlDataUser);
	 pnlDataUser.setLayout(null);

	 tblUser = new JTable();
	 tblUser.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
	 tblUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	 tblUser.addMouseListener(new MouseAdapter() {
	 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
	 public void mouseClicked(MouseEvent arg0) {
	 int row = tblUser.getSelectedRow();
	 if (row != -1) {
	 txtUserId.setText(tblUser.getValueAt(row, 0).toString());
	 txtUsername.setText(tblUser.getValueAt(row, 1).toString());
	 txtUserpass.setText(tblUser.getValueAt(row, 2).toString());
	 cmbRole.setSelectedItem(tblUser.getValueAt(row, 3)                                                                                                                                                                                                     .toString());
	 }
	 }
	 });
	 tblUser.setBounds(10, 18, 480, 154);
	 pnlDataUser.add(tblUser);
	 }

	 /**
	  * Get all user to display table.
	  */
	 public void loadAllUsers() {
		 //tạo control DefaultTableModel để hiển thị danh sách user
	 String[] header = { "userid", "username", "userpass", "userrole" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách UserDTO (gọi hàm getAllUsers() trong UserBUS)
	 ArrayList<UsersDTO> arr = new ArrayList<UsersDTO>();
	 UserBLL userBLL = new UserBLL();
	 arr = userBLL.getAllUsers();
	 
	 //Duyệt mảng userDTO vừa lấy được: arr
	 UsersDTO usersDTO = new UsersDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 usersDTO = arr.get(i);
		 
		 int id = usersDTO.getIduser();
		 String username = usersDTO.getUsername();
		 String userpass = usersDTO.getUserpass();
		 String userrole = usersDTO.getUserrole();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { id, username, userpass, userrole };
		 dtm.addRow(row);
	 }
	 tblUser.setModel(dtm);
	 }
}