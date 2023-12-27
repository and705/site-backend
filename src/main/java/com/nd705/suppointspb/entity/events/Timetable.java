package com.nd705.suppointspb.entity.events;

import com.nd705.suppointspb.entity.blog.Category;
import com.nd705.suppointspb.entity.blog.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "timetable"
)
public class Timetable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private LocalDate date;
    private LocalTime time;
    private int numberInGroup;
    private int availableInGroup;

    @OneToOne
    private Event event;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "timetable_instructor"
            , joinColumns = @JoinColumn(name = "timetable_id")
            , inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<Instructor> instructor;

    private boolean isActive;




}
