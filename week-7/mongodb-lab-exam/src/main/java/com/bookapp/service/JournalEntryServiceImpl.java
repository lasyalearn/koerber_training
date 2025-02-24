package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.repo.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryServiceImpl implements JournalEntryService
{

    @Autowired
    private JournalEntryRepo journalEntryRepo;
    @Override
    public JournalEntry addJournalEntry(JournalEntry journalEntry)
    {
        return journalEntryRepo.save(journalEntry);
    }

    @Override
    public List<JournalEntry> getAllJournalEntries()
    {
        return journalEntryRepo.findAll();
    }

    @Override
    public JournalEntry updateJournalEntry(JournalEntry journalEntry_new)
    {
        JournalEntry journalEntry = journalEntryRepo.findById(journalEntry_new.getId()).get();
        journalEntry.setTitle(journalEntry_new.getTitle());
        journalEntry.setContent(journalEntry_new.getContent());
        journalEntry.setDate(journalEntry_new.getDate());
        return journalEntryRepo.save(journalEntry);
    }

    @Override
    public void deleteJournalEntry(String id) {
        journalEntryRepo.deleteById(id);
    }
}
