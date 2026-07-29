package com.example.Portal_Do_Hackathon.models;

import com.example.Portal_Do_Hackathon.enums.TipoParticipante;

public class Designer extends Participante {

    private String ferramentaPrincipal;

    public Designer(String nome, int idade, String ferramentaPrincipal) {
        super(nome, idade);
        this.ferramentaPrincipal = ferramentaPrincipal;
    }

    public String getFerramentaPrincipal() {
        return ferramentaPrincipal;
    }

    public void setFerramentaPrincipal(String ferramentaPrincipal) {
        this.ferramentaPrincipal = ferramentaPrincipal;
    }

    @Override
    public TipoParticipante getTipo() {
        return TipoParticipante.Designer;
    }

    @Override
    public String getDetalheEspecifico() {
        return ferramentaPrincipal;
    }
}