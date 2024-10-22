package ua.domain.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

public class User {

    private final int id;
    private String name;
    private String password;

    public Services createService()  {
        return new Services();
    }

}
