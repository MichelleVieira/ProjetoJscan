package Model;

public class Funcionario {
    private static int idFuncionario;
    private static int idTipo;
    private static String nmEmail;
    private static String nmSenha;

    public static int getIdTipo() {
        return idTipo;
    }

    public static void setIdTipo(int idTipo) {
        Funcionario.idTipo = idTipo;
    }
    
    public static int getIdFuncionario() {
        return idFuncionario;
    }
    
    public static String getNmEmail() {
        return Funcionario.nmEmail;
    }

    public static String getNmSenha() {
        return Funcionario.nmSenha;
    }

    public static void setIdFuncionario(int idFuncionario) {
        Funcionario.idFuncionario = idFuncionario;
    }

    public static void setNmEmail(String nmEmail) {
        Funcionario.nmEmail = nmEmail;
    }

    public static void setNmSenha(String nmSenha) {
        Funcionario.nmSenha = nmSenha;
    }
}
