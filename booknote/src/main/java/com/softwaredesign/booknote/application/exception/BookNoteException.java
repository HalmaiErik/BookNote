package com.softwaredesign.booknote.application.exception;

public class BookNoteException extends RuntimeException {
    public BookNoteException(String msg, Exception e) {
        super(msg, e);
    }

    public BookNoteException(String msg) {
        super(msg);
    }
}
