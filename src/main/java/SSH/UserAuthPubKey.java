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

public class UserAuthPubKey{

    private String sshKey = "P:\\ssh_private_key.ppk";
    private String host = "wn24.webd.pl";
    private String user = "kele01";
    private int port = 22022;
    Session session;


    public Session getSession() {
        return session;
    }

    public UserAuthPubKey() {
        try{
            JSch jsch=new JSch();

            jsch.addIdentity(sshKey);

            session=jsch.getSession(user, host, port);

            UserInfo ui = new MyUserInfo();

            session.setUserInfo(ui);

            session.connect();



        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void executeSSH (Session session, String command) throws JSchException, IOException {
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