package D_19_02_25.Other;

import java.util.*;
public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVoteMap = new TreeMap<>();
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }
    public void displayVotesInOrder() {
        System.out.println("Votes in order of casting:");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
    public void displaySortedResults() {
        System.out.println("Votes Sorted by Candidate Names:");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
    public void displayResultsByVoteCount() {
        System.out.println("Results Sorted by Vote Count:");
        voteMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes"));
    }
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.castVote("Archi");
        votingSystem.castVote("Mayank");
        votingSystem.castVote("Khushi");
        votingSystem.castVote("Krishna");
        votingSystem.castVote("Pooja");
        votingSystem.castVote("Baibhavi");
        votingSystem.castVote("Jayant");
        votingSystem.castVote("Aanchal");
        votingSystem.displayVotesInOrder();
        votingSystem.displaySortedResults();
        votingSystem.displayResultsByVoteCount();
    }
}
