package kg.alatoo.myhealth.service;


import kg.alatoo.myhealth.entity.MedicalTest;
import kg.alatoo.myhealth.entity.User;
import java.util.List;

public interface MedicalTestService {
    MedicalTest create(MedicalTest test);
    MedicalTest update(MedicalTest test);
    void delete(Long id);
    MedicalTest findById(Long id);
    List<MedicalTest> findByUser(User user);
    List<MedicalTest> findByUserAndType(User user, String type);
}