package com.graduation.util;

import com.graduation.model.Vote;
import com.graduation.to.VoteHistory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class VoteCalculatorTest {

    @Test
    void calculateVoteHistory() {

        // Creating List with Votes;
        List<Vote> lstVotes = new ArrayList<>();
        lstVotes.add(new Vote(100032, 100004, 100009, LocalDateTime.of(2021, 1, 1, 11, 0)));
        lstVotes.add(new Vote(100033, 100003, 100009, LocalDateTime.of(2021, 1, 1, 15, 0)));
        lstVotes.add(new Vote(100036, 100003, 100010, LocalDateTime.of(2021, 1, 1, 15, 0)));
        lstVotes.add(new Vote(100034, 100004, 100008, LocalDateTime.of(2021, 1, 2, 9, 0)));
        lstVotes.add(new Vote(100035, 100002, 100009, LocalDateTime.of(2021, 1, 3, 5, 0)));

        // lst of unique voteDate
        List<LocalDate> lstUniqueDates = new ArrayList<>();
        for (Vote vote : lstVotes) {
            LocalDate voteDate = vote.getVoteDateTime().toLocalDate();
            if (!lstUniqueDates.contains(voteDate)) {
                lstUniqueDates.add(voteDate);
            }
        }

        // List with VOTES_HISTORY
        List<VoteHistory> voteHistory = new ArrayList<>();
        for (LocalDate date : lstUniqueDates) {

            List<Integer> filteredByDate = lstVotes.stream()
                    .filter(v -> v.getVoteDateTime().toLocalDate().equals(date))
                    .map(Vote::getRestaurantId).collect(Collectors.toList());
            // count occurences
            Map<Integer, Long> counts = filteredByDate.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            Integer mostVotedRestaurantId = (Integer) counts.keySet().toArray()[0];
            voteHistory.add(new VoteHistory(mostVotedRestaurantId, date));
        }
    }
}