package SSH;
import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Grzegorz Nowakowski
 */
public class GTEVDatabaseConnection extends JSch {

    private static final String sshKey = "P:\\ssh_private_key.ppk";
    private final Channel channel;
    private final Session sshSession;
    private static final int SSH_PORT = 22022;
    private static final String DATABASE = "DATABASE",
            DATABASE_USER = "DATABASE_USER",
            DATABASE_PASSWORD = "DATABASE_PASSWORD",
            DATABASE_HOST = "DATABASE_HOST",
            SSH_HOST = "SSH_HOST",
            SSH_USER = "SSH_USER",
            SSH_PASS = "SSH_PASS";

    public GTEVDatabaseConnection() throws SQLException {
        try {
            sshSession = createSshSession();
            this.channel = sshSession.openChannel("exec");
            ((ChannelExec) channel).setErrStream(System.err);
        } catch (JSchException ex) {
            Logger.getLogger(GTEVDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("username or password didn´t work");
        }
    }


    public void execQuery(String command) throws SQLException {
        try {
            //((ChannelExec) channel).setCommand("mysql -u " + DATABASE_USER + " -p " + DATABASE_PASSWORD + " -h " + DATABASE_HOST + " -e '" + query + "' " + DATABASE);
            //((ChannelExec) channel).setCommand("mv public_html/java/powerbook public_html/java/pb");
            ((ChannelExec) channel).setCommand("mysql --host="+DATABASE_HOST+" --port=3306 -u "+DATABASE_USER+" -p"+DATABASE_PASSWORD+" "+DATABASE+" < public_html/26158902_db_2309a.sql ");

            InputStream in = channel.getInputStream();
            channel.connect();
            //TODO check whether sqlcode is correct


            InputStreamReader inputReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            String line = null;

            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();
            inputReader.close();



        } catch (JSchException | IOException ex) {
            Logger.getLogger(GTEVDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private String readResult(InputStream in) throws IOException {
        if (in.available() <= 0) {
            return null;
        }

        StringBuilder output = new StringBuilder();
        int nextByte;
        do {
            nextByte = in.read();
            output.append((char) nextByte);
        } while (nextByte != -1);

        return output.toString();
    }

    private Session createSshSession() throws JSchException {
        UserInfo ui = new MyUserInfo();
        JSch jsch = new JSch();
        jsch.addIdentity(sshKey);

        Session session = jsch.getSession(SSH_USER, SSH_HOST, SSH_PORT);
        session.setUserInfo(ui);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        return session;
    }

    public void closeSSH () {
        if (this.sshSession.isConnected()) {
            this.channel.disconnect();
            this.sshSession.disconnect();
        }
    }

    public static class MyUserInfo implements UserInfo {

        String passphrase = SSH_PASS;

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


