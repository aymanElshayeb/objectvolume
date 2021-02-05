package com.itambition.www.objectvolume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class VolumeCalculationController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public VolumeService volumeService;
    @Autowired
    public TransformService transformService;

    @PostMapping("/volume")
    public String volume(Model model, @RequestParam("image1") MultipartFile image1,
                         @RequestParam("image2") MultipartFile image2,
                         @RequestParam("image3") MultipartFile image3) throws IOException {

        List<Double> volumeImages = new LinkedList<Double>();
        addVolumeIfExsist(image1, volumeImages);
        addVolumeIfExsist(image2, volumeImages);
        addVolumeIfExsist(image3, volumeImages);
        model.addAttribute("result", volumeService.calculateVolumeRatio(volumeImages));
        return "result";
    }

    private void addVolumeIfExsist(MultipartFile image, List<Double> volumeImages) throws IOException {
        if(image != null && image.getInputStream() != null){
            volumeImages.add(volumeService.getVolume(transformService.convertToPointCloud(image.getInputStream())));
        }
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

}