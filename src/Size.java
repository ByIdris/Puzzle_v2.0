
import java.beans.PropertyChangeSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author byidris
 */
public class Size {

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        int oldRows = this.rows;
        this.rows = rows;
        propertyChangeSupport.firePropertyChange(PROP_ROWS, oldRows, rows);
    }

    /**
     * @return the cols
     */
    public int getCols() {
        return cols;
    }

    /**
     * @param cols the cols to set
     */
    public void setCols(int cols) {
        int oldCols = this.cols;
        this.cols = cols;
        propertyChangeSupport.firePropertyChange(PROP_COLS, oldCols, cols);
    }
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    public static final String PROP_ROWS = "rows";
    public static final String PROP_COLS = "cols";
    private int rows;
    private int cols;
}
