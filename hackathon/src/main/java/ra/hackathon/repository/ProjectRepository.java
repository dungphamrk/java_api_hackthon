package ra.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.hackathon.model.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
