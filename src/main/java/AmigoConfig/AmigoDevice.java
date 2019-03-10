package AmigoConfig;

import javax.sound.midi.*;
import java.util.List;

public class AmigoDevice {

    MidiDevice InDevice;
    MidiDevice OutDevice;

    public AmigoDevice(MidiDevice.Info InDeviceInfo, MidiDevice.Info OutDeviceInfo) throws MidiUnavailableException {

        InDevice = MidiSystem.getMidiDevice(InDeviceInfo);
        OutDevice = MidiSystem.getMidiDevice(OutDeviceInfo);

        InDevice.getTransmitter().setReceiver(new AmigoReciever(this));

        InDevice.open();
        OutDevice.open();

    }


    public void IncomingMidiMessage(MidiMessage msg){
        int msg_length = msg.getLength();
        byte[] message = msg.getMessage();

        byte status = message[0];
        byte control = message[1];
        byte velocity = message[2];

        SendDeviceMessage(0x90,control, 1);



    }


    public void SendDeviceMessage(int status, int control, int data){
        ShortMessage newMessage = new ShortMessage();

        try {
            newMessage.setMessage(0x90, control, data);
            OutDevice.getReceiver().send(newMessage,-1);

        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }    }

}
