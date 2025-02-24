package com.bookapp.service;

import com.bookapp.entities.JournalEntry;

import java.util.List;

public interface JournalEntryService
{
    public JournalEntry addJournalEntry(JournalEntry journalEntry);
    public List<JournalEntry> getAllJournalEntries();
    public JournalEntry updateJournalEntry(JournalEntry journalEntry);
    public void deleteJournalEntry(String id);
}
