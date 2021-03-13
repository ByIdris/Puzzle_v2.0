

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author byidris
 */
public class ButtonNode extends javax.swing.JButton {

    /**
     * Button Mapping Node
     */
    ButtonNode Up;
    ButtonNode Rigth;
    ButtonNode Left;
    ButtonNode Down;
    private int CountOfButtonsAround = 0;
    private ButtonNode[] Around = new ButtonNode[4];

    public int CountOfButtonsAround() {
        return CountOfButtonsAround;
    }

    public void FindCountOfButtonsAround() {
        if (!isTheUpNull()) {
            Around[CountOfButtonsAround++] = Up;
        }
        if (!isTheDownNull()) {
            Around[CountOfButtonsAround++] = Down;
        }
        if (!isTheRigthNull()) {
            Around[CountOfButtonsAround++] = Rigth;
        }
        if (!isTheLeftNull()) {
            Around[CountOfButtonsAround++] = Left;
        }
    }

    public ButtonNode[] ButtonsAround() {
        return Around;
    }

    public boolean isTheUpNull() {
        return Up == null;
    }

    public boolean isTheDownNull() {
        return Down == null;
    }

    public boolean isTheRigthNull() {
        return Rigth == null;
    }

    public boolean isTheLeftNull() {
        return Left == null;
    }

    /**
     * @return the CountOfButtonsAround
     */
    public int getCountOfButtonsAround() {
        return CountOfButtonsAround;
    }
}
