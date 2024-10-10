package hello.core.Order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 스프링 빈으로 등록
public class OrderServiceImpl implements OrderService {

    // 순수하게 인터페이스에만 의존하고 있음 -> DIP
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    // @Autowired
    // 의존 관계 자동 주입
    // 생성자 호출 시점에 딱 한번만 호출 보장
    // "불변, 필수" 의존관계에서 사용
    // 생성자가 하나만 있다면 Autowired 생략 가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
