package won.com.shop.wShop.dto;

import lombok.Data;
import won.com.shop.wShop.domain.Role;

@Data
public class MemberFormDto {

    private String name;
    private String userId;
    private  String password;
    private Role role;


}
