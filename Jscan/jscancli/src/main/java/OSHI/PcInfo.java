package OSHI;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class PcInfo {
    private SystemInfo systemInfo;
    private HardwareAbstractionLayer hardware;
    private OperatingSystem operatingSystem;

    public PcInfo(){
        systemInfo = new SystemInfo();
        hardware = systemInfo.getHardware();
        operatingSystem = systemInfo.getOperatingSystem();
    }

    private String FormatarValor(long value){
        return FormatUtil.formatBytes(value);
    }

    private int getNumeroDeDiscos(){
        return operatingSystem.getFileSystem().getFileStores().length;
    }

    private OSFileStore[] getDiscos(){
        return operatingSystem.getFileSystem().getFileStores();
    }

    public String getSistemaOperacional(){
        return operatingSystem.toString();
    }

    public String getProcessador(){
        return hardware.getProcessor().getName();
    }

    public String getRam(){
        return FormatarValor(hardware.getMemory().getTotal());
    }

    public Long getRamNumber(){
        return hardware.getMemory().getTotal();
    }

    public Long getArmazenamentoNumber(){
        long tamanhoDosDiscos = 0;
        for(int i = 0; i < getNumeroDeDiscos(); i++){
            tamanhoDosDiscos += getDiscos()[i].getTotalSpace();
        }
        return tamanhoDosDiscos;
    }

    public String[] getNomeDosDiscos(){
        int numeroDeDiscos = getNumeroDeDiscos();
        String[] discos = new String[numeroDeDiscos];
        for(int i = 0; i < numeroDeDiscos; i++){
            discos[i] = getDiscos()[i].getName();
        }
        return discos;
    }

    public String[] getTamanhoDosDiscos(){
        int numeroDeDiscos = getNumeroDeDiscos();
        String[] discos = new String[numeroDeDiscos];
        for(int i = 0; i < numeroDeDiscos; i++){
            discos[i] = FormatarValor(getDiscos()[i].getTotalSpace());
        }
        return discos;
    }

    public String getArmazenamentoTotal(){
        return FormatarValor(getArmazenamentoNumber());
    }

    public String getModeloDoComputador(){
        return hardware.getComputerSystem().getModel();
    }

    public String getNomeDoComputador(){
        return operatingSystem.getNetworkParams().getHostName();
    }

    public String getNomePlacaMae(){
        return hardware.getComputerSystem().getManufacturer();
    }

    public String getModeloPlacaMae(){
        return hardware.getComputerSystem().getModel();
    }

    public String getEnderecoDeIpv4(){
        return hardware.getNetworkIFs()[0].getIPv4addr()[0];
    }

    public String getEnderecoDeIpv6(){
        return hardware.getNetworkIFs()[0].getIPv6addr()[0];
    }

    public String getDefaultGateway(){
        return operatingSystem.getNetworkParams().getIpv4DefaultGateway();
    }
}