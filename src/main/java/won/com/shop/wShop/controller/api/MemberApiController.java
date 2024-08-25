package won.com.shop.wShop.controller.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import won.com.shop.wShop.domain.Member;
import won.com.shop.wShop.dto.MemberFormDto;
import won.com.shop.wShop.repositroy.MemberRepository;
import won.com.shop.wShop.service.MemberService;
import won.com.shop.wShop.utils.ResponseMng;

import java.nio.charset.Charset;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<ResponseMng> save(@Valid @RequestBody MemberFormDto memDto){

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        ResponseMng response ;
        try{
            Member newMember = new Member(memDto.getName(),memDto.getUserId(),memDto.getPassword(),memDto.getRole());
            Member findMember = memberService.saveMember(newMember);
            response = new ResponseMng(HttpStatus.OK, "1", findMember);
            // 저장후 로그인 성공 상태값 반환
            return new ResponseEntity<>(response, header, HttpStatus.OK);
        }catch (Exception e){
           response = new ResponseMng(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return new ResponseEntity<>(response, header, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
