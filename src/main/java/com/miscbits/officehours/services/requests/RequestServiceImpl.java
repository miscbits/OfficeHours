package com.miscbits.officehours.services.requests;

import com.miscbits.officehours.daos.RequestDao;
import com.miscbits.officehours.models.Request;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestServiceImpl {

    @Autowired
    private RequestDao requestDao;

    public Iterable<Request> findAll() {
        return requestDao.findAll();
    }
    public Request findOne(Long id) {
        return requestDao.findOneById(id);
    }
    public void save(Request request) {
        requestDao.save(request);
    }

}
