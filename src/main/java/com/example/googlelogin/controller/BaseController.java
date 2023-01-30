package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.IResponseFactory;

public abstract class BaseController {
    protected final IResponseFactory iResponseFactory;

    protected BaseController(IResponseFactory iResponseFactory) {
        this.iResponseFactory = iResponseFactory;
    }
}
