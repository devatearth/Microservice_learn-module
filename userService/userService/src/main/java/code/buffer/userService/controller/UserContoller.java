package code.buffer.userService.controller;

import code.buffer.userService.ValueObject.Department;
import code.buffer.userService.ValueObject.ResponseTemplateVo;
import code.buffer.userService.entity.User;
import code.buffer.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserContoller {

    @Autowired
    private UserService userService;
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUser(@PathVariable("id") Long userId) {
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        User user = userService.findUserById(userId);
        Department department = restTemplate.
                getForObject("http://localhost:9001/departments/"+user.getDepartmentId(), Department.class);
        responseTemplateVo.setUser(user);
        responseTemplateVo.setDepartment(department);
        return responseTemplateVo;
    }

}
