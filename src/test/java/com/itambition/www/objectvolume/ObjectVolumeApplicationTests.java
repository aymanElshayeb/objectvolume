package com.itambition.www.objectvolume;

import com.itambition.www.objectvolume.model.PointCloud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ObjectVolumeApplicationTests {

	@Autowired
	public VolumeService volumeService;
	@Autowired
	public TransformService transformService;

	@Test
	void convertToRGBTest() {
		double[][] testImage = getTestImage();
		double[][] resultImage = transformService.convertToRGB(testImage);
		Assert.notNull(resultImage,"Empty result");
	}

	@Test
	void calculateVolumeRatioTest() {
		PointCloud pointCloud = new PointCloud(getTestImage());
		Assert.isTrue( volumeService.getVolume(pointCloud)== 30,"Wrong volume");
	}
	private double[][] getTestImage() {
		// should return test image Array
		double[][] image = new double[3][3];
		return image;
	}
}
