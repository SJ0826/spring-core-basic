package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    // 생성자를 통해 외부에서 의존성 주입
    @Autowired // 스프링에서 자동으로 매개변수 타입과 맞는 클래스를 자동으로 주입해준다. 설정 정보가 없기 때문에 의존관계주입도 클래스내부에서 직접 한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
