package com.graduation.service;

import com.graduation.AuthUser;
import com.graduation.model.Restaurant;
import com.graduation.model.Vote;
import com.graduation.repository.CrudRestaurantRepository;
import com.graduation.repository.CrudVoteRepository;
import com.graduation.to.VotingResultsTo;
import com.graduation.to.VoteTo;
import com.graduation.util.exception.CustomMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.graduation.util.MainUtil.findByIdThrowExceptionIfNotFound;

@Service
public class VoteService {

    private final CrudVoteRepository crudRepo;
    private final CrudRestaurantRepository restaurantRepository;

    public VoteService(CrudVoteRepository crudVoteRepository, CrudRestaurantRepository restaurantRepository) {
        this.crudRepo = crudVoteRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Vote> getByDate(LocalDate date) {
        return crudRepo.getByDate(date);
    }

    public Vote getById(Integer id) {
        return findByIdThrowExceptionIfNotFound(crudRepo, id);
    }

    public List<Vote> getByUserId(Integer userId) {
        return crudRepo.getByUserId(userId);
    }

    public Vote getByUserIdAndDate(Integer userID, LocalDate date) {
        return crudRepo.getByUserIdAndDate(userID, date);
    }

    @Transactional
    public ResponseEntity<URI> saveUpdate(VoteTo voteTo) {
        // check restaurantId presence in DB
        Integer restaurantId = voteTo.getRestaurantId();
        findByIdThrowExceptionIfNotFound(restaurantRepository, restaurantId);

        // https://stackoverflow.com/questions/31159075/how-to-find-out-the-currently-logged-in-user-in-spring-boot
        // https://stackoverflow.com/questions/22678891/how-to-get-user-id-from-customuser-on-spring-security
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = authUser.getUser().getId();

        LocalDate voteDate = voteTo.getVoteDateTime().toLocalDate();
        // get vote from DB by User and Date
        Vote voteFromDb = getByUserIdAndDate(userId, voteDate);

        if (voteFromDb == null) {
            Vote vote = save(voteTo, userId);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri();
            return new ResponseEntity<>(uri, HttpStatus.CREATED);
        } else {
            LocalTime time = voteTo.getVoteDateTime().toLocalTime();
            if (time.isAfter(LocalTime.of(11, 0, 0))) {
                throw new CustomMessageException("Vote can't be updated because User can't change his decision after 11 a.m.");
            } else {
                update(voteTo, userId, voteFromDb.getId());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }

    private Vote save(VoteTo voteTo, Integer userId) {
        Vote vote = new Vote(null, userId, voteTo.getRestaurantId(), voteTo.getVoteDateTime());
        vote.setRestaurant(new Restaurant(voteTo.getRestaurantId(), ""));
        return crudRepo.save(vote);
    }

    private void update(VoteTo voteTo, Integer userId, Integer voteId) {
        Vote vote = new Vote(voteId, userId, voteTo.getRestaurantId(), voteTo.getVoteDateTime());
        vote.setRestaurant(new Restaurant(voteTo.getRestaurantId(), ""));
    }
}
