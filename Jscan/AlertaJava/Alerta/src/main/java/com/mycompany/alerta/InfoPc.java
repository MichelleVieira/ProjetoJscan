/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alerta;

import javax.swing.JOptionPane;

/**
 *
 * @author pssimeao
 */
public class InfoPc {
    public long  memDisponivel;
    public long memTotal;
    
    public long porcentagem;
    public long porcentagem2;
    
    public boolean isCheia(long _memTotal, long _memDisponivel){
        memDisponivel = _memDisponivel;
        memTotal = _memTotal;
        boolean resposta ;
        
        //conta para pegar o limite que quiser definir
        //alterar se achar necessário
        double limite = memTotal * 0.25;
        
        //System.out.println(limite);
        //System.out.println(memTotal - memDisponivel);
        
        if( _memDisponivel > limite){
            
           resposta = true;
        }
        else{
  
            resposta = false;
        }
        return resposta;
        
     
        
    }
    
    public String isCheiaInt(long _memTotal, long _memDisponivel){
        memDisponivel = _memDisponivel;
        memTotal = _memTotal;
        return "" + (100 - (memDisponivel * 100) / memTotal);
        
    }
}
