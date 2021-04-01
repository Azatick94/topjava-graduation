package com.graduation.util;

import com.graduation.model.Vote;
import com.graduation.model.VoteHistory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
            Map<Integer, Long> counts = filteredByDate.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            Integer mostVotedRestaurantId = (Integer) counts.keySet().toArray()[0];
            voteHistory.add(new VoteHistory(mostVotedRestaurantId, date));
        }
        return voteHistory;
    }
}
