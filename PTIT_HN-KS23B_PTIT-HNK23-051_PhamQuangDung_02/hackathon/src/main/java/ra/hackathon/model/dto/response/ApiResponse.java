package ra.hackathon.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiResponse <T>{
    private Boolean success;
    private String message;
    private T data;
    private HttpStatus status;
}
