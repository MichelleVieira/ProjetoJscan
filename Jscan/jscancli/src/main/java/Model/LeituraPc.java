/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aluno
 */
public class LeituraPc {
   private static double processing;
   private static long actualStoragePercentage;
   private static long actualMemoryPercentage;
   private static int processNumber;
   private static long upTime;
   private static long avarageRead;

    public static long getAvarageRead() {
        return avarageRead;
    }

    public static void setAvarageRead(long avarageRead) {
        LeituraPc.avarageRead = avarageRead;
    }

    public static double getProcessing() {
        return processing;
    }

    public static void setProcessing(double processing) {
        LeituraPc.processing = processing;
    }

    public static long getActualStoragePercentage() {
        return actualStoragePercentage;
    }

    public static void setActualStoragePercentage(long actualStoragePercentage) {
        LeituraPc.actualStoragePercentage = actualStoragePercentage;
    }

    public static long getActualMemoryPercentage() {
        return actualMemoryPercentage;
    }

    public static void setActualMemoryPercentage(long actualMemoryPercentage) {
        LeituraPc.actualMemoryPercentage = actualMemoryPercentage;
    }

    public static int getProcessNumber() {
        return processNumber;
    }

    public static void setProcessNumber(int processNumber) {
        LeituraPc.processNumber = processNumber;
    }

    public static long getUpTime() {
        return upTime;
    }

    public static void setUpTime(long upTime) {
        LeituraPc.upTime = upTime;
    }
}
