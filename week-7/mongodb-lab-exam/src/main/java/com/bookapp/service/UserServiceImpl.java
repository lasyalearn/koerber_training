package com.bookapp.service;

import com.bookapp.entities.AddJournalToUser;
import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.repo.JournalEntryRepo;
import com.bookapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JournalEntryRepo journalEntryRepo;
    @Override
    public User addUser(User user)
    {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser()
    {
        return userRepo.findAll();
    }

    @Override
    public void addJournalEntryToUser(AddJournalToUser addJournalToUser)
    {
        JournalEntry journalEntry = journalEntryRepo.findById(addJournalToUser.getJournalEntryId()).get();
        User user = userRepo.findById(addJournalToUser.getUserId()).get();
        user.getJournalEntries().add(journalEntry);
        userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepo.findById(user.getId()).get();
        user1.setUserName(user.getUserName());
        user1.setEmail(user.getEmail());
        return userRepo.save(user1);
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public  List<JournalEntry> getJournalEntryService(String id)
    {
        User user = userRepo.findById(id).get();
        return user.getJournalEntries();
    }
    @Override
    public User getUserByName(String name)
    {
        //return userRepo.findByUserName(name);
        long start= System.currentTimeMillis();
        User user = userRepo.findByUserName(name);
        long end = System.currentTimeMillis();
        System.out.println("time taken: " + (end - start));
        return user;
    }
}
