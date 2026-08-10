package com.reminder.service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReminderRequest {
	private String title;
	private String message;
	private LocalDateTime reminderTime;
	private String userEmail;
}
