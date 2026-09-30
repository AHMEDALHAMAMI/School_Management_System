package org.example.school_management_software.Controller;

import org.example.school_management_software.Api.ApiResponse;
import org.example.school_management_software.Model.Teacher;
import org.example.school_management_software.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;


    // Get all teachers
    @GetMapping("/get")
    public ResponseEntity<?> getTeachers() {

        return ResponseEntity.status(200).body(teacherService.getTeachers()
        );
    }


    // Get teacher by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable Integer id) {

        return ResponseEntity.status(200).body(teacherService.getTeacher(id)
        );
    }


    // Add teacher
    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@Valid @RequestBody Teacher teacher) {

        teacherService.addTeacher(teacher);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully")
        );
    }


    // Update teacher
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher) {

        teacherService.updateTeacher(id, teacher);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated successfully")
        );
    }


    // Delete teacher
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {

        teacherService.deleteTeacher(id);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted successfully")
        );
    }
}