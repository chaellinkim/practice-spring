package practice.practicespring.repository;

import java.util.List;
import java.util.Optional;
import practice.practicespring.domain.Member;

public interface MemberRepository {
    Member save(Member meber);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
