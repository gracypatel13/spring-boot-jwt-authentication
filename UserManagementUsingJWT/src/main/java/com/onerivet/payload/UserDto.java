package com.onerivet.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
	
	private String fullName;
	//@UniqueConstraint(columnNames = { "" })
	private String userName;
	private String password;
	private String email;
	//private boolean status;
	private String role;
}
