package com.example.webdemo2205.beans;

import com.example.webdemo2205.data.Point;
import com.example.webdemo2205.logic.Tabulation;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
@Data
public class TabulationBean implements Serializable {
    private double start;
    private double finish;
    private double step;

    private List<Point> points;

    private Tabulation tabulation = new Tabulation();

    public String tabulate() {
        points = tabulation.tabulate(start, finish, step);
        return "tabulate";
    }
}
