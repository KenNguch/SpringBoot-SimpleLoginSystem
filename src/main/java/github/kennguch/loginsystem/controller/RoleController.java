package github.kennguch.loginsystem.controller;

import github.kennguch.loginsystem.entity.RoleEntity;
import github.kennguch.loginsystem.model.RoleModel;
import github.kennguch.loginsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/roles")
    public RoleModel createRole(@RequestBody RoleModel roleModel){
        return roleService.createRole(roleModel);
    }

    @GetMapping("/roles")
    public List<RoleModel> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PreAuthorize("hasRole('ADMIN') or principal.userId == #userId")
    @DeleteMapping("/roles/{userId}/{roleId}")
    public void deleteRole(@PathVariable Long userId, @PathVariable Long roleId){
        roleService.deleteRoleById(roleId);
    }
}
