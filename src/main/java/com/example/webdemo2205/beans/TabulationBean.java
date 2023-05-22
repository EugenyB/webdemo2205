package com.example.webdemo2205.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Named
@SessionScoped
@Data
public class TabulationBean implements Serializable {
    private double start;
    private double finish;
    private double step;
}
