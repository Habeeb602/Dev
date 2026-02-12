package com.example.service.impl;

import com.example.annotation.ColorValue;
import com.example.annotation.EdgeValue;
import com.example.service.DrawShape;
import com.google.inject.Inject;

import java.util.logging.Logger;

public class DrawSquare implements DrawShape {

    private final Logger log = Logger.getLogger("DrawSquare.class");

    private final int edge;
    private final String color;

    @Inject
    public DrawSquare(@ColorValue String color, @EdgeValue int edge){
        super();
        this.color = color;
        this.edge = edge;
    }

    @Override
    public void draw() {
        System.out.printf("Drawing %s Square with edge size of %d!!%n", color, edge);
    }
}
