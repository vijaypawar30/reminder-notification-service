package com.reminder.service.service;
import com.reminder.service.security.JwtFilter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.reminder.service.model.Reminder;
import com.reminder.service.repository.ReminderRepository;

@Service
public class SchedulerService {

    private final JwtFilter jwtFilter;
	
	@Autowired
	ReminderRepository reminderRepository;
	
	@Autowired
	EmailService emailService;

    SchedulerService(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }
	
	//Runs every minute automatically
	@Scheduled(fixedRate = 60000)
	public void checkAndSendReminders() {
		System.out.println("Checking reminders at: "+ LocalDateTime.now());
		
		//Find all pending reminders that are due
		List<Reminder> pendingReminders = reminderRepository
				.findByReminderTimeBeforeAndSentFalse(LocalDateTime.now());
		
		for(Reminder reminder : pendingReminders) {
			try {
				//Send email
				emailService.sendReminderEmail(
						reminder.getUser().getEmail(),
						reminder.getTitle(),
						reminder.getMessage()
						);
			
			//Mark as Sent
			reminder.setSent(true);
			reminderRepository.save(reminder);
			
			System.out.println("Reminder sent to: "+reminder.getUser().getEmail());
			
			}catch(Exception e) {
				System.out.println("Failed to send reminder: "+ e.getMessage());
			
			}
		}
	}
}
