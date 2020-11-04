package com.smart.smartmirror.Service;

import com.smart.smartmirror.Model.Reminder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReminderService {
    List<Reminder> getAllReminders();
    void saveReminder(Reminder reminder);
    void deleteEmployeeById(long id);
    Reminder getReminderById(long id);
    Page<Reminder> findPagenated(int pageNo, int pageSize);
}
