package ua.domain.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ua.domain.api.Identifier;

@AllArgsConstructor
@Setter
@Getter

public class User implements Identifier {

    private final int id;
    private String name;
    private String password;

    public Services createService()  {
        return new Services();
    }

}
