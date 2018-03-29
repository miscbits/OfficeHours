package com.miscbits.officehours.services.requests;

import com.miscbits.officehours.models.Request;

public interface RequestService {
    Iterable<Request> findAll();
    Request findOne(Long id);
    void save(Request task);
}
