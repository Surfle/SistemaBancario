package model.abstracteEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class AbstractEntity {


    private int id;

    private LocalDateTime criacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCriacao() {
        return criacao;
    }

    public void setCriacao(LocalDateTime criacao) {
        this.criacao = criacao;
    }
}
