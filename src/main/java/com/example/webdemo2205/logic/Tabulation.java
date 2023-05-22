package com.example.webdemo2205.logic;

import com.example.webdemo2205.data.Point;

import java.util.List;
import java.util.stream.IntStream;

public class Tabulation {
    public List<Point> tabulate(double start, double finish, double step) {
        int n = (int) Math.round((finish - start) / step + 1);
        return IntStream.range(0, n).mapToDouble(i -> start + i * step).mapToObj(x -> new Point(x, f(x))).toList();
    }

    public double f(double x) {
        return Math.cos(x) + Math.sin(x);
    }
}
