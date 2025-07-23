package ra.hackathon.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.hackathon.model.entity.Project;
import ra.hackathon.model.entity.Status;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDeployDTO {
    private Integer id;

    private String managerName;

    private String totalEmployees;

    private String imageEmployees;

    private Status status;

    private Project project;
}
