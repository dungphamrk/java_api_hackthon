package ra.hackathon.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.hackathon.model.dto.request.ProjectDTO;
import ra.hackathon.model.entity.Project;
import ra.hackathon.model.entity.Status;
import ra.hackathon.repository.ProjectDeployRepository;
import ra.hackathon.repository.ProjectRepository;
import ra.hackathon.service.ProjectService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectDeployRepository projectDeployRepository;

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProject(Integer projectId) {
        return projectRepository.findById(projectId).orElseThrow(()-> new NoSuchElementException("Khong ton tai project co id: "+projectId));
    }

    @Override
    public Project insertProject(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(ProjectDTO projectDTO, Integer projectId) {
        projectRepository.findById(projectId).orElseThrow(()-> new NoSuchElementException("Khong ton tai project co id: "+projectId));
        Project project = modelMapper.map(projectDTO, Project.class);
        project.setId(projectId);
        return projectRepository.save(project);
    }

    @Override
    public Boolean deleteProject(Integer projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(()-> new NoSuchElementException("Khong ton tai project co id: "+projectId));
        if(projectDeployRepository.existsProjectDeployByProject(project)){
            return false;
        }
        project.setStatus(Status.Inactive);
        projectRepository.save(project);
        return true;
    }
}
