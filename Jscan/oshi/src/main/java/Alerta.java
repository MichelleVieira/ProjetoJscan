
import com.sun.jna.platform.win32.WinUser;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class Alerta {

    public PcLeitura pc;
    public SystemInfo sys;
    public HardwareAbstractionLayer har;

    public Alerta() {

        sys = new SystemInfo();
        har = sys.getHardware();
        pc = new PcLeitura();
    }

    public String alertaMemoria() {

        double limite;
        limite = har.getMemory().getTotal() * 0.75;
        return pc.getRamDisponivel() > limite ? " Alerta ! Memória cheia !" :
                "Tudo Ok !";

    }

    public String alertaProcessamento() {

        return pc.getProcessamento() > 90 ? "Alerta ! Não está tudo certo com "
                + "o processamento " : "Tudo ok !";
    }

    public String alertaDisco() {
        long limite = 10 * 1000002400;
        return pc.getMemoriaDisponível() < limite ? " Alerta! Super lotado! " :
                "Tudo ok!";
    }

}
