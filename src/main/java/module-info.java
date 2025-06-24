module edu.fiuba.algo3 {
    requires javafx.controls;
    requires json.simple;
    requires com.google.gson;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;
    opens edu.fiuba.algo3.modelo;
    opens edu.fiuba.algo3.modelo.Carta;
    opens edu.fiuba.algo3.modelo.Seccion;
    opens edu.fiuba.algo3.modelo.Comando;
    opens edu.fiuba.algo3.modelo.LogicaGeneral;
    opens edu.fiuba.algo3.modelo.Carta.Especial;
    opens edu.fiuba.algo3.modelo.Carta.Modificador;
}