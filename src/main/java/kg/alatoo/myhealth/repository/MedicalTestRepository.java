package kg.alatoo.myhealth.repository;

import kg.alatoo.myhealth.entity.MedicalTest;
import kg.alatoo.myhealth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicalTestRepository extends JpaRepository<MedicalTest, Long> {
    List<MedicalTest> findByUserOrderByCreatedAtDesc(User user);
    List<MedicalTest> findByUserAndTestTypeOrderByCreatedAt(User user, String testType);
}