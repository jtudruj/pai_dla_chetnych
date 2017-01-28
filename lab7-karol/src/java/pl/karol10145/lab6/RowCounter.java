/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.karol10145.lab6;

import java.io.Serializable;

/**
 *
 * @author Karol Podolski
 */
public class RowCounter implements Serializable {

    private transient int row = 0;

    public int getRow() {
        return ++row;
    }

}
