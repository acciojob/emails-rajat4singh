package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity;
    private ArrayList<Mail> inbox;
    private ArrayList<Mail> trash;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        if (inbox.size() >= inboxCapacity) {
            // Move the oldest mail in the inbox to trash.
            Mail oldestMail = inbox.get(0);
            trash.add(oldestMail);
            inbox.remove(oldestMail);
        }
        inbox.add(new Mail(date, sender, message));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){
        if (inbox.isEmpty()) {
            return null;
        }
        Mail latestMail = inbox.get(inbox.size() - 1);
        return latestMail.getMessage();
    }

    public String findOldestMessage(){
        if (inbox.isEmpty()) {
            return null;
        }
        Mail oldestMail = inbox.get(0);
        return oldestMail.getMessage();

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        return inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }

    private static class Mail {
        private Date date;
        private String sender;
        private String message;

        public Mail(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }

        public Date getDate() {
            return date;
        }

        public String getSender() {
            return sender;
        }

        public String getMessage() {
            return message;
        }
    }
}
