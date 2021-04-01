package com.graduation.model;

import lombok.*;

import javax.persistence.*;

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

    public boolean isNew() {
        return this.id == null;
    }
}
