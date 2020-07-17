package application.data.service;

import application.data.model.Student;
import application.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.save( student );
    }

    public Student findOne(int id){
        return studentRepository.findOne( id );
    }

    public Iterable<Student> findAll(){
        return studentRepository.findAll();
    }

    public boolean deleteStudent(int id){
        try {
            studentRepository.delete( id );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void updateStudent(Student student){
        studentRepository.save( student );
    }
    public List<Student> findStudentByName(String name){
        return studentRepository.findByNameContaining(name);
    }
}
