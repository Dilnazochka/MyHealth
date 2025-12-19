package kg.alatoo.myhealth.service;


import kg.alatoo.myhealth.entity.MedicalTest;
import kg.alatoo.myhealth.entity.User;
import kg.alatoo.myhealth.repository.MedicalTestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicalTestServiceImpl implements MedicalTestService {
    private final MedicalTestRepository repo;
    public MedicalTestServiceImpl(MedicalTestRepository repo) { this.repo = repo; }

    @Override
    public MedicalTest create(MedicalTest test) {
        test.setCreatedDate(LocalDate.now());
        return repo.save(test);
    }
    @Override public MedicalTest update(MedicalTest test){ return repo.save(test); }
    @Override public void delete(Long id){ repo.deleteById(id); }
    @Override public MedicalTest findById(Long id){ return repo.findById(id).orElse(null); }
    @Override public List<MedicalTest> findByUser(User user){ return repo.findByUserOrderByCreatedAtDesc(user); }
    @Override public List<MedicalTest> findByUserAndType(User user, String type){ return repo.findByUserAndTestTypeOrderByCreatedAt(user, type); }
}
