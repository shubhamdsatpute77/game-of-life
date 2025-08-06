package com.gameoflife.pojo;

import com.gameoflife.entity.Cell;

public class Colony {
    public static final int DEFAULT_COLONY_WIDTH_AROUND_HEAD_CELL = 1;
    public static final int DEFAULT_COLONY_DIMENSION = 2;
    public static final int HEAD_CELL_CONSIDERATION = 1;

    private Cell headCell;
    private int lengthY;
    private int lengthX;
    private int widthAroundHeadCell;
    private int dimension;

    public Colony(Cell headCell) {
        this.headCell = headCell;
        widthAroundHeadCell = DEFAULT_COLONY_WIDTH_AROUND_HEAD_CELL;
        dimension = DEFAULT_COLONY_DIMENSION;
    }

    public Cell getHeadCell() {
        return headCell;
    }

    public void setHeadCell(Cell headCell) {
        this.headCell = headCell;
    }

    public int getLengthY() {
        if (lengthY <= 0) {
            lengthY = widthAroundHeadCell * dimension + HEAD_CELL_CONSIDERATION;
        }
        return lengthY;
    }

    public void setLengthY(int lengthY) {
        this.lengthY = lengthY;
    }

    public int getLengthX() {
        if (lengthX <= 0) {
            lengthX = widthAroundHeadCell * dimension + HEAD_CELL_CONSIDERATION;
        }
        return lengthX;
    }

    public void setLengthX(int lengthX) {
        this.lengthX = lengthX;
    }

    public int getWidthAroundHeadCell() {
        return widthAroundHeadCell;
    }

    public void setWidthAroundHeadCell(int widthAroundHeadCell) {
        this.widthAroundHeadCell = widthAroundHeadCell;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
