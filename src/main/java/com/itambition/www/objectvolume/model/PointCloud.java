package com.itambition.www.objectvolume.model;

public class PointCloud {
    private final double[][] grayImage;

    public PointCloud(double[][] grayImage) {
        //Here is a dummy . here we should use librealsense to get points cloud for image object
        this.grayImage = grayImage;
    }

    public double getVolume() {
        // here we should use here. alpha algorithm to calculate the 3D volume
        return 0;
    }
}
