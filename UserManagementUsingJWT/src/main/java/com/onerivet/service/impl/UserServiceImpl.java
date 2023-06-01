package com.onerivet.service.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.entity.User;
import com.onerivet.payload.UserDto;
import com.onerivet.repository.UserRepository;
import com.onerivet.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	private UserDto userToUserDto(User user) {
		return modelMapper.map(user, UserDto.class) ;
	}
	
	private User userDtoToUser(UserDto dto) {
		return modelMapper.map(dto, User.class);
	}
	@Override
	public String addUser(UserDto dto) {
		// TODO Auto-generated method stub
		User user=userDtoToUser(dto);
		userRepository.save(user);
		return "User Added";
	}

	@Override
	public UserDto getUserById(int id) {
		// TODO Auto-generated method stub
		UserDto dto=userToUserDto(userRepository.findById(id).get());
		return dto;
	}

	@Override
	public void assignRole(String userName, String role) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUserName(userName);
		user.setRole(role);
		
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll().stream().map(this::userToUserDto).collect(Collectors.toList());
	}

}
