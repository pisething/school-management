package com.student.java.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.student.java.entity.enums.Gender;
import com.student.java.entity.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String phone;
    private String email;
    private String age;
    private String grade;
    private Gender gender;
    private String cardId;

    private Level level;

    private double totalScore;

    private double average;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "school_id"
    )
    private School school;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "subject_id"
    )
    private List<Subject> subject;

    public double getTotalScore() {
       double total = 0.0;
       for(Subject s : subject){
           total += (s.getSubjectScore());
       }
       return total;
    }

    public double getAverage() {
        double avg = 0.0;
        avg  = getTotalScore() / 5;
        return avg;
    }
}
