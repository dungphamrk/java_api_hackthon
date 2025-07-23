package ra.hackathon.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer id;

    @Column(name = "project_name",unique = true,nullable = false)
    private String projectName;

    @Column(name = "technology_using" ,nullable = false)
    private String technology;

    @Column(name = "start_date",nullable = false)
    private String startDate;

    private Status status;
}

