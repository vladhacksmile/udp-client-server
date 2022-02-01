import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.net.PortUnreachableException;
import java.nio.ByteBuffer;

public class ResponseHandler extends Thread {

    @Override
    public void run() {
        while(UDPSocketClient.runnable) {
            if (UDPSocketClient.channel.isOpen()) {
                try {
                    byte[] incomingData = new byte[65515];
                    ByteBuffer byteBuffer = ByteBuffer.wrap(incomingData);
                    UDPSocketClient.channel.receive(byteBuffer);
                    byteBuffer.flip();
                    ByteArrayInputStream in = new ByteArrayInputStream(incomingData);
                    ObjectInputStream is = new ObjectInputStream(in);
                    Answer answer = (Answer) is.readObject();
                    if(answer.getAnswer() != null && answer.getAnswer().get(0).equals("connected")) {
                        UDPSocketClient.connected = true;
                        System.out.println(LocaleManager.getBundle().getString("message_connect_to_server"));
                        if (UDPSocketClient.lastCommand != null) {
                            System.out.println(LocaleManager.getBundle().getString("message_resend_command"));
                            UDPSocketClient.send(UDPSocketClient.lastCommand);
                        }
                    } else {
                        if(!Auth.isAuth()) {
                            if(answer.getAnswer() != null) {
                                answer.printArray();
                                if(Main.mainForm.getLobbyForm().isShouldUpdated()) {
                                    Main.mainForm.getLobbyForm().updateCollection();
                                    Main.mainForm.getLobbyForm().setShouldUpdated(false);
                                }
                            } else GUIManager.setCollection(answer.getCollection());
                        }
                        if(!answer.isSuccess()){
                            System.out.println(LocaleManager.getBundle().getString("message_auth_register_warning"));
                           // UDPSocketClient.stop();
                        }
                    }
                    UDPSocketClient.lastCommand = null;
                    //if(!UDPSocketClient.started) {
                        //if ((!answer.isSuccess() && Auth.isAuth()) || (answer.isSuccess() && !Auth.isAuth())) {
                            if(!UDPSocketClient.authorized) {
                                //Auth.auth();
                            } else {
                                //Auth.preAuth();
                            }
                            //continue;
                       // }
                        if (answer.isSuccess() && Auth.isAuth()) {
                            Auth.authorized();
                            Auth.authorizedSucсessful();
                        } else if (!answer.isSuccess() && Auth.isAuth()) {
                            if(!answer.getAnswer().get(0).equals("connected")) {
                                Main.mainForm.getMessageLabel().setText(answer.getAnswer().get(0));
                            } else {
                                Main.mainForm.getMessageLabel().setText(LocaleManager.getBundle().getString("message_connect_to_server"));
                            }
                        }
                   // }
                } catch (PortUnreachableException e) {
                    System.out.print(LocaleManager.getBundle().getString("message_connect_to_server_error"));
                    try {
                        Thread.sleep(1000);
                        System.out.print(".");
                        Thread.sleep(1000);
                        System.out.print(".");
                        Thread.sleep(1000);
                        System.out.print(".\n");
                        UDPSocketClient.connect();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                } catch (ClassNotFoundException e) {
                    System.err.println(LocaleManager.getBundle().getString("message_connect_to_server_class_error"));
                    UDPSocketClient.runnable = false;
                } catch (StreamCorruptedException ignored) {

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
   }
}
