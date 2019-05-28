package com.mycompany.alerta;

import javax.swing.JOptionPane;
import oshi.SystemInfo;

public class Alerta {

    public static void main(String[] args) {

        SystemInfo sys = new SystemInfo();
        InfoPc pc = new InfoPc();

        Thread alertaMemoria = new Thread() {
            @Override
            public void run() {

                while (true) {

                    pc.isCheia(sys.getHardware().getMemory().getTotal(),
                            sys.getHardware().getMemory().getAvailable());

                    System.out.println(pc.isCheia(sys.getHardware().getMemory()
                            .getTotal(), sys.getHardware().getMemory()
                                    .getAvailable()));

                    if (pc.isCheia(sys.getHardware().getMemory()
                            .getTotal(), sys.getHardware().getMemory()
                                    .getAvailable())) {

                        String resposta = JOptionPane.showInputDialog("ALERTA ! "
                            + "Memoria cheia.\n" + " Digite OK para finalizar"
                            + " o alerta");
                        if (resposta.equalsIgnoreCase("ok")) {

                            break;
                        }

                    }
                }

            }

        };

        alertaMemoria.start();

    }
}
