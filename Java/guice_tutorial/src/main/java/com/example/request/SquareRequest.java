package com.example.request;

import com.example.service.DrawShape;
import com.google.inject.Inject;

public class SquareRequest {

    public final DrawShape drawShape;

    @Inject
    public SquareRequest(DrawShape drawShape) {
        this.drawShape = drawShape;
    }

    public void makeRequest(){
        drawShape.draw();
    }
}
