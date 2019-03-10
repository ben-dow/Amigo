package AmigoConfig;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

public class AmigoReciever implements Receiver {

    private AmigoDevice device;

    public AmigoReciever(AmigoDevice DeviceConfiguration){
        device = DeviceConfiguration;
    }

    public void send(MidiMessage message, long timeStamp) {

        device.IncomingMidiMessage(message);

    }

    public void close() {

    }
}
