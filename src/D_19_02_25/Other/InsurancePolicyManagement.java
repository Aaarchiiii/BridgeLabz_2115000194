package D_19_02_25.Other;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
class Insurance {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    public Insurance(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public String getPolicyholderName() {
        return policyholderName;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    @Override
    public String toString() {
        return String.format("Policy[Number=%s, Holder=%s, Expiry=%s, Type=%s, Premium=%.2f]",
                policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}
public class InsurancePolicyManagement {
    private Map<String, Insurance> policyMap = new HashMap<>();
    private Map<String, Insurance> policyLinkedMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, Insurance> policyTreeMap = new TreeMap<>();
    public void addPolicy(Insurance policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        policyLinkedMap.put(policy.getPolicyNumber(), policy);
        policyTreeMap.put(policy.getExpiryDate(), policy);
    }
    public Insurance getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }
    public void listExpiringPolicies() {
        LocalDate today = LocalDate.now();
        System.out.println("\nPolicies Expiring Within 30 Days:");
        for (Map.Entry<LocalDate, Insurance> entry : policyTreeMap.entrySet()) {
            if (ChronoUnit.DAYS.between(today, entry.getKey()) <= 30) {
                System.out.println(entry.getValue());
            }
        }
    }
    public void listPoliciesByHolder(String policyholderName) {
        System.out.println("\nPolicies for Policyholder: " + policyholderName);
        for (Insurance policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                System.out.println(policy);
            }
        }
    }
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        policyMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        policyLinkedMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        policyTreeMap.headMap(today, true).clear();
        System.out.println("\nExpired Policies Removed.");
    }
    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy(new Insurance("P123", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        system.addPolicy(new Insurance("P456", "Bob", LocalDate.now().plusDays(40), "Auto", 700.0));
        system.addPolicy(new Insurance("P789", "Charlie", LocalDate.now().plusDays(20), "Home", 600.0));
        system.addPolicy(new Insurance("P999", "Alice", LocalDate.now().minusDays(5), "Health", 400.0));
        System.out.println("\nRetrieve Policy P123: " + system.getPolicyByNumber("P123"));
        system.listExpiringPolicies();
        system.listPoliciesByHolder("Alice");
        system.removeExpiredPolicies();
    }
}
