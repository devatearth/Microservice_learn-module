package code.buffer.departmentService.service;

import code.buffer.departmentService.entity.Department;
import code.buffer.departmentService.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("In saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentID) {
        log.info("In findDepartmentById of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentID);
    }
}
