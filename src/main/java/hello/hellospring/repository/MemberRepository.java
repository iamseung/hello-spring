package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // 없으면 null 로 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
