package com.example.controller;


import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 *     Các bạn có thể tìm hiểu thêm  phần này tại blogs: https://levunguyen.com,
 *     blogs chuyên về lập trình và các kỹ năng mềm trong nghề lập trình
 */
@Controller
public class StudentController {

   @Autowired
   private StudentService studentService;

   @GetMapping("/")
//    @RequestMapping(value = "/", method = RequestMethod.GET)
   public String goStudentList(Model model) {
      List<Student> studentList = studentService.findAll();
      model.addAttribute("studentList", studentList);

      return "list";
   }

   @GetMapping("/create")
//    @RequestMapping(value = "/create", method = RequestMethod.GET)
   public String goCreate(Model model) {
      Student student = new Student();
      model.addAttribute("student", student);

      return "create";
   }

   @PostMapping("/create")
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
   public String create(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {

      this.studentService.save(student);
      redirectAttributes.addFlashAttribute("message", "Create info successfully!");

      return "redirect:/";
   }

   @GetMapping("/update")
//    @RequestMapping(value = "/update", method = RequestMethod.GET)
   public String goUpdate(@RequestParam Integer id, Model model) {
      Student student = this.studentService.findById(id);
      model.addAttribute("student", student);

      return "update";
   }

   @PutMapping("/update")
//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
   public String update(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {

      this.studentService.save(student);
      redirectAttributes.addFlashAttribute("message", "Update info successfully!");

      return "redirect:/";
   }

   @GetMapping("/delete")
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
   public String delete(@RequestParam Integer id, Model model) {
      Student student = this.studentService.findById(id);
      model.addAttribute("student", student);

      return "delete";
   }

   @DeleteMapping("/delete")
//    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
   public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
      this.studentService.deleteById(id);
      redirectAttributes.addFlashAttribute("message", "Delete info successfully!  ");

      return "redirect:/";
   }
}
