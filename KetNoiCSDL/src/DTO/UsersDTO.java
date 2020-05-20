package DTO;

public class UsersDTO {
	   //Các thuộc tính
	 private int iduser;
	 private String username;
	 private String userpass;
	 private String userrole;

	 // Các hàm Get & Set dữ liệu
	 public int getIduser() {
	 return iduser;
	 }

	 public void setIduser(int iduser) {
	 this.iduser = iduser;
	 }

	 public String getUsername() {
	 return username;
	 }

	 public void setUsername(String username) {
	 this.username = username;
	 }

	 public String getUserpass() {
	 return userpass;
	 }

	 public void setUserpass(String userpass) {
	 this.userpass = userpass;
	 }

	 public String getUserrole() {
	 return userrole;
	 }

	 public void setUserrole(String userrole) {
	 this.userrole = userrole;
	 }
	 
	 public UsersDTO() {
	 this.iduser = 0;
	 this.username = null;
	 this.userpass = null;
	 this.userrole = null;
	 }
	 
	 public UsersDTO(int iduser, String username, String userpass, String userrole) {
	 this.iduser = iduser;
	 this.username = username;
	 this.userpass = userpass;
	 this.userrole = userrole;
	 }
	 

}
