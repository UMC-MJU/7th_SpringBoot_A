package mju_umc.mju_umc.repository;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.enums.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.status = :status")
    List<Member> findByNameAndStatus(@Param("name") String name, @Param("status")MemberStatus status);
    

}
