package com.bookapp.controller;

import com.bookapp.entities.AddJournalToUser;
import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.service.JournalEntryService;
import com.bookapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserJournalEntryController
{
    @Autowired
    private UserService userService;
    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping("/users")
    public List<User> getAllUsers()
    {
       return userService.getAllUser();
    }

    @GetMapping("/journalEntries")
    public List<JournalEntry> getAllJournalEntries()
    {
        return journalEntryService.getAllJournalEntries();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
    @PostMapping("/addJournalEntry")
    public JournalEntry addJournalEntry(@RequestBody JournalEntry journalEntry)
    {
        return journalEntryService.addJournalEntry(journalEntry);
    }
    @PostMapping("/addJournalEntryToUser")
    public void addJournalEntryToUser(@RequestBody AddJournalToUser addJournalToUser)
    {
        userService.addJournalEntryToUser(addJournalToUser);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }
    @PutMapping("/updateJournalEntry")
    public JournalEntry updateJournalEntry(@RequestBody JournalEntry journalEntry)
    {
        return journalEntryService.updateJournalEntry(journalEntry);
    }


    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable String id)
    {
        userService.deleteUser(id);
    }
    @DeleteMapping("/deleteJournalEntry/{id}")
    public void deleteJournalEntry(@PathVariable String id)
    {
        journalEntryService.deleteJournalEntry(id);
    }

    @GetMapping("/getJournalEntriesList/{id}")
    public List<JournalEntry> getJournalEntriesList(@PathVariable String id)
    {
        return userService.getJournalEntryService(id);
    }
    @GetMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name)
    {
        return userService.getUserByName(name);
    }
}
