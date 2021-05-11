package com.graduation.util;

import com.graduation.to.VoteQueryByDateTo;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Converters {

    public static List<VoteQueryByDateTo> ObjectListToVoteQueryByDateTo(List<Object[]> queryResult) {
        List<VoteQueryByDateTo> lst = new ArrayList<>();

        for (Object[] item : queryResult) {
            VoteQueryByDateTo voteQuery = new VoteQueryByDateTo();
            voteQuery.setRestaurantId((Integer) item[0]);
            voteQuery.setRestaurantName((String) item[1]);
            voteQuery.setVoteDate(LocalDate.parse(item[2].toString()));
            voteQuery.setCounts(((BigInteger) item[3]).intValue());

            lst.add(voteQuery);
        }
        return lst;
    }
}
