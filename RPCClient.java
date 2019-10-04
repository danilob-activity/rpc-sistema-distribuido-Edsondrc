import java.io.*;
import java.net.*;
class RPCClient
{
    RPCClient()
    {
        try
        {
            InetAddress ia = InetAddress.getByName("10.106.6.198");  
            DatagramSocket ds = new DatagramSocket();
            DatagramSocket ds1 = new DatagramSocket(1300);
            System.out.println("\nRPC Client\n");
            System.out.println("Insira a operação (ex: add, sub, mult, div, mod, pow) e os números que deseja calcular \n");
            while (true)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine(); //armazena a mensagem
                byte b[] = str.getBytes(); //Tamanho da mensagem que o cliente enviar
                //mensagem enviada para o servidor
                DatagramPacket dp =  new DatagramPacket(b,b.length,ia,1200);
                ds.send(dp);
                byte b1[]=new byte[100];
                dp = new DatagramPacket(b1,b1.length);
                //mensagem recebida pelo servidor
                ds1.receive(dp);
                String s = new String(dp.getData(),0,dp.getLength());
                System.out.println("\nResultado =" + s +"\n");

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main (String[] args)
    {
        new RPCClient();
    }
}

