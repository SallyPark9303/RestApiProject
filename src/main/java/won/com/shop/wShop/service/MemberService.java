package won.com.shop.wShop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import won.com.shop.wShop.domain.Member;
import won.com.shop.wShop.repositroy.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        try{
            validateDuplicateMember(member);
            return memberRepository.save(member);
        }catch (Exception e){
            throw new IllegalStateException(e.getMessage());
        }

    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByUserId(member.getUserId());
        if(findMember !=null){
            throw new IllegalStateException("아이디가 중복입니다.");
        }
    }

}
