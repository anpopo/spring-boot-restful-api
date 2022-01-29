package study.springbootrestfulapi.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Integer id;
    @Length(min = 2)
    private String name;
    @Past
    private final Date joinDate;
}
