/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nb.model;

/**
 *
 * @author irfannurhakim
 */
public class Atribut {

    String name;
    boolean isUsed;
    String[] posibility;

    public Atribut() {
    }

    public Atribut(String name, boolean isUsed, String[] posibility) {
        this.name = name;
        this.isUsed = isUsed;
        this.posibility = posibility;
    }

    public String[] getPosibility() {
        return posibility;
    }

    public void setPosibility(String[] posibility) {
        this.posibility = posibility;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
