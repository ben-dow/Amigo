
import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.Vector;

public class Amigo {

    public static void main(String[] args){


            ShortMessage myMsg = new ShortMessage();

            try {
                myMsg.setMessage(0x90, 0x38,5);
                long timeStamp = -1;

                MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
                MidiDevice device = MidiSystem.getMidiDevice(infos[4]); // You'll have to get the right device for your MIDI controller.
                Receiver rcvr = device.getReceiver();

                device.open();

                rcvr.send(myMsg, timeStamp);

            } catch (InvalidMidiDataException e) {
                e.printStackTrace();
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }

    }
}
