package edu.fiuba.algo3.modelo.Seccion;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.Comando.Comando;
import edu.fiuba.algo3.modelo.Comando.ComandoPorCarta;

import java.util.ArrayList;
import java.util.List;

public class ContenedorSecciones extends Seccion {
    private List<Ubicable> secciones;

    public ContenedorSecciones () {
        secciones = new ArrayList<>();
    }

    public ContenedorSecciones(List<Ubicable> secciones) {
        this.secciones = secciones;
    }

    public void agregar(Ubicable seccion) {
        secciones.add(seccion);
    }

    @Override
    public int cantidadDeCartas () {
        int acumulador = 0;
        for (Seccion seccion : secciones) {
            acumulador += seccion.cantidadDeCartas();
        }
        return acumulador;
    }

    @Override
    public void reiniciarValoresCartas() {
        for (Seccion seccion : secciones) {
            seccion.reiniciarValoresCartas();
        }
    }

    @Override
    public int puntajeMaximoCartas() {
        int puntajeMaximo = -1;
        for (Seccion seccion : secciones) {
            int puntaje = seccion.puntajeMaximoCartas();
            if (puntaje >= puntajeMaximo)
                puntajeMaximo = puntaje;
        }
        return puntajeMaximo;
    }

    @Override
    public void quemarCartasDePuntaje(int puntaje) {
        for (Seccion seccion : secciones) {
            seccion.quemarCartasDePuntaje(puntaje);
        }
    }

    @Override
    public void agregarCartasA(ComandoPorCarta comando) {
        for (Seccion seccion : secciones) {
            seccion.agregarCartasA(comando);
        }
    }


    @Override
    public void agregarComando(Comando comando) {
        for (Seccion seccion : secciones) {
            seccion.agregarComando(comando);
        }
    }

    @Override
    public void actualizarValores() {
        for (Seccion seccion : secciones) {
            seccion.reiniciarValoresCartas();
            seccion.actualizarValores();
        }
    }

    @Override
    public void quitarComando(Comando comando) {
        for (Seccion seccion : secciones) {
            seccion.quitarComando(comando);
        }
    }



    public void quemarCartasMasFuertes() {
        int puntajeMaximo = -1;
        for (Seccion seccion : secciones) {
            int puntaje = seccion.puntajeMaximoCartas();
            if (puntaje >= puntajeMaximo)
                puntajeMaximo = puntaje;
        }
        for (Seccion seccion : secciones) {
            seccion.quemarCartasDePuntaje(puntajeMaximo);
        }
    }

    @Override
    public int calcularPuntaje () {
        int acumulador = 0;
        for (Seccion seccion : this.secciones) {
            acumulador += seccion.calcularPuntaje();
        }
        return acumulador;
    }

    @Override
    public void limpiarSeccion (List<UnidadGeneral> pilaDescarte) {
        for (Seccion seccion : this.secciones) {
            seccion.limpiarSeccion(pilaDescarte);
        }
    }


    public Ubicable obtenerSeccionAlAzar (SeccionAleatoria seccionAleatoria) {
        return seccionAleatoria.obtenerSeccionAleatoria(this.secciones);
    }
}
