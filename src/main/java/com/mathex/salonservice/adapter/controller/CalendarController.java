package com.mathex.salonservice.adapter.controller;

import com.mathex.salonservice.usecase.GoogleCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    @Autowired
    private GoogleCalendarService googleCalendarService;

    @PostMapping("/google")
    public void addGoogleCalendarEvent(@RequestBody CalendarEventRequest request) {
        try {
            googleCalendarService.addEvent(
                request.getSummary(),
                request.getLocation(),
                request.getDescription(),
                request.getStartDateTime(),
                request.getEndDateTime()
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to add event to Google Calendar", e);
        }
    }

    // Classe para receber o corpo da requisição
    public static class CalendarEventRequest {
        private String summary;
        private String location;
        private String description;
        private String startDateTime;
        private String endDateTime;

        // Getters e setters

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getStartDateTime() {
            return startDateTime;
        }

        public void setStartDateTime(String startDateTime) {
            this.startDateTime = startDateTime;
        }

        public String getEndDateTime() {
            return endDateTime;
        }

        public void setEndDateTime(String endDateTime) {
            this.endDateTime = endDateTime;
        }
    }
}
