package ra.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.hackathon.model.entity.Project;
import ra.hackathon.model.entity.ProjectDeploy;

import java.util.List;

@Repository
public interface ProjectDeployRepository extends JpaRepository<ProjectDeploy,Integer> {
    boolean existsProjectDeployByProject(Project project);
    List<ProjectDeploy> sortProjectDeployByManagerName();
}
