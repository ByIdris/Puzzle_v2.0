
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author byidris
 */
public class Design implements IPuzzle {

    private ButtonNode Start, Rows, Item, Temp;
    private Size size;
    private int index, Seconds, Counter, Rnd;
    private Timer _Timer;
    private ActionListener AL;
    private Random Rand;

    /**
     *
     * @param sz
     */
    public Design(Size sz) {
        size = sz;
        Rand = new Random();
        // Timer processing function
        _Timer = new Timer(1000, (ActionEvent e) -> {
            Seconds++;
        });
        Create();
        while (hasNext()) {
            Temp.FindCountOfButtonsAround();
        }
        ResetLocation();
    }

    private void addR() {
        Item.Rigth = new ButtonNode();
        Item.Rigth.addActionListener(AL);
        Item.Rigth.Left = Item;
        Item = Item.Rigth;
        if (!Rows.isTheUpNull()) {
            Item.Up = Item.Left.Up.Rigth;
            Item.Left.Up.Rigth.Down = Item;
        }
    }

    private void addD() {
        Rows.Down = new ButtonNode();
        Rows.Down.Up = Rows;
        Rows.Down.addActionListener(AL);
        Rows = Rows.Down;
        Item = Rows;
    }

    private void Create() {
        AL = (ActionEvent evt) -> {
            ButtonTextChanging(evt);
        };
        Rows = new ButtonNode();
        Rows.addActionListener(AL);
        Start = Rows;
        Item = Rows;
        for (int i = 1; i <= size.getRows(); i++) {
            for (int j = 1; j < size.getCols(); j++) {
                addR();
            }
            if (i != size.getRows()) {
                addD();
            }
        }
        Item.addActionListener((ActionEvent evt) -> {
            ButtonTextChanging(evt);
            Finish();
        });
        Reset();
        ResetLocation();
    }

    private void Finish() {
        ResetLocation();
        index = 1;
        while (hasNext()) {
            if (!Temp.getText().equals(String.valueOf(index++))) {
                break;
            }
        }
        if (index == (size.getRows() * size.getCols() + 1)) {
            TimerStateChange(false);
            JOptionPane.showMessageDialog(null, "Time: " + Seconds + " seconds"
                + "\nNumber of Moves: " + Counter, "Congratulations!", 1);
            Reset();
        }
    }

    private void TimerStateChange(boolean State) {
        if (!_Timer.isRunning() && State) {
            _Timer.start();
        } else if (_Timer.isRunning() && !State) {
            _Timer.stop();
        }
    }

    private void ButtonTextChanging(ActionEvent evt) {
        TimerStateChange(true);
        Item = (ButtonNode) evt.getSource();
        ButtonUpChanging(Item);
        ButtonDownChanging(Item);
        ButtonRigthChanging(Item);
        ButtonLeftChanging(Item);
    }

    private void ButtonTextChanging(ButtonNode Node, ButtonNode Node0) {
        if (Node0.getText().equals("")) {
            Counter++;
            Node0.setText(Node.getText());
            Node.setText("");
            Temp = Node;
        }
    }

    private void ButtonUpChanging(ButtonNode Node) {
        if (!Node.isTheUpNull()) {
            if (!Node.Up.getText().equals("")) {
                ButtonUpChanging(Node.Up);
            }
            ButtonTextChanging(Node, Node.Up);
        }
    }

    private void ButtonDownChanging(ButtonNode Node) {
        if (!Node.isTheDownNull()) {
            if (!Node.Down.getText().equals("")) {
                ButtonDownChanging(Node.Down);
            }
            ButtonTextChanging(Node, Node.Down);
        }
    }

    private void ButtonRigthChanging(ButtonNode Node) {
        if (!Node.isTheRigthNull()) {
            if (!Node.Rigth.getText().equals("")) {
                ButtonRigthChanging(Node.Rigth);
            }
            ButtonTextChanging(Node, Node.Rigth);
        }
    }

    private void ButtonLeftChanging(ButtonNode Node) {
        if (!Node.isTheLeftNull()) {
            if (!Node.Left.getText().equals("")) {
                ButtonLeftChanging(Node.Left);
            }
            ButtonTextChanging(Node, Node.Left);
        }
    }

    private void FindEmpty() {
        ResetLocation();
        while (hasNext()) {
            if (Temp.getText().equals("")) {
                break;
            }
        }
    }

    private void ResetVeriable() {
        Counter = 0;
        Seconds = 0;
    }

    @Override
    public ButtonNode next() {
        return Temp;
    }

    @Override
    public boolean hasNext() {
        if (Item != null) {
            Temp = Item;
            Item = Item.Rigth;
        } else if (Rows != null) {
            Rows = Rows.Down;
            Item = Rows;
            hasNext();
        }
        return Rows != null;
    }

    @Override
    public void Shuffle() {
        TimerStateChange(false);
        if (!Temp.getText().equals("")) {
            FindEmpty();
        }
        for (int i = 0; i < 200000; i++) {
            Rnd = Rand.nextInt(Temp.CountOfButtonsAround());
            ButtonTextChanging(Temp.ButtonsAround()[Rnd], Temp);
        }
        ResetVeriable();
    }

    @Override
    public void ResetLocation() {
        Rows = Start;
        Item = Rows;
    }

    @Override
    public void Reset() {
        TimerStateChange(false);
        ResetVeriable();
        index = 1;
        ResetLocation();
        while (hasNext()) {
            Temp.setText(String.valueOf(index++));
        }
        Temp.setText("");
    }
}
