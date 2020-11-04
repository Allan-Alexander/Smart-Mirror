package com.smart.smartmirror.Controller;

import com.smart.smartmirror.Model.Reminder;
import com.smart.smartmirror.Service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class Main {

    @Autowired
    private ReminderService reminderService;


    @GetMapping("/")
    public String viewHomePage(Model model){
        // model.addAttribute("listReminder",reminderService.getAllReminders());
        return findPagenated(1,model);
    }


    @GetMapping("/addPage")
    public String viewAddPage(Model model){
        Reminder reminder = new Reminder();
        model.addAttribute("reminder",reminder);
        return "addPage";
    }

    @GetMapping("/updatePage")
    public String viewUpdatePage(Model model){
        // model.addAttribute("listReminder",reminderService.getAllReminders());
        return findPagenated2(1,model);
    }

    @PostMapping("/saveReminder")
    public String saveReminder(@ModelAttribute("reminder") Reminder reminder){
        // save employee to DB
        reminderService.saveReminder(reminder);
        return "redirect:/";
    }

    @GetMapping("/deleteReminder/{id}")
    public String deleteReminderById(@PathVariable("id") long id, Model model){
        this.reminderService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateFormById(@PathVariable("id") long id, Model model){
        Reminder reminder = reminderService.getReminderById(id);
        model.addAttribute("reminder",reminder);
        return "update_reminder";
    }

    @GetMapping("/page/{pageNo}")
    public String findPagenated(@PathVariable("pageNo") int pageNo, Model model){
        int pageSize = 4;
        Page<Reminder> page = reminderService.findPagenated(pageNo,pageSize);
        List<Reminder> listReminder = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listReminder",listReminder);
        return "index";
    }

    @GetMapping("/page2/{pageNo}")
    public String findPagenated2(@PathVariable("pageNo") int pageNo, Model model){
        int pageSize = 4;
        Page<Reminder> page = reminderService.findPagenated(pageNo,pageSize);
        List<Reminder> listReminder = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listReminder",listReminder);
        return "updatePage";
    }





}
