package com.apps.memorizame.Entitys;

public class SubCategoriasEntity {

    //declaracion de variables
    private String nombreSub,imagenSub,calificacion;
    private int idCategoria,idEstado;

    public SubCategoriasEntity(String nombreSub, String imagenSub, int idCategoria, int idEstado, String calificacion){
        //setear datos
        this.nombreSub = nombreSub;
        this.imagenSub = imagenSub;
        this.idCategoria = idCategoria;
        this.idEstado = idEstado;
        this.calificacion = calificacion;
    }

    //getters de esta entidad
    public String getNombreSub(){ return nombreSub; }
    public String getImagenSub(){ return imagenSub; }
    public String getCalificacion(){ return calificacion; }
    public int getIdCategoria(){ return idCategoria; }
    public int getIdEstado(){ return idEstado; }

}