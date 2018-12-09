package laskin.commands;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public abstract class YhdenParametrinKomento implements Komento {
    protected final TextField tuloskentta;
    protected final TextField syotekentta;
    protected final Button nollaa;
    protected final Button undo;
    protected final Sovelluslogiikka sovellus;
    protected int edellinen;
    protected int tulos;
    protected int syote;

    public YhdenParametrinKomento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        try {
            tulos = Integer.parseInt(tuloskentta.getText());
            edellinen = tulos;
            if (syotekentta.getText().isEmpty()) {
                syote = 0;
            } else {
                syote = Integer.parseInt(syotekentta.getText());
            }
        } catch (NumberFormatException ex) {
            return;
        }
        int uusiTulos = laske();
        tuloskentta.setText(Integer.toString(uusiTulos));
        syotekentta.clear();
    }

    @Override
    public void peru() {
        tuloskentta.setText(Integer.toString(edellinen));
    }

    protected abstract int laske();
}
