package com.reminder.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reminder.service.dto.ReminderRequest;
import com.reminder.service.model.Reminder;
import com.reminder.service.service.ReminderService;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
	
	@Autowired
	ReminderService reminderService;
	
	//Post reminder
	@PostMapping
	public Reminder createReminder(@RequestBody ReminderRequest request) {
		return reminderService.createReminder(request);
	}
	
	//Get all reminders by user email
	@GetMapping("/user/{email}")
	public List<Reminder> getRemindersByUser(@PathVariable String email){
		return reminderService.getRemindersByUser(email);
	}
	
	//Get reminder by id
	@GetMapping("/{id}")
	public Reminder getReminderById(@PathVariable Long id) {
		return reminderService.getReminderById(id);
	}
	
	//Update reminder
	@PutMapping("/{id}")
	public Reminder updateReminder(@PathVariable Long id, @RequestBody ReminderRequest request) {
		return reminderService.updateReminder(id, request);
	}
	
	//Delete reminder
	@DeleteMapping("/{id}")
	public String deleteReminder(@PathVariable Long id) {
		reminderService.deleteReminder(id);
		return "Reminder deleted successfully !!";
	}
}
