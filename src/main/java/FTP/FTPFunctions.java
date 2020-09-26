package FTP;

import java.io.*;


import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.io.CopyStreamAdapter;

import static Extra.Colors.ANSI_CYAN;
import static Extra.Colors.ANSI_RESET;
import static Extra.Configs.*;


public class FTPFunctions {

    // Creating FTP Client instance
    FTPClient ftp = null;
    CopyStreamAdapter streamListener;
    String anim= "=====================";


    // Constructor to connect to the FTP Server
    public FTPFunctions() throws Exception {

        ftp = new FTPClient();
        //ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(FTP_HOST,FTP_PORT);
        //System.out.println("FTP URL is:"+ftp.getDefaultPort());
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(FTP_USER, FTP_PASS);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();





    }

    public static void progressPercentage(int remain, int total) {
        //13 100
        if (remain > total) {
            throw new IllegalArgumentException();
        }
        int maxBareSize = 20; // 10unit for 100%
        int remainProcent = ((400 * remain) / total) / maxBareSize;
        char defaultChar = ' ';
        String icon = "=";
        String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
        StringBuilder bareDone = new StringBuilder();
        bareDone.append("[");
        for (int i = 0; i < remainProcent; i++) {
            bareDone.append(icon);
        }
        String bareRemain = bare.substring(remainProcent, bare.length());
        //System.out.print("\r" + bareDone + bareRemain + " " + remain + "% ");

        System.out.print(ANSI_CYAN + "\rUploading "
                + remain
                + "% "
                + bareDone
                + bareRemain
                + ANSI_RESET);
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


                progressPercentage(percent, 100);

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

    public void deleteFTPFile(String destination) {
        try {
            this.ftp.deleteFile(destination);
            System.out.println(destination + " has been deleted.");
        } catch (IOException e) {
            System.out.println("File doesn't exist");
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
