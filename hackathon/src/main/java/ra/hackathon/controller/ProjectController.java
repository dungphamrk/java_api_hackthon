package ra.hackathon.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.hackathon.model.dto.request.ProjectDTO;
import ra.hackathon.model.dto.response.ApiResponse;
import ra.hackathon.model.entity.Project;
import ra.hackathon.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    private ResponseEntity<ApiResponse<List<Project>>> getAllProjects(){
        return new ResponseEntity<>(new ApiResponse<>(true,"Lấy dữ liệu thành công", projectService.getProjects(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    private ResponseEntity<ApiResponse<Project>> getProjectsByProjectId(@PathVariable Integer projectId){
        return new ResponseEntity<>(new ApiResponse<>(true,"Lấy dữ liệu thành công", projectService.getProject(projectId), HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ApiResponse<Project>> postProject(@Valid @RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(new ApiResponse<>(true,"thêm mới project thành công ", projectService.insertProject(projectDTO), HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @DeleteMapping("/{projectId}")
    private ResponseEntity<ApiResponse<?>> deleteProject(@PathVariable Integer projectId){
        if (projectService.deleteProject(projectId)){
            return new ResponseEntity<>(new ApiResponse<>(true,"xóa project thành công ", true, HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new ApiResponse<>(false,"xóa project không thành công do project đã được triển khai ", false, HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{projectId}")
    private ResponseEntity<ApiResponse<Project>> putProject(@Valid @RequestBody ProjectDTO projectDTO, @PathVariable Integer projectId){
        return new ResponseEntity<>(new ApiResponse<>(true,"cập nhập project thành công ", projectService.updateProject(projectDTO,projectId), HttpStatus.OK),HttpStatus.OK);
    }
}
