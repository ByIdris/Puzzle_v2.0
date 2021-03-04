
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author byidris
 */
public interface IPuzzle {

    public ButtonNode next();

    public boolean hasNext();

    public void Shuffle();

    public void Reset();

    public void ResetLocation();
}
