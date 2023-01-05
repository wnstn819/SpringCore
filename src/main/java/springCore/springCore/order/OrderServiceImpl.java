package springCore.springCore.order;

import springCore.springCore.discount.DiscountPolicy;
import springCore.springCore.discount.FixDiscountPolicy;
import springCore.springCore.discount.RateDiscountPolicy;
import springCore.springCore.member.Member;
import springCore.springCore.member.MemberRepository;
import springCore.springCore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private DiscountPolicy discountPolicy;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


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
}
