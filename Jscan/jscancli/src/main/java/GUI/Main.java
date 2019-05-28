package GUI;

import Model.Computador;
import OSHI.PcInfo;
import OSHI.PcLeitura;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Thread alertaMemoria = new Thread() {
            @Override
            public void run() {

                //seta o computador na inicialização
                PcInfo pc = new PcInfo();

                Computador.setNmComputador(pc.getNomeDoComputador());
                Computador.setNmModeloSistema(pc.getModeloDoComputador());
                Computador.setNmProcessador(pc.getProcessador());
                Computador.setNmSistemaOperacional(pc.getSistemaOperacional());
                Computador.setVlArmazenamento(pc.getArmazenamentoTotal());
                Computador.setVlMemoriaRam(pc.getRam());

                PcLeitura leitura = new PcLeitura();
                Timer timer = new Timer();

                //timer de monitoramento
                timer.scheduleAtFixedRate(new TimerTask(){
                    @Override
                    public void run(){

                        if(leitura.alertaMemoria()){
                            JOptionPane.showMessageDialog(null, "MEMÓRIA PRINCIPAL ACIMA DO ACEITÁVEL!");
                            //Slack later
                        }

                        if(leitura.alertaArmazemaneto()){
                            JOptionPane.showMessageDialog(null, "MEMÓRIA DE ARMAZENAMENTO ACIMA DO ACEITÁVEL!");
                        }

                        if(leitura.alertaCpu()){
                            JOptionPane.showMessageDialog(null, "MEMÓRIA PRINCIPAL ACIMA DO ACEITÁVEL!");
                        }

                    }
                }, 200, 3000);
            }
        };

        alertaMemoria.run();

        new Login().setVisible(true);
    }
}
