package com.bookapp.service;

import com.bookapp.entities.AddJournalToUser;
import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;

import java.util.List;

public interface UserService
{
    public User addUser(User user);
    public List<User> getAllUser();
    public void addJournalEntryToUser(AddJournalToUser addJournalToUser);
    public User updateUser(User user);
    public void deleteUser(String id);
    public  List<JournalEntry> getJournalEntryService(String id);
    public User getUserByName(String name);
}
