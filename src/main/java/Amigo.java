
import AmigoConfig.AmigoDevice;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.Vector;

public class Amigo {

    public static void main(String[] args){

        try {
            MidiDevice.Info[] infos  = AmigoDevice.CollectDevices();
            AmigoDevice device = new AmigoDevice(infos[3], infos[2]);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }


    }
}
