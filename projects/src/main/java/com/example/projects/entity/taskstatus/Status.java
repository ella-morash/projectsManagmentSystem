package com.example.projects.entity.taskstatus;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Status {

    TODO(1,"todo"),
    IN_PROGRESS(2,"in progress"),
    DONE(3,"done");

    private final Integer statusId;
    private final String externalStatusId;

    public static Status findByStatusId(Integer statusId) {
        if (statusId == null) {
            return null;
        }

        return Arrays.stream(Status.values())
                .filter(status -> status.getStatusId().equals(statusId))
                .findFirst()
                .orElse(null);
    }

    @JsonCreator
    public static Status findByExternalStatusId(String externalStatusId) {
        if (externalStatusId == null) {
            return null;
        }

        return Arrays.stream(Status.values())
                .filter(status -> status.externalStatusId.equals(externalStatusId))
                .findFirst()
                .orElse(null);
    }
}
