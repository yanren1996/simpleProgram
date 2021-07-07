package cyr;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	@Id
	@NotNull
	@Size(min = 3, max = 20,message="帳號長度限制3~20")
	private String account;

	@NotNull
	@Size(min = 8, max = 20,message="密碼長度限制8~20")
	private String password;

	@NotNull
	@Size(min = 1, max = 20,message="姓氏長度限制1~20")
	private String firstName;

	@NotNull
	@Size(min = 1, max = 20,message="名字長度限制1~20")
	private String lastName;

	@NotNull
	@NotBlank(message="請輸入信箱")
	@Email(message="請輸入正確Email格式")
	private String mail;

	public User(String account, String password, String firstName, String lastName, String mail) {
		this.account = account;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
	}

	public User() {

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "帳號:" + account + "\n密碼:" + password + "\n名字:" + firstName + "," + lastName + "\n信箱:" + mail;
	}
}
