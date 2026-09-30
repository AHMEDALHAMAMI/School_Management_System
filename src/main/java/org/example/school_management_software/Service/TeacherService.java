package org.example.school_management_software.Service;

import org.example.school_management_software.Api.ApiException;
import org.example.school_management_software.Model.Teacher;
import org.example.school_management_software.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    // Get all teachers
    public List<Teacher> getTeachers() {

        return teacherRepository.findAll();
    }


    // Get teacher by ID
    public Teacher getTeacher(Integer id) {

        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        return teacher;
    }


    // Add teacher
    public void addTeacher(Teacher teacher) {

        teacherRepository.save(teacher);
    }


    // Update teacher
    public void updateTeacher(Integer id, Teacher teacher) {

        Teacher oldTeacher = teacherRepository.findTeacherById(id);

        if (oldTeacher == null) {
            throw new ApiException("Teacher not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());

        teacherRepository.save(oldTeacher);
    }


    // Delete teacher
    public void deleteTeacher(Integer id) {

        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        teacherRepository.delete(teacher);
    }
}