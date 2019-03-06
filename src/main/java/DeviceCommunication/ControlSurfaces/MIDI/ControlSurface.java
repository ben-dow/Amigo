package DeviceCommunication.ControlSurfaces.MIDI;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;
import java.util.Arrays;

public class ControlSurface {

    

    /**
     * Alias method for MidiSystem.getMidiDevice. Fetches the MidiDevice based on an info class
     * @param deviceInfo The Info Object describing the Midi device.
     * @return The Device communication class
     * @throws MidiUnavailableException Throws an error if the midi device is unavailable
     */
    public static MidiDevice FetchMidiDevice(MidiDevice.Info deviceInfo) throws MidiUnavailableException {
        return MidiSystem.getMidiDevice(deviceInfo);
    }

    /**
     *
     * @param Name The String Name of the Device desired to use
     * @return The Midi Device with the Corresponding Name
     * @throws MidiUnavailableException Throws an error if the midi device is unavailable
     */
    public static MidiDevice FetchMidiDevice(String Name) throws MidiUnavailableException {
        ArrayList<MidiDevice.Info> devices = ConnectedMidiDevices();

        for(MidiDevice.Info device : devices){

            if(device.getName().equals(Name)) {
                return MidiSystem.getMidiDevice(device);
            }

        }

        throw new MidiUnavailableException();
    }

    /**
     * Lists the connected Midi Devices to the System
     * @return The list of connected devices
     */
    public static ArrayList<MidiDevice.Info> ConnectedMidiDevices(){
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        return new ArrayList<MidiDevice.Info>(Arrays.asList(infos));
    }


}
