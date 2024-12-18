package mju_umc.mju_umc.repository;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.enums.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.status = :status")
    List<Member> findByNameAndStatus(@Param("name") String name, @Param("status")MemberStatus status);


    //특정 이메일을 사용하는 유저가 DB에 있다면, 반환, 없으면 null 반환
    Optional<Member> findByEmail(String email);


}
