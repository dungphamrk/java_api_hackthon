package ra.hackathon.service;

import ra.hackathon.model.dto.request.ProjectDeployDTO;
import ra.hackathon.model.entity.ProjectDeploy;

import java.util.List;

public interface ProjectDeployService {
    List<ProjectDeploy> getProjectDeploys();
    ProjectDeploy getProjectDeploy(Integer projectDeployId);
    ProjectDeploy insertProjectDeploy(ProjectDeployDTO projectDeployDTO);
    ProjectDeploy updateProjectDeploy(ProjectDeployDTO projectDeployDTO, Integer projectDeployId);
    Boolean deleteProjectDeploy(Integer projectDeployId);
}
