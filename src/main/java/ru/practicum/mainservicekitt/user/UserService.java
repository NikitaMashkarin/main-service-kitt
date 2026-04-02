package ru.practicum.mainservicekitt.user;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers(List<Long> ids, int from, int size);

    List<UserDto> getUsers(int from, int size);

    UserDto createUser(NewUserRequestDto newUserRequestDto);

    void deleteUser(Long id);
}
