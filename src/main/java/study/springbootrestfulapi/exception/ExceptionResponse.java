package study.springbootrestfulapi.exception;

import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
