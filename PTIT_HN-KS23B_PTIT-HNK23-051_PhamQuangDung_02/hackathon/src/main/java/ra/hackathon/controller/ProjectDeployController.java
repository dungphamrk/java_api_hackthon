package ra.hackathon.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.hackathon.model.dto.request.ProjectDeployDTO;
import ra.hackathon.model.dto.response.ApiResponse;
import ra.hackathon.model.entity.ProjectDeploy;
import ra.hackathon.service.ProjectDeployService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projectDeploys")
public class ProjectDeployController {

    @Autowired
    private ProjectDeployService projectDeployService;

    @GetMapping
    private ResponseEntity<ApiResponse<List<ProjectDeploy>>> getAllProjectDeploys(){
        return new ResponseEntity<>(new ApiResponse<>(true,"Lấy dữ liệu thành công", projectDeployService.getProjectDeploys(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{projectDeployId}")
    private ResponseEntity<ApiResponse<ProjectDeploy>> getProjectsByProjectDeployId(@PathVariable Integer projectDeployId){
        return new ResponseEntity<>(new ApiResponse<>(true,"Lấy dữ liệu thành công", projectDeployService.getProjectDeploy(projectDeployId), HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ApiResponse<ProjectDeploy>> postProject(@Valid @RequestBody ProjectDeployDTO projectDeployDTO){
        return new ResponseEntity<>(new ApiResponse<>(true,"thêm mới project thành công ", projectDeployService.insertProjectDeploy(projectDeployDTO), HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @DeleteMapping("/{projectDeployId}")
    private ResponseEntity<ApiResponse<?>> deleteProject(@PathVariable Integer projectDeployId){
        return new ResponseEntity<>(new ApiResponse<>(true,"xóa project thành công ", projectDeployService.deleteProjectDeploy(projectDeployId), HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{projectDeployId}")
    private ResponseEntity<ApiResponse<ProjectDeploy>> putProject(@Valid @RequestBody ProjectDeployDTO projectDeployDTO, @PathVariable Integer projectDeployId){
        return new ResponseEntity<>(new ApiResponse<>(true,"cập nhập project thành công ", projectDeployService.updateProjectDeploy(projectDeployDTO,projectDeployId), HttpStatus.OK),HttpStatus.OK);
    }
}
