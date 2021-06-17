package study.springcoreprinciple.discount;

import org.springframework.stereotype.Component;
import study.springcoreprinciple.member.Grade;
import study.springcoreprinciple.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
