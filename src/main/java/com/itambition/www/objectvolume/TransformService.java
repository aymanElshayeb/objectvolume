package com.itambition.www.objectvolume;

import com.itambition.www.objectvolume.model.PointCloud;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class TransformService {

    private double[][] convertToRGB(double[][] grayImage) {
        //Here is a dummy . here we should use OpenCV to convert to RBG
        return grayImage;
    }

    public PointCloud convertToPointCloud(InputStream imageFile) {
        double[][] grayImage = convertToArray(imageFile);
        double[][] rgbImage = convertToRGB(grayImage);
        return new PointCloud(rgbImage);
    }

    private double[][] convertToArray(InputStream imageFile) {
       // Here is a dummy . we should use OpenCV to convert file to Array
        double image[][] = new double[3][3];
        return image;
    }
}
