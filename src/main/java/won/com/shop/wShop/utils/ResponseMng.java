package won.com.shop.wShop.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Data
public class ResponseMng {

    private HttpStatus status;
    private  String message;
    private  Object data;

    public ResponseMng(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseMng(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


}
