package model;

public class X {
    private String nome;
    private int id;
    private static int nextId = 0;

    X(){
        this.nome = "";
        this.id = -1;
    }

    X(String nome){
        this.nome = nome;
        this.id = ++nextId;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
}
