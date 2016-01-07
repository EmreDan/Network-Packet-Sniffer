/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetworkPacketAnalyzer;

import java.nio.charset.Charset;
import jpcap.PacketReceiver;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

/**
 *
 * @author The Doctor
 */
public class PacketrReceive implements PacketReceiver{

    @Override
    public void receivePacket(Packet packet) {
        
        GUI.Output.append("\n Packet Bilgileri \n");
        GUI.Output.append(" Caplen : \t" + packet.caplen + " \n");
        GUI.Output.append(" Data : \t" + packet.data + " \n");
        GUI.Output.append(" Datalink : \t" + packet.datalink + " \n");
        GUI.Output.append(" Header : \t" + packet.header + " \n");
        GUI.Output.append(" Len : \t" + packet.len + " \n");
        GUI.Output.append(" Sec : \t" + packet.sec + " \n");
        GUI.Output.append(" Usec : \t" + packet.usec + " \n");
       
        GUI.Output.append(" Full Packet : \t" + packet + " \n");
        
        if(packet instanceof TCPPacket){
            TCPPacket tcp=(TCPPacket)packet;
            tcp_received(tcp);
        }
        else if(packet instanceof UDPPacket){
                UDPPacket udp = (UDPPacket)packet;
                udp_received(udp);
            }
        
    }
    
    public void udp_received(UDPPacket UdpPacket){
            GUI.Output2.append("\n TCP Packet Captured : \n");
            //GUI.Output2.append("Caplen: \t" + UdpPacket.caplen + " \n");
            //GUI.Output2.append("D_Flag: \t" + UdpPacket.d_flag + " \n");
            GUI.Output2.append("Data: \t" + UdpPacket.data + " \n");
            GUI.Output2.append("DataLink: \t" + UdpPacket.datalink + " \n");
            GUI.Output2.append("Dont Fragm: \t" + UdpPacket.dont_frag + " \n");          
            GUI.Output2.append("Source IP: \t" + UdpPacket.src_ip + " \n");   
            GUI.Output2.append("Source Port: \t" + UdpPacket.src_port + " \n");
            GUI.Output2.append("Destination IP: \t" + UdpPacket.dst_ip + " \n");
            GUI.Output2.append("Destination Port: \t" + UdpPacket.dst_port + " \n");  
            //GUI.Output2.append("Sec: \t" + UdpPacket.sec + " \n");
            GUI.Output2.append("Flow Label: \t" + UdpPacket.flow_label + " \n");
            //GUI.Output2.append("Header: \t" + UdpPacket.header + " \n");            
            GUI.Output2.append("Hop Limit: \t" + UdpPacket.hop_limit + " \n");               
            GUI.Output2.append("Ident: \t" + UdpPacket.ident + " \n");
    }
    
    public void tcp_received ( TCPPacket TcpPacket){
            GUI.Output1.append("\n TCP Packet Captured : \n");
            GUI.Output1.append("ACK: \t" + TcpPacket.ack + " \n");
            GUI.Output1.append("ACK_num: \t" + TcpPacket.ack_num + " \n");
            GUI.Output1.append("Sequence No.: \t" + TcpPacket.sequence + " \n");
            GUI.Output1.append("Synchronization: \t" + TcpPacket.syn + " \n");  
            GUI.Output1.append("More Frag: \t" + TcpPacket.more_frag + " \n");
            GUI.Output1.append("Dont Fragm: \t" + TcpPacket.dont_frag + " \n");    
            GUI.Output1.append("DataLink: \t" + TcpPacket.datalink + " \n");      
            GUI.Output1.append("Source IP: \t" + TcpPacket.src_ip + " \n");   
            GUI.Output1.append("Source Port: \t" + TcpPacket.src_port + " \n");
            GUI.Output1.append("Dest IP: \t" + TcpPacket.dst_ip + " \n");
            GUI.Output1.append("Dest Port: \t" + TcpPacket.dst_port + " \n");  
            GUI.Output1.append("Fin: \t" + TcpPacket.fin + " \n");
            GUI.Output1.append("Flow Label: \t" + TcpPacket.flow_label + " \n");
            //GUI.Output1.append("Header: \t" + TcpPacket.header + " \n");            
            GUI.Output1.append("Hop Limit: \t" + TcpPacket.hop_limit + " \n");  
            
    }
    
}
