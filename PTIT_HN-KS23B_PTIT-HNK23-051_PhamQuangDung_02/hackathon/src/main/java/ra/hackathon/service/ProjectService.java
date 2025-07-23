package ra.hackathon.service;


import ra.hackathon.model.dto.request.ProjectDTO;
import ra.hackathon.model.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getProjects();
    Project getProject(Integer projectId);
    Project insertProject(ProjectDTO projectDTO);
    Project updateProject(ProjectDTO projectDTO, Integer projectId);
    Boolean deleteProject(Integer projectId);
}
