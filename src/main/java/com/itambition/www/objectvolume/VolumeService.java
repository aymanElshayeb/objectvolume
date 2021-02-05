package com.itambition.www.objectvolume;

import com.itambition.www.objectvolume.model.PointCloud;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolumeService {
    public double getVolume(PointCloud pointsCloud) {
        // here we should use here. alpha algorithm to calculate the 3D volume
        return 30;
    }

    public List<Double> calculateVolumeRatio(List<Double> volumeImages) {
        if(volumeImages.size()==0 ){
            LinkedList<Double> resultList = new LinkedList<Double>();
            resultList.add(0d);
            return resultList;
        }
        double total = volumeImages.stream().reduce(0d, (subtotal, element) -> subtotal + element);
        return  volumeImages.stream().map(x-> (x/total)*100).collect(Collectors.toList());
    }
}
