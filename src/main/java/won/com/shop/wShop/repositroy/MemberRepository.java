package won.com.shop.wShop.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import won.com.shop.wShop.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUserId(String userid);
}
