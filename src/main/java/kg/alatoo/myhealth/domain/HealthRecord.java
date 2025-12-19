package kg.alatoo.myhealth.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "health_records")
public class HealthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private kg.iaau.healthcheck.domain.AppUser user;

    @Column(nullable = false)
    private LocalDate recordDate;

    // Simple demo fields (can be expanded)
    private Double hemoglobin;   // g/L
    private Double glucose;      // mmol/L
    private Integer systolic;    // mmHg
    private Integer diastolic;   // mmHg

    @Lob
    private String notes;

    public HealthRecord() {}

    public Long getId() { return id; }
    public kg.iaau.healthcheck.domain.AppUser getUser() { return user; }
    public void setUser(kg.iaau.healthcheck.domain.AppUser user) { this.user = user; }
    public LocalDate getRecordDate() { return recordDate; }
    public void setRecordDate(LocalDate recordDate) { this.recordDate = recordDate; }
    public Double getHemoglobin() { return hemoglobin; }
    public void setHemoglobin(Double hemoglobin) { this.hemoglobin = hemoglobin; }
    public Double getGlucose() { return glucose; }
    public void setGlucose(Double glucose) { this.glucose = glucose; }
    public Integer getSystolic() { return systolic; }
    public void setSystolic(Integer systolic) { this.systolic = systolic; }
    public Integer getDiastolic() { return diastolic; }
    public void setDiastolic(Integer diastolic) { this.diastolic = diastolic; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
