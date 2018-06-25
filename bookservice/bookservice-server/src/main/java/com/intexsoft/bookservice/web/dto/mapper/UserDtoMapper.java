package com.intexsoft.bookservice.web.dto.mapper;

import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.web.dto.entity.UserDto;

public class UserDtoMapper extends AbstractDtoMapper<User, UserDto> {

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        return userDto;
    }
}
