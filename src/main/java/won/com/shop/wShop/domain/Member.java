package won.com.shop.wShop.domain;

import jakarta.persistence.*;
import kotlin.ExperimentalUnsignedTypes;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String userId;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Member(String name, String userId, String password, Role role) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.role = role;
    }


}
