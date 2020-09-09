package SSH;/* -*-mode:java; c-basic-offset:2; indent-tabs-mode:nil -*- */
/**
 * This program will demonstrate the user authentification by public key.
 *   $ CLASSPATH=.:../build javac UserAuthPubKey.java
 *   $ CLASSPATH=.:../build java UserAuthPubKey
 * You will be asked username, hostname, privatekey(id_dsa) and passphrase. 
 * If everything works fine, you will get the shell prompt
 *
 */
import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserAuthPubKey{
    public static void main(String[] arg){

        try{
            JSch jsch=new JSch();



            jsch.addIdentity("P:\\ssh_private_key.ppk");

            String host= "wn24.webd.pl";
            String user = "kele01";
            int port = 22022;
            String command = "find public_html/java/testdelete/ -type f -name \"*.html\" -delete";




            Session session=jsch.getSession(user, host, port);

            // username and passphrase will be given via UserInfo interface.
            UserInfo ui = new MyUserInfo();


            session.setUserInfo(ui);


            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream input = channel.getInputStream();



            channel.connect();



            try{
                InputStreamReader inputReader = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(inputReader);
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                }
                bufferedReader.close();
                inputReader.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }


            channel.disconnect();
            session.disconnect();
            System.out.println("Cache has been wiped!");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public static class MyUserInfo implements UserInfo {

        String passphrase = "lugia0";

        public String getPassword() {
            return null;
        }

        public boolean promptYesNo(String str) {
            return true;
        }

        public String getPassphrase() {
            return passphrase;
        }

        public boolean promptPassphrase(String message) {
            return true;
        }

        public boolean promptPassword(String message) {
            return true;
        }

        public void showMessage(String s) {
        }
    }
}