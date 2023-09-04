package errors;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class ValidError {
    private String message;
    private  int status;
    private String path;
    private Long  timeStamp = new Date().getTime();
    private Map<String,String> validationErrors;

    public ValidError(int status, String message, String path){
        this.status=status;
        this.message = message;
        this.path=path;
    }
}
