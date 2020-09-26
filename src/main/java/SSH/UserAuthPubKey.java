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
    private String host = "host";
    private String user = "user";
    private int port = 22022;
    Session session;
    Channel channel;


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
        channel = session.openChannel("exec");
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



    }

    public void closeSSH () {
        if (this.session.isConnected()) {
            this.channel.disconnect();
            this.session.disconnect();
        }
    }


    public static class MyUserInfo implements UserInfo {

        String passphrase = "passphrase";

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