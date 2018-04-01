package com.user_managment.ms.Services;

import com.user_managment.ms.Models.Role;
import com.user_managment.ms.Repository.UserRoleRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final UserRoleRepository roleRepository;

    @Autowired
    public RoleService(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() throws ServiceException {
        try {
            List<Role> roles = roleRepository.findAll();
            return roles;
        } catch (Exception e) {
            throw new ServiceException("Cannot fetch all roles.");
        }
    }

    public Role getRole(String id) throws ServiceException {
        try {
            Optional role = roleRepository.findById(Integer.parseInt(id));
            Role r = (Role) role.get();
            return r;
        } catch (Exception e) {
            throw new ServiceException("Cannot find role with id={" + id + "}");
        }
    }

    public Role createRole(Role role) throws ServiceException {
        try {
            Role r = roleRepository.save(role);
            return r;
        } catch (Exception e) {
            throw new ServiceException("Cannot create role");
        }
    }

    public String deleteRole(String id) throws ServiceException {
        try {
            roleRepository.deleteById(Integer.parseInt(id));
            return "Role deleted";
        } catch (Exception e) {
            throw new ServiceException("Cannot delete role with id={" + id + "}");
        }
    }
}
