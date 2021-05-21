package com.graduation.util;

import com.graduation.to.VotingResultsTo;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Converters {

    public static List<VotingResultsTo> ObjectToVotingResultsTo(List<Object[]> queryResult) {
        List<VotingResultsTo> lst = new ArrayList<>();

        for (Object[] item : queryResult) {
            VotingResultsTo voteQuery = new VotingResultsTo();
            voteQuery.setRestaurantId((Integer) item[0]);
            voteQuery.setRestaurantName((String) item[1]);
            voteQuery.setVoteDate(LocalDate.parse(item[2].toString()));
            voteQuery.setCounts(((BigInteger) item[3]).intValue());

            lst.add(voteQuery);
        }
        return lst;
    }
}
