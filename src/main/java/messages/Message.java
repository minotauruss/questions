package messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
public class Message {

    private  String message;
    private  int status;
    private Long  timeStamp = new Date().getTime();

    public  Message(int status, String message){
        this.status=status;
        this.message=message;
    }

}
