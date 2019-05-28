package Model;

import java.util.List;

public class Computador {
    private static int IdComputador;
    private static int idFuncionario;
    private static String nmComputador;
    private static String nmSistemaOperacional;
    private static String nmModeloSistema;
    private static String nmProcessador;
    private static String vlArmazenamento;
    private static String vlMemoriaRam;

    public static int getIdFuncionario() {
        return idFuncionario;
    }

    public static void setIdFuncionario(int idFuncionario) {
        Computador.idFuncionario = idFuncionario;
    }

    public static int getIdComputador() {
        return IdComputador;
    }

    public static void setIdComputador(int IdComputador) {
        Computador.IdComputador = IdComputador;
    }

    public static String getNmComputador() {
        return nmComputador;
    }

    public static void setNmComputador(String nmComputador) {
        Computador.nmComputador = nmComputador;
    }

    public static String getNmSistemaOperacional() {
        return nmSistemaOperacional;
    }

    public static void setNmSistemaOperacional(String nmSistemaOperacional) {
        Computador.nmSistemaOperacional = nmSistemaOperacional;
    }

    public static String getNmModeloSistema() {
        return nmModeloSistema;
    }

    public static void setNmModeloSistema(String nmModeloSistema) {
        Computador.nmModeloSistema = nmModeloSistema;
    }

    public static String getNmProcessador() {
        return nmProcessador;
    }

    public static void setNmProcessador(String nmProcessador) {
        Computador.nmProcessador = nmProcessador;
    }

    public static String getVlArmazenamento() {
        return vlArmazenamento;
    }

    public static void setVlArmazenamento(String vlArmazenamento) {
        Computador.vlArmazenamento = vlArmazenamento;
    }

    public static String getVlMemoriaRam() {
        return vlMemoriaRam;
    }

    public static void setVlMemoriaRam(String vlMemoriaRam) {
        Computador.vlMemoriaRam = vlMemoriaRam;
    }

    
}