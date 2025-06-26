package edu.fiuba.algo3.modelo.Comando;

import edu.fiuba.algo3.modelo.Carta.Especial.Clima;

import java.util.ArrayList;
import java.util.List;

public class HistorialComandos {
    List<Comando> comandos;

    public HistorialComandos() {
        comandos = new ArrayList<>();
    }

    public void agregarComando(Comando comando){
        comandos.add(comando);
    }

    public void ejecutar () {
        for (Comando comando : comandos) {
            comando.ejecutar();
        }
    }

    public void quitarComando(Comando comando) {
        comandos.removeIf(comandoActual -> comandoActual.esIgualQue(comando));
    }

    public void quitarComandos() {
        comandos.clear();
    }
}
