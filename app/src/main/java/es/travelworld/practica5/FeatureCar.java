package es.travelworld.practica5;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;

public class FeatureCar {
    private final @ColorRes int colorRes;
    private final @DrawableRes int imgCar;

    public FeatureCar(int colorRes, int imgCar) {
        this.colorRes = colorRes;
        this.imgCar = imgCar;
    }

    public int getColorRes() {
        return colorRes;
    }

    public int getImgCar() {
        return imgCar;
    }
}
