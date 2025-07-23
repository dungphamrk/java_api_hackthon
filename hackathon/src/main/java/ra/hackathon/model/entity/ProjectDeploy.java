package ra.hackathon.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDeploy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_deploy_id")
    private Integer id;

    @Column(name = "manager_name",nullable = false, length = 70)
    private String managerName;

    @Column(name = "total_employee_joined",nullable = false)
    private String totalEmployees;

    @Column(name = "image_manager")
    private String imageEmployees;

    @Column(name = "status",nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
}
