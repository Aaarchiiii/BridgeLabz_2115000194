package D_19_02_25.Other;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public String getCoverageType() {
        return coverageType;
    }
    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return Objects.equals(policyNumber, that.policyNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    @Override
    public String toString() {
        return String.format("Policy[Number=%s, Holder=%s, Expiry=%s, Type=%s, Premium=%.2f]",
                policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}
public class InsurancePolicySystem {
    private Set<InsurancePolicy> policyHashSet = new HashSet<>();
    private Set<InsurancePolicy> policyLinkedHashSet = new LinkedHashSet<>();
    private Set<InsurancePolicy> policyTreeSet = new TreeSet<>();
    public void addPolicy(InsurancePolicy policy) {
        policyHashSet.add(policy);
        policyLinkedHashSet.add(policy);
        policyTreeSet.add(policy);
    }
    public void displayAllPolicies() {
        System.out.println("All Policies (HashSet): " + policyHashSet);
        System.out.println("All Policies (LinkedHashSet): " + policyLinkedHashSet);
        System.out.println("All Policies (TreeSet - Sorted by Expiry): " + policyTreeSet);
    }
    public void displayExpiringPolicies() {
        LocalDate today = LocalDate.now();
        System.out.println("\nPolicies Expiring Soon (Within 30 Days):");
        for (InsurancePolicy policy : policyTreeSet) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                System.out.println(policy);
            }
        }
    }
    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (InsurancePolicy policy : policyHashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }
    public void findDuplicatePolicies() {
        Set<String> uniquePolicyNumbers = new HashSet<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();
        for (InsurancePolicy policy : policyHashSet) {
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        System.out.println("\nDuplicate Policies Found: " + duplicates);
    }
    public void comparePerformance() {
        System.out.println("\nPerformance Comparison:");
        List<InsurancePolicy> testPolicies = new ArrayList<>(policyHashSet);
        long start, end;
        start = System.nanoTime();
        policyHashSet.contains(testPolicies.get(0));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");
        start = System.nanoTime();
        policyLinkedHashSet.contains(testPolicies.get(0));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");
        start = System.nanoTime();
        policyTreeSet.contains(testPolicies.get(0));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");
    }
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        system.addPolicy(new InsurancePolicy("P123", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        system.addPolicy(new InsurancePolicy("P456", "Bob", LocalDate.now().plusDays(40), "Auto", 700.0));
        system.addPolicy(new InsurancePolicy("P789", "Charlie", LocalDate.now().plusDays(20), "Home", 600.0));
        system.addPolicy(new InsurancePolicy("P123", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        system.displayAllPolicies();
        system.displayExpiringPolicies();
        system.displayPoliciesByCoverage("Health");
        system.findDuplicatePolicies();
        system.comparePerformance();
    }
}
