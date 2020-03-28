package com.cio.gidservice.gidservice.entities.databaseEntities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
 *
 */
@Data
@Entity
@Table(name="logs")
@NoArgsConstructor
@AllArgsConstructor
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @PositiveOrZero
    private Long id;
    @PositiveOrZero
    private Long userID;
    @NotEmpty
    @Size(min = 6, max = 100, message = "password must be between 6 and 100 characters")
    private String password;
    @FutureOrPresent
    private LocalDateTime time;
    @NotEmpty
    private String ip;

    public Logs(Long userID, String password, LocalDateTime localDateTime, String ip) {
        this.userID = userID;
        this.password = password;
        this.time = localDateTime;
        this.ip = ip;
    }

}
