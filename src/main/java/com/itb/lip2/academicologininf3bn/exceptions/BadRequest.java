package com.itb.lip2.academicologininf3bn.exceptions;

public class BadRequest extends RuntimeException {

    // extends : Herança, significa que a BadRequest é uma sub-classe ("filha") de RuntimeExcepiton
    //           ou seja, todos os recursos (atributos e métodos ) de RuntimeException pertencem também
    //           a BadRequest

    public BadRequest(String message) {

        super(message);
    }


}
