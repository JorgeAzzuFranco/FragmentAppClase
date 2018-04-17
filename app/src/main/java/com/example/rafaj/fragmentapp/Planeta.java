package com.example.rafaj.fragmentapp;

/**
 * Created by Jorge Azzu Franco on 16/4/2018.
 */

public class Planeta {
     private String[] tituloPlaneta;
     private String[] lugarSistSolar;
     private String[] colorPlaneta;
     private int[] imgPlaneta = {R.drawable.sol, R.drawable.mercurio, R.drawable.venus,
                            R.drawable.tierra, R.drawable.marte, R.drawable.jupiter,
                            R.drawable.saturn, R.drawable.uranus, R.drawable.neptune};

    public String[] getTituloPlaneta() {
        return tituloPlaneta;
    }

    public void setTituloPlaneta(String[] tituloPlaneta) {
        this.tituloPlaneta = tituloPlaneta;
    }

    public String[] getLugarSistSolar() {
        return lugarSistSolar;
    }

    public void setLugarSistSolar(String[] lugarSistSolar) {
        this.lugarSistSolar = lugarSistSolar;
    }

    public String[] getColorPlaneta() {
        return colorPlaneta;
    }

    public int[] getImgPlaneta() {
        return imgPlaneta; 
    }

    public void setColorPlaneta(String[] colorPlaneta) {
        this.colorPlaneta = colorPlaneta;
    }
}
