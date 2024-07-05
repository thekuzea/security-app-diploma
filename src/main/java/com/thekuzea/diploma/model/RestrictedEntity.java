package com.thekuzea.diploma.model;

import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class RestrictedEntity {

    protected boolean isInfiniteRestriction;

    protected LocalTime restrictionStartTime;

    protected LocalTime restrictionEndTime;

    public boolean isRestricted() {
        if (isInfiniteRestriction) {
            return true;
        }

        final LocalTime currentTime = LocalTime.now();
        return currentTime.isAfter(restrictionStartTime) && currentTime.isBefore(restrictionEndTime);
    }
}