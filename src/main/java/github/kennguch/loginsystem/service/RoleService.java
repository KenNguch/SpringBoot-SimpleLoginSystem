package github.kennguch.loginsystem.service;

import github.kennguch.loginsystem.model.RoleModel;

import java.util.List;

public interface RoleService {

    public RoleModel createRole(RoleModel roleModel);
    public List<RoleModel> getAllRoles();
    public RoleModel getRoleById(Long roleId);
    public void deleteRoleById(Long roleId);
}
