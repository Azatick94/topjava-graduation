package com.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Vote extends AbstractBaseEntity {

    @Column(name = "user_id")
    @Min(0)
    private Integer userId;

    @Column(name = "restaurant_id", insertable = false, updatable = false)
    @Min(0)
    private Integer restaurantId;

    @Column(name = "vote_date_time")
    private LocalDateTime voteDateTime;

    @Column(name = "vote_date")
    private LocalDate voteDate;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public Vote(Integer id, Integer userId, Integer restaurantId, LocalDateTime voteDateTime) {
        super(id);
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.voteDateTime = voteDateTime;
    }
}
