package com.prototype.negocio;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroNota {

    private static final RegistroNota INSTANCE = new RegistroNota();
    private final Map<String, Nota> prototipos;

    private RegistroNota() {
        this.prototipos = new HashMap<>();

        Nota notaBase = new Nota("Nota Base", "Este é um modelo base de nota.");
        this.prototipos.put("base", notaBase);

        try {
            Nota notaCopia = notaBase.clone();
            notaCopia.setTitulo("Nota Copiada");
            notaCopia.setConteudo("Conteúdo da nota clonada.");
            this.prototipos.put("copia", notaCopia);
        } catch (RuntimeException ex) {
            Logger.getLogger(RegistroNota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized RegistroNota getInstance() {
        return INSTANCE;
    }

    public Nota criar(String tituloNota) {
        Nota prototipo = this.prototipos.get(tituloNota);
        if (prototipo == null) {
            throw new IllegalArgumentException("Protótipo não encontrado: " + tituloNota);
        }
        return prototipo.clone();
    }

    public void adicionaPrototipo(String tituloNota, Nota nota) {
        this.prototipos.put(tituloNota, nota);
    }

    public boolean removePrototipo(String tituloNota) {
        if (this.prototipos.containsKey(tituloNota)) {
            this.prototipos.remove(tituloNota);
            return true;
        }
        return false;
    }
}
