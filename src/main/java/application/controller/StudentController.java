package application.controller;

import application.data.model.Student;
import application.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String home(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "home";
    }

    @GetMapping("/student/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/student/save")
    public String save(@Valid Student student, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/student/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findOne(id));
        return "form";
    }

    @GetMapping("/student/{id}/delete")
    public String deleteStudent(@PathVariable int id, RedirectAttributes redirect) {
        studentService.deleteStudent(id);
        redirect.addFlashAttribute("success", "Delete Student Successfully");
        return "redirect:/student";
    }

    @GetMapping("/student/search")
    public String search(@RequestParam("name") String name, Model model) {
        if (name.equalsIgnoreCase("")) {
            return "redirect:/student";
        }
        model.addAttribute("students", studentService.findStudentByName(name));
        return "home";
    }
}
