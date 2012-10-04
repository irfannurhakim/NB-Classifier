/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nb.model;

/**
 *
 * @author irfannurhakim
 */
public class DataModel {

    String[] atribut;
    boolean kelas;

    public DataModel(String[] atribut, boolean playTenis) {
        this.atribut = atribut;
        this.kelas = playTenis;
    }

    public DataModel() {
    }

    public String[] getAtribut() {
        return atribut;
    }

    public void setAtribut(String[] atribut) {
        this.atribut = atribut;
    }

    public boolean isKelasPos() {
        return kelas;
    }

    public void setKelas(boolean kelas) {
        this.kelas = kelas;
    }

    @Override
    public String toString() {
        String tampung = "";
        for (int i = 0; i < atribut.length; i++) {
            tampung += atribut[i] + "|";

        }
        tampung += kelas;
        return tampung;
    }
}
