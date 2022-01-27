package study.springbootrestfulapi.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private final Date joinDate;
}
