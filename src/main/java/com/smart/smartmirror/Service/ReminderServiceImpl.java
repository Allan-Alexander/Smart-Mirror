package com.smart.smartmirror.Service;

import com.smart.smartmirror.Model.Reminder;
import com.smart.smartmirror.Repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderServiceImpl implements ReminderService{

    @Autowired
    private ReminderRepository reminderRepository;

    @Override
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    @Override
    public void saveReminder(Reminder reminder) {
        this.reminderRepository.save(reminder);
    }

    @Override
    public void deleteEmployeeById(long id) {
        Optional<Reminder> optional = reminderRepository.findById(id);
        Reminder reminder = null;
        if(optional.isPresent()){
            reminderRepository.delete(optional.get());
        }else{
            throw new RuntimeException("Data does not exist");
        }
    }

    @Override
    public Reminder getReminderById(long id) {
        Optional<Reminder> optional = reminderRepository.findById(id);
        Reminder reminder = null;
        if(optional.isPresent()){
            reminder = optional.get();
        }else{
            throw new RuntimeException("Employee not for id :: "+id);
        }
        return reminder;
    }

    @Override
    public Page<Reminder> findPagenated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.reminderRepository.findAll(pageable);
    }

}
