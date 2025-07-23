package ra.hackathon.model.dto.request;


import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String managerName;

    @NotNull
    private String totalEmployees;

    private String imageEmployees;

    @NotNull

    private Status status = Status.Active ;

    private Project project;
}
