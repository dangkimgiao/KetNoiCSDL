package DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UTILS.DBUtils;
import DTO.UsersDTO;

public class UserDAL {
	//thực hiện kết nối CSDL
	private DBUtils dbUltils = null;
	 private Connection connection = null;
	 
	 //thực hiện các câu truy vấn
	 private PreparedStatement preparedStatement = null;
	 
	 //chứa kết quả truy vấn
	 private ResultSet resultSet = null;
	 
	 /**
	  * getAllUsers method.<br>
	  * 
	  * @return resultSet;
	  */
	 public ArrayList<UsersDTO>  getAllUsers(){

	 // Khởi tạo mảng đối tượng UserDTO để chứa kết quả truy vấn
	 ArrayList<UsersDTO> result = new ArrayList<UsersDTO>();
	 String sqlSelectAll = "select * from Users";

	 try {
		 //mở kết nối tới  CSDL
	 dbUltils = new DBUtils();
	 connection = dbUltils.getConnection();
	 		//thực thi câu truy vấn
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         
	         while(resultSet.next()){
	          UsersDTO usersDTO = new UsersDTO();
	          usersDTO.setIduser(resultSet.getInt("iduser"));
	          usersDTO.setUsername(resultSet.getString("username"));
	          usersDTO.setUserpass(resultSet.getString("userpass"));
	          usersDTO.setUserrole(resultSet.getString("userrole"));
	          result.add(usersDTO);
	         }
	 }catch (SQLException e) {
	 e.printStackTrace();
	 }
	 finally{
	 try {
	 connection.close();
	 preparedStatement.close();
	 resultSet.close();
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 }
	 return result;
	 }
	 
	 /**
	  * getUsersById method.<br>
	  * 
	  * @param usersDTO
	  * @return resultSet
	  */
	 public ArrayList<UsersDTO> getUsersById(UsersDTO usersDTO){

	        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
	 ArrayList<UsersDTO> result = new ArrayList<UsersDTO>();
	 String sqlSelectById = "select * from Users where iduser = ?";
	        
	 try {
	 dbUltils = new DBUtils();
	 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setInt(1, usersDTO.getIduser());        
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	          UsersDTO user = new UsersDTO();
	          usersDTO.setIduser(resultSet.getInt("iduser"));
	          usersDTO.setUsername(resultSet.getString("username"));
	          usersDTO.setUserpass(resultSet.getString("userpass"));
	          usersDTO.setUserrole(resultSet.getString("userrole"));
	          result.add(user);
	         }
	 }catch (SQLException e) {
	 e.printStackTrace();
	 }
	 finally{
	 try {
	 connection.close();
	 preparedStatement.close();
	 resultSet.close();
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 }
	 return result;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 /**
	  * updateUser method.<br>
	  * 
	  * @param usersDTO
	  * @return result
	  */
	 public int updateUser(UsersDTO usersDTO){
	 int result = 0;
	 String sqlUpdate = "update Users set username = ?, userpass = ?, userrole = ? where iduser = ?";

	 try {
	 dbUltils = new DBUtils();
	 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlUpdate);
	         preparedStatement.setString(1, usersDTO.getUsername());
	         preparedStatement.setString(2, usersDTO.getUserpass());
	         preparedStatement.setString(3, usersDTO.getUserrole());
	         preparedStatement.setInt(4, usersDTO.getIduser());
	         result = preparedStatement.executeUpdate();
	 }catch (SQLException e) {
	 e.printStackTrace();
	 }
	 finally{
	 try {
	 connection.close();
	 preparedStatement.close();
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 }
	 return result;
	 }
	 /**
	  * deleteUser method.<br>
	  * 
	  * @param usersDTO
	  * @return result
	  */
	 public int deleteUser(UsersDTO usersDTO){
	 int result = 0;
	 String sqlDelete = "delete from Users where iduser = ?";

	 try {
	 dbUltils = new DBUtils();
	 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setInt(1, usersDTO.getIduser());
	         result = preparedStatement.executeUpdate();
	 }catch (SQLException e) {
	 e.printStackTrace();
	 }
	 finally{
	 try {
	 connection.close();
	 preparedStatement.close();
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 }
	 return result;
	 }
	 
	 public int insertUser(UsersDTO usersDTO){
	 int result = 0;
	 String sqlInsert = "insert into Users(username, userpass, userrole) values (?, ?, ?)";

	 try {
	 dbUltils = new DBUtils();
	 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlInsert);
	         preparedStatement.setString(1, usersDTO.getUsername());
	         preparedStatement.setString(2, usersDTO.getUserpass());
	         preparedStatement.setString(3, usersDTO.getUserrole());
	         result = preparedStatement.executeUpdate();
	 }catch (SQLException e) {
	 e.printStackTrace();
	 }
	 finally{
	 try {
	 connection.close();
	 preparedStatement.close();
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 }
	 return result;
	 }

}
