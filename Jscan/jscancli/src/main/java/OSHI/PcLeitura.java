package OSHI;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class PcLeitura {
    private SystemInfo systemInfo;
    private HardwareAbstractionLayer hardware;
    private OperatingSystem operatingSystem;

    public PcLeitura(){
        systemInfo = new SystemInfo();
        hardware = systemInfo.getHardware();
        operatingSystem = systemInfo.getOperatingSystem();
    }

    private String FormatarValor(long value){
        return FormatUtil.formatBytes(value);
    }

    private int getNumeroDeParticoesDeDisco(){
        return operatingSystem.getFileSystem().getFileStores().length;
    }

    public double getProcessamento(){
        return hardware.getProcessor().getSystemCpuLoad();
    }

    public long getRamDisponivel(){
        return hardware.getMemory().getAvailable();
    }

    public long getMemoriaDisponível() {
        int numeroDeParticoes = getNumeroDeParticoesDeDisco();
        long memoriaDisponivel = 0;
        for (int i = 0; i < numeroDeParticoes; i++) {
            memoriaDisponivel += operatingSystem.getFileSystem().getFileStores()[i].getUsableSpace();
        }
        return memoriaDisponivel;
    }

    public int getNumeroDeProcessosAtivos(){
        return operatingSystem.getProcessCount();
    }

    public long getUpTime(){
        return hardware.getProcessor().getSystemUptime();
    }

    public long getLeituraDeDisco(){
        int numeroDeLeituras= 0;
        for (int i = 0; i < getNumeroDeParticoesDeDisco(); i++) {
            numeroDeLeituras += hardware.getDiskStores()[0].getReads();
        }

        return numeroDeLeituras / (getUpTime() / 60);
    }

    //MÉTODOS DE LEITURA PARA O ALERTA --------------------------------------

    private PcInfo pcInfo = new PcInfo();

    public boolean alertaMemoria(){
        long memoriaDisponivel = getRamDisponivel();
        return memoriaDisponivel > (pcInfo.getRamNumber() * 0.9);
    }

    public boolean alertaCpu(){
        double porcetagemDeProcessamento = getProcessamento();
        return porcetagemDeProcessamento > 90;
    }

    public boolean alertaArmazemaneto(){
        long armazenamentoDisponivel = getMemoriaDisponível();
        return armazenamentoDisponivel > (pcInfo.getArmazenamentoNumber() * 0.9);
    }
}
