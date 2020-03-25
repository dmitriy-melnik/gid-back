package com.cio.gidservice.gidservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="logs")
@NoArgsConstructor
@AllArgsConstructor
public class Logs {

    @Id
    private Long id;
    private Long userID;
    private String password;
    private LocalDateTime time;
    private String ip;

}
