package com.user_managment.ms.Controllers;

import com.user_managment.ms.Models.Role;
import com.user_managment.ms.Services.RoleService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity all() throws ServiceException {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity getUser(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(roleService.getRole(id));
    }

    @PostMapping(value = "/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteRole(@PathVariable("id") String id) {
        return ResponseEntity.ok(roleService.deleteRole(id));
    }
}
