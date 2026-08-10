package com.reminder.service.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reminder.service.model.Reminder;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long>{
	//Find reminders by user email
	List<Reminder> findByUserEmail(String email);
	
	//Find pending reminders that are due
	List<Reminder> findByReminderTimeBeforeAndSentFalse(LocalDateTime dateTime);
}
