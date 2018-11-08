package com.zhan.websys.controller;

/**
 * @author zhanxp
 * @version 1.0 2018/11/1
 */

import com.google.code.kaptcha.GimpyEngine;

import java.awt.image.BufferedImage;

public class NoDistortion implements GimpyEngine {

    @Override
    public BufferedImage getDistortedImage(BufferedImage baseImage) {
        return baseImage;
    }
}
