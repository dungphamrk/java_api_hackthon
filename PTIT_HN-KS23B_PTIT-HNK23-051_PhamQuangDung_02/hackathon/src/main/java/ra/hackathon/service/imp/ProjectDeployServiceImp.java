package ra.hackathon.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.hackathon.model.dto.request.ProjectDeployDTO;
import ra.hackathon.model.entity.Project;
import ra.hackathon.model.entity.ProjectDeploy;
import ra.hackathon.model.entity.Status;
import ra.hackathon.repository.ProjectDeployRepository;
import ra.hackathon.service.ProjectDeployService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectDeployServiceImp implements ProjectDeployService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProjectDeployRepository projectDeployRepository;

    @Override
    public List<ProjectDeploy> getProjectDeploys() {
        return projectDeployRepository.findAll();
    }

    @Override
    public ProjectDeploy getProjectDeploy(Integer projectDeployId) {
        return projectDeployRepository.findById(projectDeployId).orElseThrow(()-> new NoSuchElementException("Khong ton tai triển khai dự án co id: "+projectDeployId));

    }

    @Override
    public ProjectDeploy insertProjectDeploy(ProjectDeployDTO projectDeployDTO) {
        ProjectDeploy project = modelMapper.map(projectDeployDTO, ProjectDeploy.class);
        return projectDeployRepository.save(project);
    }

    @Override
    public ProjectDeploy updateProjectDeploy(ProjectDeployDTO projectDeployDTO, Integer projectDeployId) {
        projectDeployRepository.findById(projectDeployId).orElseThrow(()-> new NoSuchElementException("Khong ton tai dự án triển khai co id: "+projectDeployId));
        ProjectDeploy project = modelMapper.map(projectDeployDTO, ProjectDeploy.class);
        project.setId(projectDeployId);
        return projectDeployRepository.save(project);
    }

    @Override
    public Boolean deleteProjectDeploy(Integer projectDeployId) {
        ProjectDeploy projectDeploy = projectDeployRepository.findById(projectDeployId).orElseThrow(()-> new NoSuchElementException("Khong ton tai  dự án triển khai co id: "+projectDeployId));
        projectDeploy.setStatus(Status.Inactive);
        projectDeployRepository.save(projectDeploy);
        return true;
    }


}
