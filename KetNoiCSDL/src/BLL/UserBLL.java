package BLL;

import java.util.ArrayList;

import DAL.UserDAL;
import DTO.UsersDTO;
public class UserBLL {
	UserDAL usersDAL = new UserDAL();

	 public ArrayList<UsersDTO> getAllUsers() {
	 return usersDAL.getAllUsers();
	 }

	 public ArrayList<UsersDTO> getUsersById(UsersDTO usersDTO) {
	 return usersDAL.getUsersById(usersDTO);
	 }

	 public int updateUser(UsersDTO usersDTO) {
	 int result = usersDAL.updateUser(usersDTO);
	 return result;
	 }

	 public int deleteUser(UsersDTO usersDTO) {
	 int result = usersDAL.deleteUser(usersDTO);
	 return result;
	 }
	 
	 public int insertUser(UsersDTO usersDTO){
	 int result = usersDAL.insertUser(usersDTO);
	 return result;
	 }

}
