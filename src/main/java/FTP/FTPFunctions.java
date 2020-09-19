package FTP;

import java.io.*;


import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.io.CopyStreamAdapter;


public class FTPFunctions {

    // Creating FTP Client instance
    FTPClient ftp = null;
    CopyStreamAdapter streamListener;
    String anim= "=====================";

    // Constructor to connect to the FTP Server
    public FTPFunctions(String host, int port, String username, String password) throws Exception {

        ftp = new FTPClient();
        //ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(host,port);
        //System.out.println("FTP URL is:"+ftp.getDefaultPort());
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(username, password);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();





    }



    // Method to upload the File on the FTP Server
    public void uploadFTPFile(String localFileFullName, String fileName, String hostDir) throws Exception {

        BufferedInputStream buffIn = null;
        final File file = new File(localFileFullName);
        buffIn = new BufferedInputStream(new FileInputStream(file), 8192);


        streamListener = new CopyStreamAdapter() {

            @Override
            public void bytesTransferred(long totalBytesTransferred,
                                         int bytesTransferred, long streamSize) {
                // this method will be called everytime some
                // bytes are transferred
                // System.out.println("Stream size" + file.length());
                // System.out.println("byte transfeedd "
                // + totalBytesTransferred);



                int percent = (int) (totalBytesTransferred * 100 / file.length());
                //System.out.println(percent + "%");

                System.out.print("\r Uploading "
                        + percent
                        + "% ["
                        + anim.substring(0, (percent / 5) % anim.length())
                        + "> ");

                if (totalBytesTransferred == file.length()) {
                    System.out.println("\n100% transfered");

                    removeCopyStreamListener(streamListener);

                }

            }

        };
        this.ftp.setCopyStreamListener(streamListener);
        buffIn.close();

        try {
            InputStream input = new FileInputStream(new File(localFileFullName));

            this.ftp.storeFile(hostDir + fileName, input);
        } catch (Exception e){

        }
    }

    // Download the FTP File from the FTP Server
    public void downloadFTPFile(String source, String destination) {
        try (FileOutputStream fos = new FileOutputStream(destination)) {
            this.ftp.retrieveFile(source, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    // Disconnect the connection to FTP
    public void disconnect(){
        if (this.ftp.isConnected()) {
            try {
                this.ftp.logout();
                this.ftp.disconnect();
            } catch (IOException f) {
                // do nothing as file is already saved to server
            }
        }
    }
}
