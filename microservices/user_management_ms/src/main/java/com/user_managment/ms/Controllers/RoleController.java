package com.user_managment.ms.Controllers;

import com.user_managment.ms.Models.Role;
import com.user_managment.ms.Services.RoleService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/all")
    public ResponseEntity all() throws ServiceException {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getUser(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(roleService.getRole(id));
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteRole(@PathVariable("id") String id) {
        return ResponseEntity.ok(roleService.deleteRole(id));
    }

}
