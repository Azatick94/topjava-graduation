package com.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

@MappedSuperclass
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractBaseEntity {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    @JsonIgnore
    public boolean isNew() {
        return this.id == null;
    }

    public Integer id() {
        Assert.notNull(id, "Entity must have id");
        return id;
    }

}
