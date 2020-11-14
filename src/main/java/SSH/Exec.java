package SSH;

import com.jcraft.jsch.*;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

import static Extra.Config.*;

/**
 * @author Grzegorz Nowakowski
 */
public class Exec{


    public static void SshCommand(String command){

        UserInfo ui = new SshConnection.MyUserInfo();

        try{
            JSch jsch=new JSch();
            jsch.addIdentity(SSH_KEY);

            Session session = jsch.getSession(SSH_USER, SSH_HOST, SSH_PORT);
            session.setUserInfo(ui);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();


            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);

            // X Forwarding
            // channel.setXForwarding(true);

            //channel.setInputStream(System.in);
            channel.setInputStream(null);

            //channel.setOutputStream(System.out);

            //FileOutputStream fos=new FileOutputStream("/tmp/stderr");
            //((ChannelExec)channel).setErrStream(fos);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream in=channel.getInputStream();

            channel.connect();

            byte[] tmp=new byte[1024];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0)break;
                    System.out.print(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    if(in.available()>0) continue;
                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();
            session.disconnect();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}