package com.smart.smartmirror.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@SuppressWarnings("All")
@Table(name = "reminder")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DMY")
    private String DMY;

    @Column(name = "mainHeading")
    private String mainHeading;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private String time;

}
