package AmigoConfig;

import AmigoConfig.Components.AmigoComponent;
import AmigoConfig.Components.BacklightButton;
import AmigoConfig.Components.Button;
import AmigoConfig.Components.ColorBacklightButton;

import javax.sound.midi.*;

public class AmigoDevice {

    MidiDevice InDevice;
    MidiDevice OutDevice;

    AmigoComponent DeviceState;


    /**
     *
     * @param InDeviceInfo For Recieveing Data in - Has Max Recievers as 0 and Max Transmitters as -1
     * @param OutDeviceInfo For sending data out - Has Max Recievers at -1 and Max Transmitters as 0
     * @throws MidiUnavailableException
     */
    public AmigoDevice(MidiDevice.Info InDeviceInfo, MidiDevice.Info OutDeviceInfo) throws MidiUnavailableException {

        InDevice = MidiSystem.getMidiDevice(InDeviceInfo);
        OutDevice = MidiSystem.getMidiDevice(OutDeviceInfo);

        InDevice.getTransmitter().setReceiver(new AmigoReciever(this));

        InDevice.open();
        OutDevice.open();

    }

    /**
     *
     * @param msg
     */
    void IncomingMidiMessage(MidiMessage msg){
        int msg_length = msg.getLength();
        byte[] message = msg.getMessage();

        int status = (message[0] & 0xFF);
        int control = (message[1] & 0xFF);
        int velocity = (message[2] & 0xFF);
        

    }

    /**
     *
     * @param status
     * @param control
     * @param data
     */
    public void SendDeviceMessage(int status, int control, int data){
        ShortMessage newMessage = new ShortMessage();

        try {
            newMessage.setMessage(status, control, data);
            OutDevice.getReceiver().send(newMessage,-1);

        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static MidiDevice.Info[] CollectDevices(){

        return MidiSystem.getMidiDeviceInfo();
    }


}
