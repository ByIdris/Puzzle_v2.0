

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
}
