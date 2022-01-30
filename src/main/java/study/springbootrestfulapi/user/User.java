package study.springbootrestfulapi.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Past;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Integer id;
    @Length(min = 2, max = 30, message = "2 ~ 30 글자만 가능합니다.")
    private String name;
    @Past(message = "가입 일자는 과거만 가능합니다.")
    private final Date joinDate;
}
