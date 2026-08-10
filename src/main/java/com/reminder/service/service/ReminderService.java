package com.reminder.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reminder.service.dto.ReminderRequest;
import com.reminder.service.exception.ResourceNotFoundException;
import com.reminder.service.model.Reminder;
import com.reminder.service.model.User;
import com.reminder.service.repository.ReminderRepository;
import com.reminder.service.repository.UserRepository;

@Service
public class ReminderService {
	@Autowired
	ReminderRepository reminderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	//Create Reminder
	public Reminder createReminder(ReminderRequest request) {
		User user = userRepository.findByEmail(request.getUserEmail())
				.orElseThrow(()-> new ResourceNotFoundException(
						"User not found with email: "+ request.getUserEmail()));
		
		Reminder reminder = new Reminder();
		reminder.setTitle(request.getTitle());
		reminder.setMessage(request.getMessage());
		reminder.setReminderTime(request.getReminderTime());
		reminder.setSent(false);
		reminder.setUser(user);
		
		return reminderRepository.save(reminder);
	}
	
	//Get all reminders by user
	public List<Reminder> getRemindersByUser(String email){
		return reminderRepository.findByUserEmail(email);
	}
	
	//Get reminder by id
	public Reminder getReminderById(Long id) {
		return reminderRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Reminder not found with id: "+ id));
	}
	
	//Update reminder
	public Reminder updateReminder(Long id, ReminderRequest request) {
		Reminder reminder = reminderRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Reminder not found with id: "+ id));
		
		reminder.setTitle(request.getTitle());
		reminder.setMessage(request.getMessage());
		reminder.setReminderTime(request.getReminderTime());
		reminder.setSent(false);
		
		return reminderRepository.save(reminder);
	}
	
	//Delete reminder
	public void deleteReminder(Long id) {
		reminderRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Reminder not found with id: "+ id));
		reminderRepository.deleteById(id);
	}
	
}
