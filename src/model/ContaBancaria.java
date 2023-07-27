package model;

import model.abstracteEntity.AbstractEntity;
import model.enuns.TipoConta;

import java.math.BigDecimal;

public class ContaBancaria extends AbstractEntity {

    private String nome;

    private float saldo;

    private TipoConta tipoConta;

    private String senha;

    private float investimento;

    public ContaBancaria(String nome, float saldo, TipoConta tipoConta, String senha) {
        this.nome = nome;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.senha = senha;
    }

    public ContaBancaria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getInvestimento() {
        return investimento;
    }

    public void setInvestimento(float investimento) {
        this.investimento = investimento;
    }
}
