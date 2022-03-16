package hello.springmvc.servlet.domain;

import hello.springmvc.servlet.domain.member.Member;
import hello.springmvc.servlet.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    void save() {
        // given
        Member member = new Member("junggyu", 27);

        // when
        Member saveMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("junggyu", 27);
        Member member2 = new Member("mijin", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
