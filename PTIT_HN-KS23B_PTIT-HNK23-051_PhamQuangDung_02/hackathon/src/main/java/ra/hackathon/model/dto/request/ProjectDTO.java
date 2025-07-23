package ra.hackathon.model.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.hackathon.model.entity.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProjectDTO {

    private Integer id;

    @NotNull
    private String projectName;

    @NotNull
    private String technology;

    @NotNull
    private String startDate;

    private Status status = Status.Active ;
}

