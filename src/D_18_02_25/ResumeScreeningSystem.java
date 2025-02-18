package D_18_02_25;
import java.util.*;
abstract class JobRole{
    protected String candidateName;
    protected int experienceYears;
    public JobRole(String candidateName, int experienceYears){
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }
    public abstract boolean isEligible();
    public void displayCandidateDetails(){
        System.out.println("Candidate name: "+candidateName+" Experience Years: "+experienceYears+" Eligible: "+isEligible());
    }
}
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
    @Override
    public boolean isEligible() {
        return experienceYears >= 2;
    }
}
class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
    @Override
    public boolean isEligible() {
        return experienceYears >= 3;
    }
}
class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
    @Override
    public boolean isEligible() {
        return experienceYears >= 5;
    }
}
class Resume<T extends JobRole> {
    private T jobRole;
    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }
    public void processResume() {
        System.out.println("Processing Resume for " + jobRole.candidateName);
        jobRole.displayCandidateDetails();
    }
}
class ResumeProcessor {
    public static void screenResumes(List<? extends JobRole> jobRoles) {
        System.out.println("AI Screening Multiple Resumes:");
        for (JobRole jobRole : jobRoles) {
            jobRole.displayCandidateDetails();
        }
    }
}
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        SoftwareEngineer seCandidate = new SoftwareEngineer("Archi", 3);
        DataScientist dsCandidate = new DataScientist("Mayank", 2);
        ProductManager pmCandidate = new ProductManager("Khushi", 6);
        Resume<SoftwareEngineer> seResume = new Resume<>(seCandidate);
        Resume<DataScientist> dsResume = new Resume<>(dsCandidate);
        Resume<ProductManager> pmResume = new Resume<>(pmCandidate);
        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();
        List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(seCandidate);
        allResumes.add(dsCandidate);
        allResumes.add(pmCandidate);
        ResumeProcessor.screenResumes(allResumes);
    }
}
