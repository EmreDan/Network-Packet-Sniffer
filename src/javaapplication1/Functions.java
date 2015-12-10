/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.ARPPacket;
import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;



/**
 *
 * @author The Doctor
 */
public class Functions {
    
     public void fonksiyon(){
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        //for each network interface
        for (int i = 0; i < devices.length; i++) {
        //print out its name and description
            
        String p="\n" + i+": Device Name: "+devices[i].name + "\n Description :" + devices[i].description+" \n\n";
        System.out.print(p);
        GUI.Output.append(p);
        //print out its datalink name and description
        p="Datalink: \t "+devices[i].datalink_name + "\nDescription: \t" + devices[i].datalink_description+" \n\n";
       
        System.out.print(p);
        GUI.Output.append(p);
        //print out its MAC address
        System.out.print("MAC address: \t ");
        GUI.Output.append("MAC address: \t");
        for (byte b : devices[i].mac_address){
            p=Integer.toHexString(b&0xff) + " : ";
            System.out.print(p);
            GUI.Output.append(p);
        }
        System.out.println();
        GUI.Output.append("\n");
        //print out its IP address, subnet mask and broadcast address
        for (NetworkInterfaceAddress a : devices[i].addresses){
            p="Address: \t"+a.address + " \n"
                    + "Subnet: \t" + a.subnet + " \n"
                    + "Broadcast: \t"+ a.broadcast + " \n";
            System.out.println(p);
            GUI.Output.append(p);
            }
        }   
        
    }
     
     public void start_capturing( int a , int filter){  
         
         try {
             
            GUI.Output.setText(" ");
            NetworkInterface[] devices = JpcapCaptor.getDeviceList();
            
            JpcapCaptor x = JpcapCaptor.openDevice(devices[a], 65535, true, 2000); //2 saniye
            
            switch(filter){
                case 1:
                     x.setFilter("tcp", true);
                break;
                case 2:
                     x.setFilter("ip", true);
                break;
                case 3:
                     x.setFilter("port 80", true);
                break;
                case 4:
                     x.setFilter("udp", true);
                break;
         }
            
            x.loopPacket(5, new PacketrReceive());
             //x.processPacket(10, new PacketrReceive());
             x.close();
         } catch (IOException ex) {
             Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         
     }
    
     public void arp_deneme(){
         ARPPacket arps = new ARPPacket();
     }
     
     /** 
 * Main service loop. Listens for ARP Replies and caches the IP and MAC addresses.
 */
     
}
