package com.graduation.util;

import com.graduation.model.Vote;
import com.graduation.to.VoteHistory;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class VoteCalculator {

    public static List<VoteHistory> calculateVoteHistory(List<Vote> votes) {

        // lst of unique voteDate
        List<LocalDate> lstUniqueDates = new ArrayList<>();
        for (Vote vote : votes) {
            LocalDate voteDate = vote.getVoteDateTime().toLocalDate();
            if (!lstUniqueDates.contains(voteDate)) {
                lstUniqueDates.add(voteDate);
            }
        }
        // List with VOTES_HISTORY
        List<VoteHistory> voteHistory = new ArrayList<>();
        for (LocalDate date : lstUniqueDates) {

            List<Integer> filteredByDate = votes.stream()
                    .filter(v -> v.getVoteDateTime().toLocalDate().equals(date))
                    .map(Vote::getRestaurantId).collect(Collectors.toList());
            // count occurences
            Map<Integer, Long> counts = filteredByDate.stream()
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

            List<Map.Entry<Integer, Long>> sortedCounts = new ArrayList<>(counts.entrySet());
            sortedCounts.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            Integer mostVotedRestaurantId = sortedCounts.get(0).getKey();

            voteHistory.add(new VoteHistory(mostVotedRestaurantId, date));
        }
        return voteHistory;
    }
}
