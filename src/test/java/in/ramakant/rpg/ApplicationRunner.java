package in.ramakant.rpg;

import java.io.*;

public class ApplicationRunner {

    private PipedOutputStream pipedOutputStream;
    private PipedInputStream pipedInputStream;
    private ByteArrayOutputStream outputStream;

    public ApplicationRunner()throws IOException{
        pipedOutputStream = new PipedOutputStream();
        pipedInputStream = new PipedInputStream(pipedOutputStream);
        System.setIn(pipedInputStream);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    public void startGame() {
        Thread thread = new Thread("Test Application"){
            @Override public void run(){
                new Application().startGame();}
        };
        thread.setDaemon(true);
        thread.start();
    }

    public void hasDisplayed(String text) throws InterruptedException{
        boolean displayed = false; int tries = 20;
        while(tries>0 && !displayed){
            Thread.sleep(100);
            displayed = outputStream.toString().contains(text);
            tries--;
        }
        if (!displayed){
            throw new AssertionError("Missing text in output: " + text);
        }
    }

    public void userEnters(String userInput) throws IOException{
        pipedOutputStream.write(userInput.getBytes());
    }
}
